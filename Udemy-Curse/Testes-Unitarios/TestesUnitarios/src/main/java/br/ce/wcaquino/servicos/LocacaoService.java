package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;
import java.util.Date;
import java.util.List;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.com.wcaquino.exceptions.FilmeSemEstoqueException;
import br.com.wcaquino.exceptions.LocadoraException;

public class LocacaoService {
	
	public static Locacao alugarFilme(Usuario usuario, List<Filme> listFilme) throws FilmeSemEstoqueException, LocadoraException  {
		if (listFilme.isEmpty() || listFilme == null) {
			throw new LocadoraException("Nenhum filme encontrado.");
		}
		
		for (Filme filme: listFilme) {
			if (filme.getEstoque() == 0){
				throw new FilmeSemEstoqueException();
			}
		}
		
		if (usuario == null) {
			throw new LocadoraException("Nenhum usuario encontrado.");
		}
			
		Locacao locacao = new Locacao();
		locacao.setFilme(listFilme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(calcularLocacao(listFilme));
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}
	
	private static Double calcularLocacao(List<Filme> listFilme) {
		Double precoLocacao = 0.0;
		for (Filme filme: listFilme) {
			precoLocacao += filme.getPrecoLocacao();
		}
		return precoLocacao;
	}

}