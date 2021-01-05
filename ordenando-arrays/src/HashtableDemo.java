import java.util.Arrays;
import java.util.Collections;

public class HashtableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] companies = { "Yahoo", "Vodafone", "Samsung" };

		// sorting java array in ascending order
		System.out.println("Exemplo de Ordenção Crescente em Java");
		System.out.println("Array de String Desordenada: ");
		printNumbers(companies);
		Arrays.sort(companies);
		System.out.println("Array de String Ordenada em Ordem Crescente: ");
		printNumbers(companies);

		// sorting java array in descending order
		System.out.println("Exemplo de Ordenção Decrescente em Java ");
		System.out.println("Array de String Desordenada: ");
		printNumbers(companies);
		Arrays.sort(companies, Collections.reverseOrder());
		System.out.println("Array de String Ordenada em Ordem Decrescente: ");
		printNumbers(companies);

		System.out.println("Classificando parte do Array em Java:");
		int[] numbers = { 1, 3, 2, 5, 4 };
		Arrays.sort(numbers, 0, 3);
		System.out.println("Sub Array Classificado em Java: ");
		for (int num : numbers) {
		System.out.println(num);
		}

		}

		public static void printNumbers(String[] companies) {
		for (String company : companies) {
		System.out.println(company);
		}
	}

}
