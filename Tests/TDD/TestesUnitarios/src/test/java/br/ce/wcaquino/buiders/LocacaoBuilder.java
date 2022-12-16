package br.ce.wcaquino.buiders;

import static br.ce.wcaquino.buiders.FilmeBuilder.umFilme;

import java.util.Arrays;
import java.util.Date;

import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoBuilder {
	private Locacao locacao;
	
	public LocacaoBuilder() {
		this.locacao = new Locacao();
	}
	
	public LocacaoBuilder comDataRetorno(Date dateRetorno) {
		this.locacao.setDataLocacao(DataUtils.obterDataComDiferencaDias(-10));
		this.locacao.setDataRetorno(dateRetorno);
		this.locacao.setFilmeList(Arrays.asList(umFilme().agora(), umFilme().agora()));
		this.locacao.setValor(100.0);
		return this;
	}
	
	public LocacaoBuilder comUsuario(Usuario usuario) {
		this.locacao.setUsuario(usuario);
		return this;
	}
	
	public Locacao agora() {
		return this.locacao;
	}
}
