package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.buiders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.buiders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.servicos.matchers.MatchersProprios.caiEm;
import static br.ce.wcaquino.servicos.matchers.MatchersProprios.ehHojeComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import br.ce.wcaquino.buiders.FilmeBuilder;
import br.ce.wcaquino.buiders.LocacaoBuilder;
import br.ce.wcaquino.buiders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	private LocacaoService locacaoService;
	private LocacaoDAO locacaoDAO;
	private ISPCService spcIspcService;
	private IEmailService emailService;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		this.locacaoService = new LocacaoService();
		this.locacaoDAO = Mockito.mock(LocacaoDAO.class);
		this.spcIspcService = Mockito.mock(ISPCService.class);
		this.emailService = Mockito.mock(IEmailService.class);
		locacaoService.setLocacaoDAO(locacaoDAO);
		locacaoService.setSPCService(spcIspcService);
		locacaoService.setEmailService(emailService);
	}
	
	@Test
	public void deveAlugarFilme() throws Exception {
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		//Cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = umFilme().comValor(5.0).agora();
		filmeList.add(filme1);
		
		Locacao locacao;
		//acao
		locacao = this.locacaoService.alugarFilme(usuario, filmeList);
		
		//verificacao
		error.checkThat(locacao.getValor(),is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		error.checkThat(locacao.getDataRetorno(), ehHojeComDiferencaDias(1));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void deveLancarExecaoAoLancarFilmeSemEstoque() throws Exception {
		//Cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = FilmeBuilder.umFilmeSemEstoque().agora();
		filmeList.add(filme1);
		
		//acao
		this.locacaoService.alugarFilme(usuario, filmeList);
	}
	
	@Test
	public void deveLancarExecaoSemUsuario() throws FilmeSemEstoqueException {
		//Cenario
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = umFilme().agora();
		filmeList.add(filme1);
		
		//Ação
		try {
			this.locacaoService.alugarFilme(null, filmeList);
			Assert.fail();
		}catch (LocadoraException e) {
			// TODO Auto-generated catch block
			Assert.assertThat(e.getMessage(), is("Usúario vazio"));
		}
	}
	
	@Test
	public void deveLancarExecaoFilmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//Cenario
		Usuario usuario = umUsuario().agora();
		
		//Ação
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		this.locacaoService.alugarFilme(usuario, null);
	}
	
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//Cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		//Acao
		Locacao retorno = locacaoService.alugarFilme(usuario, filmes);
		//Verificacao
		//assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
		assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
	}
	
	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC() throws FilmeSemEstoqueException{
		//Cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		//Parametros de execulção
		Mockito.when(this.spcIspcService.possuiNegativacao(usuario)).thenReturn(true);	
		//Ação
		try {
			this.locacaoService.alugarFilme(usuario, filmes);
			//Verificação
			Assert.fail();
		}
		catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuário negativado"));
		}
		Mockito.verify(this.spcIspcService).possuiNegativacao(usuario);
	}
	
	@Test
	public void deveEnviarEmailParaLocacoesAtrasadas() {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Locacao> locacaoes = 
				Arrays.asList(
					new LocacaoBuilder()
						.comUsuario(usuario)
						.comDataRetorno(DataUtils.obterDataComDiferencaDias(-2))
					.agora());
		Mockito.when(this.locacaoDAO.obterLocacoesPendentes()).thenReturn(locacaoes);
		//ação
		this.locacaoService.notificarAtrasos();
		//verificação
		Mockito.verify(this.emailService).notificicarAtraso(usuario);
		
	}
}
