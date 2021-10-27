package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
	public static Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}

	@Test
	public void teste() {
		//Cenário
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		Filme filme = new Filme();
		filme.setNome("Guardiões");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
		
		//Acão
		Locacao locacao = alugarFilme(usuario, filme);
		
		//Verificação
		System.out.println("=====Teste de locação=====");
		System.out.println("Filme: " + locacao.getFilme().getNome());
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		Assert.assertTrue(locacao.getValor() == 10.50);
		System.out.println("Locador: " + locacao.getUsuario().getNome());
		System.out.println("================");
	}
}