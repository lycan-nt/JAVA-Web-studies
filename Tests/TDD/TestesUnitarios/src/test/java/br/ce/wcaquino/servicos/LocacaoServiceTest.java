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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.buiders.FilmeBuilder;
import br.ce.wcaquino.buiders.LocacaoBuilder;
import br.ce.wcaquino.buiders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.matchers.MatchersProprios;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@InjectMocks
	private LocacaoService locacaoService;
	@Mock
	private LocacaoDAO locacaoDAO;
	@Mock
	private ISPCService spcIspcService;
	@Mock
	private IEmailService emailService;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
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
	public void naoDeveAlugarFilmeParaNegativadoSPC() throws Exception{
		//Cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		//Parametros de execulção
		Mockito.when(this.spcIspcService.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);	
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
		Usuario usuario2 = UsuarioBuilder.umUsuario().comNome("Marcella").agora();
		Usuario usuario3 = UsuarioBuilder.umUsuario().comNome("Felipe").agora();
		List<Locacao> locacaoes = 
				Arrays.asList(
						new LocacaoBuilder().comUsuario(usuario).atrasado().agora(),
						new LocacaoBuilder().comUsuario(usuario2).agora(),
						new LocacaoBuilder().comUsuario(usuario3).atrasado().agora(),
						new LocacaoBuilder().comUsuario(usuario3).atrasado().agora()
					);
		Mockito.when(this.locacaoDAO.obterLocacoesPendentes()).thenReturn(locacaoes);
		//ação
		this.locacaoService.notificarAtrasos();
		//verificação
		Mockito.verify(this.emailService).notificicarAtraso(usuario);
		Mockito.verify(this.emailService, Mockito.atLeastOnce()).notificicarAtraso(usuario3);
		Mockito.verify(this.emailService, Mockito.times(3)).notificicarAtraso(Mockito.any(Usuario.class));
		Mockito.verify(this.emailService, Mockito.never()).notificicarAtraso(usuario2);
		Mockito.verifyNoMoreInteractions(this.emailService);
		
	}
	
	@Test
	public void deveTratarErroNoSpc() throws Exception {
		//Cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		Mockito.when(this.spcIspcService.possuiNegativacao(usuario)).thenThrow(new Exception("Erro desconhecido"));
		//Verificação
		this.exception.expect(LocadoraException.class);
		this.exception.expectMessage("Problemas com SPC, tente novamente.");
		//Ação
		this.locacaoService.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void deveProrrogarLocacao() {
		//Cenario
		Locacao locacao = new LocacaoBuilder().agora();
		//Acao
		this.locacaoService.prorrogarLocacao(locacao, 3);
		//Locacao
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
		Mockito.verify(this.locacaoDAO).salvar(argCapt.capture());
		Locacao locacaoRetorno = argCapt.getValue();
		this.error.checkThat(locacaoRetorno.getValor(), is(30.0));
		this.error.checkThat(locacaoRetorno.getDataLocacao(), MatchersProprios.ehHoje());
		this.error.checkThat(locacaoRetorno.getDataRetorno(), MatchersProprios.ehHojeComDiferencaDias(3));
	}
}
