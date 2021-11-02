package br.ce.wcaquino.servicos;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.com.wcaquino.exceptions.FilmeSemEstoqueException;
import br.com.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {
	
	@Parameter
	public List<Filme> listFilme;
	@Parameter(value=1)
	public Double valorLocacao;
	@Parameter(value=2)
	public String cenario;
	private LocacaoService locacaoService; 
	
	@Before
	public void setup() {
		locacaoService = new LocacaoService();
	}
	
	private static Filme filme1 = new Filme("Filme 1", 2, 10.00);
	private static Filme filme2 = new Filme("Filme 2", 1, 10.00);
	private static Filme filme3 = new Filme("Filme 3", 3, 10.00);
	private static Filme filme4 = new Filme("Filme 4", 3, 10.00);
	private static Filme filme5 = new Filme("Filme 5", 3, 10.00);
	private static Filme filme6 = new Filme("Filme 6", 3, 10.00);
	
	@Parameters(name="{2}")
	public static Collection<Object[]> getParametros(){
		return Arrays.asList(new Object[][] {
			{Arrays.asList(filme1, filme2, filme3), 27.50, "3 Filmes 25%"},
			{Arrays.asList(filme1, filme2, filme3, filme4), 35.00, "4 Filmes 50%"},
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5), 42.50, "5 Filmes 75%"},
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 50.00, "6 Filmes 100%"}
		});
	}
 
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@SuppressWarnings("static-access")
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		//Cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe D. Santos");
		
		//Acao
		Locacao locacao =locacaoService.alugarFilme(usuario, listFilme);
		
		//Verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(valorLocacao));
		
	}
}
