package br.ce.wcaquino.servicos;

import java.util.Date;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
		
		//Ac�o
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		
		//Verifica��o
		error.checkThat(locacao.getValor(), CoreMatchers.is(10.50));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));

	}
	
	@SuppressWarnings("static-access")
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception {
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(0);
				
		//Ac�o
		locacaoService.alugarFilme(usuario, filme);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		//Cen�rio
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
		
		//A��o
		try {
			locacaoService.alugarFilme(null, filme);
			Assert.fail("Aqui deveria ter ocorrido um erro");
		}
		catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Nenhum usuario encontrado."));
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testeLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//Cen�rio
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Nenhum filme contrado.");
		
		//A��o
		locacaoService.alugarFilme(usuario, null);
		
	}
}
