package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {
		//Cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("User1");
		Filme filme = new Filme("Name", 2, 5.0);
		
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		
		//verificacao
		assertThat(locacao.getValor(),is(equalTo(5.0)));
		assertThat(locacao.getValor(),is(not(6.0)));
		assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	}
	
}
