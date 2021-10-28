package br.ce.wcaquino.servicos;


import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	@Test
	public void teste() {
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
		System.out.println("=====Teste de loca��o=====");
		System.out.println("Filme: " + locacao.getFilme().getNome());
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		Assert.assertThat(locacao.getValor(), CoreMatchers.is(10.50));
		System.out.println("Locador: " + locacao.getUsuario().getNome());
		System.out.println("================");
	}
}
