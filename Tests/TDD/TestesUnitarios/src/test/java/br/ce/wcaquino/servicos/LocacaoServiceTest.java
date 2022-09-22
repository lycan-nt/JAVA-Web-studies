package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testeLocacao() throws Exception {
		//Cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("User1");
		Filme filme = new Filme("Name", 2, 5.0);
		
		Locacao locacao;
		//acao
		locacao = locacaoService.alugarFilme(usuario, filme);
		
		//verificacao
		error.checkThat(locacao.getValor(),is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	}
	
	@Test(expected = Exception.class)
	public void testeLocacaoFilmeSemEstoque() throws Exception {
		//Cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("User1");
		Filme filme = new Filme("Name", 0, 5.0);
		
		//acao
		locacaoService.alugarFilme(usuario, filme);
	}
	
	@Test()
	public void testeLocacaoFilmeSemEstoque2() {
		//Cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("User1");
		Filme filme = new Filme("Name", 0, 5.0);
		
		//acao
		try {
			locacaoService.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter tido uma exceção!");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque!"));
		}
	}
	
	@Test()
	public void testeLocacaoFilmeSemEstoque3() throws Exception {
		//Cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("User1");
		Filme filme = new Filme("Name", 0, 5.0);
		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque!");
		
		//acao
		locacaoService.alugarFilme(usuario, filme);
		
	}
	
}
