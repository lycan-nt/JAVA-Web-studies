package com.calculator;

public class calculator {
		//Variável "res" armazena o resultado corrente da calculadora.
		private	double res;
		

	    public calculator () {
	        this.res = 0.0;
	    }
		
		/*Esta função recebe um valor do tipo double como parâmetro e
		soma com o valor contido na variável "res" da classe.
		O retorno da função é o resultado corrente da calculadora.*/
		public double soma(double num) {
			//IMPLEMENTAR ESTE MÉTODO DE ACORDO COM O ENUNCIADO.
			return this.res += num;
				
		}
			
		/*Esta função recebe um valor do tipo double como parâmetro e
		subtrai do valor contido na variável "res" da classe.
		O retorno da função é o resultado corrente da calculadora.*/
		public double subtrai(double num) {
			//IMPLEMENTAR ESTE MÉTODO DE ACORDO COM O ENUNCIADO.
			return this.res -= num;
				
		}
			
		/*Esta função recebe um valor do tipo double como parâmetro e
		multiplica com o valor contido na variável "res" da classe.
		O retorno da função é o resultado corrente da calculadora.*/
		public double multiplica(double num) {
			//IMPLEMENTAR ESTE MÉTODO DE ACORDO COM O ENUNCIADO.
			return this.res = this.res * num;
				
		}
			
		/*Esta função recebe um valor do tipo double como parâmetro e
		divide o valor contido na variável "res" da classe.
		O retorno da função é o resultado corrente da calculadora.*/
		public double divide(double num) {
			//IMPLEMENTAR ESTE MÉTODO DE ACORDO COM O ENUNCIADO.
			return this.res = this.res / num;	
		}
}
