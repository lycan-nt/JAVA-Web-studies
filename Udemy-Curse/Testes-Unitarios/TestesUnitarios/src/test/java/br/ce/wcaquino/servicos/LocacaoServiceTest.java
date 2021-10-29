package br.ce.wcaquino.servicos;

import java.util.Date;
import org.hamcrest.CoreMatchers;
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
	public ExpectedException expectedException = ExpectedException.none();
	
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
		Locacao locacao = LocacaoService.alugarFilme(usuario, filme);
		
		//Verifica��o
		error.checkThat(locacao.getValor(), CoreMatchers.is(10.50));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));

	}
	
	@Test(expected = Exception.class)
	public void testLocacao_filmeSemEstoque() throws Exception {
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(0);
				
		//Ac�o
		Locacao locacao = LocacaoService.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testLocacao_filmeSemEstoque_2(){
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
				
		//Ac�o
		try {
			Locacao locacao = LocacaoService.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter tido uma expetion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Filme sem estoque"));
		}
	}
	
	@Test
	public void testLocacao_filmeSemEstoque_3() throws Exception {
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
				
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(0);
				
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Filme sem estoque");
		
		//Ac�o
		Locacao locacao = LocacaoService.alugarFilme(usuario, filme);
		

	}
}
