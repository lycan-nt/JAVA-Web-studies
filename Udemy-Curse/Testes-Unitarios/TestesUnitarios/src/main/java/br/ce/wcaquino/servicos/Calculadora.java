package br.ce.wcaquino.servicos;

import br.com.wcaquino.exceptions.CalculadoraException;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int dividir(int a, int b) throws CalculadoraException {
		if (b == 0) {
			throw new CalculadoraException("N�o e possivel realizar a divis�o por 0.");
		}
		
		return a / b;
	}

}
