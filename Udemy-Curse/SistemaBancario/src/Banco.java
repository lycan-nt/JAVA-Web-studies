
public class Banco {
	public static void main(String args[]) {
		Correntista c = new Correntista("Felipe");

		Correntista c2 = new Correntista("Marcella");
		
		System.out.println("Name: " + c.getNome() + " " + "Cod: " + c.getCodigo());

		System.out.println("Name: " + c2.getNome() + " " + "Cod: " + c2.getCodigo());
	}
}
