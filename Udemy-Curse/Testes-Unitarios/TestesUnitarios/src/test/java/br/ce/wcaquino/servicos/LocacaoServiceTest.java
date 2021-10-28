package br.ce.wcaquino.servicos;

import java.util.Date;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
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
		Locacao locacao = LocacaoService.alugarFilme(usuario, filme);
		
		//Verificação
		error.checkThat(locacao.getValor(), CoreMatchers.is(10.50));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));

	}
}
