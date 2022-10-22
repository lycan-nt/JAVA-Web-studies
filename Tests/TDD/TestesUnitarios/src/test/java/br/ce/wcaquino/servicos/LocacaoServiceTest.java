package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.servicos.matchers.MatchersProprios.caiEm;
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

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.matchers.DiaSemanaMatcher;
import br.ce.wcaquino.servicos.matchers.MatchersProprios;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	private LocacaoService locacaoService;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		locacaoService = new LocacaoService();
	}
	
	@Test
	public void deveAlugarFilme() throws Exception {
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		//Cenario
		Usuario usuario = new Usuario("User1");
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = new Filme("Name", 2, 5.0);
		filmeList.add(filme1);
		
		Locacao locacao;
		//acao
		locacao = this.locacaoService.alugarFilme(usuario, filmeList);
		
		//verificacao
		error.checkThat(locacao.getValor(),is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void deveLancarExecaoAoLancarFilmeSemEstoque() throws Exception {
		//Cenario
		Usuario usuario = new Usuario("User1");
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = new Filme("Name", 0, 5.0);
		filmeList.add(filme1);
		
		//acao
		this.locacaoService.alugarFilme(usuario, filmeList);
	}
	
	@Test
	public void deveLancarExecaoSemUsuario() throws FilmeSemEstoqueException {
		//Cenario
		List<Filme> filmeList = new ArrayList<Filme>();
		Filme filme1 = new Filme("Name", 1, 5.0);
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
		Usuario usuario = new Usuario("User1");
		
		//Ação
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		this.locacaoService.alugarFilme(usuario, null);
	}
	
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//Cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
		//Acao
		Locacao retorno = locacaoService.alugarFilme(usuario, filmes);
		//Verificacao
		//assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
		assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
	}
}
