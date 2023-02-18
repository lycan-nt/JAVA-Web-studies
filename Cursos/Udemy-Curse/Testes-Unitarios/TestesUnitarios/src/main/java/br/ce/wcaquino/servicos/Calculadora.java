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
			throw new CalculadoraException("Não e possivel realizar a divisão por 0.");
		}
		
		return a / b;
	}

}
