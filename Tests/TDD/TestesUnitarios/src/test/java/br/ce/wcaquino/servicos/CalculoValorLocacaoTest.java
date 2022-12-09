package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.buiders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.buiders.UsuarioBuilder.umUsuario;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.daos.LocacaoDAOFake;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

	private LocacaoService locacaoService;
	private LocacaoDAO locacaoDAO;
	private ISPCService spcIspcService;
	@Parameter
	public List<Filme> filmeList;
	@Parameter(value=1)
	public Double valorLocacao;
	@Parameter(value=2)
	public String cenario;
	
	@Before
	public void setup() {
		this.locacaoService = new LocacaoService();
		this.locacaoDAO = Mockito.mock(LocacaoDAO.class);
		this.spcIspcService = Mockito.mock(ISPCService.class);
		locacaoService.setLocacaoDAO(locacaoDAO);
		locacaoService.setSPCService(spcIspcService); 
	}
	
	private static Filme filme1 = umFilme().agora();;
	private static Filme filme2 = umFilme().agora();;
	private static Filme filme3 = umFilme().agora();;
	private static Filme filme4 = umFilme().agora();;
	private static Filme filme5 = umFilme().agora();;
	private static Filme filme6 = umFilme().agora();;
	private static Filme filme7 = umFilme().agora();;
	
	@Parameters(name="{2}")
	public static Collection<Object[]> getParametros() {
		return Arrays.asList(new Object[][] {
			{Arrays.asList(filme1, filme2), 8.0, "2 Filmes Sem Desconto"},
			{Arrays.asList(filme1, filme2, filme3), 11.0, "3 Filmes 25%"},
			{Arrays.asList(filme1, filme2, filme3, filme4), 13.0, "4 Filmes 50%"},
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5), 14.0, "5 Filmes 75%"},
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 14.0, "6 Filmes 100%"},
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6, filme7), 18.0, "7 Filmes Sem Desconto"}
		});
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		//Cenario
		Usuario usuario = umUsuario().agora();
		
		//Acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filmeList);
		
		//Verificacao
		Assert.assertThat(locacao.getValor(), is(valorLocacao));
	}
	
}
