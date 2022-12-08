package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
	private LocacaoDAO locacaoDAO;
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException   {
		
		if (usuario == null) {
			throw new LocadoraException("Usúario vazio");
		}
		
		if (filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		
		verificarEstoqueFilmes(filmes);
		
		Locacao locacao = new Locacao();
		locacao.setFilmeList(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(calcularTotalLocacao(filmes));

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}
		locacao.setDataRetorno(dataEntrega);
		this.locacaoDAO.salvar(locacao);
		return locacao;
	}
	
	private void verificarEstoqueFilmes(List<Filme> filmes) throws FilmeSemEstoqueException {
		for (Filme filme: filmes) {
			if (filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException("Filme " + filme.getNome() + "sem estoque disponivel.");
			}
		}
	}
	
	private double calcularTotalLocacao(List<Filme> filmes) {
		Double total = 0.0;
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			switch (i) {
			case 2: total += filme.getPrecoLocacao() * 0.75;
			break;
			case 3: total += filme.getPrecoLocacao() * 0.5; 
			break;
			case 4: total += filme.getPrecoLocacao() * 0.25;
			break;
			case 5: total += 0;
			break;
			default: total += filme.getPrecoLocacao();
			break;
			}
		}
		return total;
	}

}