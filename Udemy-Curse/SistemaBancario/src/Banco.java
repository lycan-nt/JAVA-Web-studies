import java.util.ArrayList;

public class Banco {
	public static void main(String args[]) {
		ArrayList<Correntista> listaClientes = new ArrayList<Correntista>();
		
		Correntista c = new CorrentistaFisico("Felipe");
		listaClientes.add(c);
		
		Correntista c2 = new CorrentistaFisico("Marcella");
		listaClientes.add(c2);
		
		CorrentistaJuridico c3 = new CorrentistaJuridico("Sys-Ala", "Alailton");
		listaClientes.add(c3);
		
		System.out.println("Name: " + c.getNome() + " " + "Cod: " + c.getCodigo());
		System.out.println("Name: " + c2.getNome() + " " + "Cod: " + c2.getCodigo());
	}
}
