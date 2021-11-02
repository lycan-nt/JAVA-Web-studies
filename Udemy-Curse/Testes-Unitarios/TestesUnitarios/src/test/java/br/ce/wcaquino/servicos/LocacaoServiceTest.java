package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hamcrest.CoreMatchers;
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
import br.ce.wcaquino.utils.DataUtils;
import br.com.wcaquino.exceptions.FilmeSemEstoqueException;
import br.com.wcaquino.exceptions.LocadoraException;

public class LocacaoServiceTest {
	
	private LocacaoService locacaoService; 
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void setup() {
		locacaoService = new LocacaoService();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void teste() throws Exception {
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//Cenário
		List<Filme> listFilme = new ArrayList<Filme>();
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		Filme filme1 = new Filme();
		filme1.setNome("Guardiões");
		filme1.setPrecoLocacao(10.50);
		filme1.setEstoque(1);
		listFilme.add(filme1);
		
		Filme filme2 = new Filme();
		filme2.setNome("Da Galaxia");
		filme2.setPrecoLocacao(10.50);
		filme2.setEstoque(1);
		listFilme.add(filme2);
		
		//Acão
		Locacao locacao = locacaoService.alugarFilme(usuario, listFilme);
		
		//Verificação
		error.checkThat(locacao.getValor(), CoreMatchers.is(21.00));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));

	}
	
	@SuppressWarnings("static-access")
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception {
		//Cenário
		List<Filme> listFilme = new ArrayList<Filme>();
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		Filme filme = new Filme();
		filme.setNome("Guardiões");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(0);
		listFilme.add(filme);
				
		//Acão
		locacaoService.alugarFilme(usuario, listFilme);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		//Cenário
		List<Filme> listFilme = new ArrayList<Filme>();
		Filme filme = new Filme();
		filme.setNome("Guardiões");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
		listFilme.add(filme);
		
		//Ação
		try {
			locacaoService.alugarFilme(null, listFilme);
			Assert.fail("Aqui deveria ter ocorrido um erro");
		}
		catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Nenhum usuario encontrado."));
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testeLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//Cenário
		List<Filme> listFilme = new ArrayList<Filme>();
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Nenhum filme encontrado.");
		
		//Ação
		locacaoService.alugarFilme(usuario, listFilme);
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void naoDeveDevolverFilmeNoDomingo() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		//Cenario
		List<Filme> listFilme = new ArrayList<Filme>();
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		Filme filme1 = new Filme();
		filme1.setNome("Guardiões");
		filme1.setPrecoLocacao(10.00);
		filme1.setEstoque(1);
		listFilme.add(filme1);
		
		//acao
		Locacao locacao =locacaoService.alugarFilme(usuario, listFilme);
		
		//verificacao
		assertThat(locacao.getDataRetorno(), caiNumaSegunda());
		
	}
}
