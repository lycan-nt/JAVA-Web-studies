package com.owl.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Condutor {

	public static void main(String[] args) {
		Condutor condutor = new Condutor(new Carro());
		condutor.automovel();
	}
	
	@Autowired
	private IVeiculo veiculo;
	
	public Condutor(IVeiculo obj) {
		this.veiculo = obj;
	}
	
	public void automovel() {
		veiculo.acao();
	}

}
