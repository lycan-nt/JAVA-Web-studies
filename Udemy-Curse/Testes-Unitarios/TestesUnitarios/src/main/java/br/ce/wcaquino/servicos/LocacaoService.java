package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

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
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		//Cen�rio
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		Filme filme = new Filme();
		filme.setNome("Guardi�es");
		filme.setPrecoLocacao(10.50);
		filme.setEstoque(1);
		
		//Ac�o
		Locacao locacao = alugarFilme(usuario, filme);
		
		//Verifica��o
		System.out.println("=====Teste de loca��o=====");
		System.out.println("Filme: " + locacao.getFilme().getNome());
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		System.out.println(locacao.getValor() == 10.50);
		System.out.println("Locador: " + locacao.getUsuario().getNome());
		System.out.println("================");
	}
}