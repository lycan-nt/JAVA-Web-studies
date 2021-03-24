import java.util.ArrayList;

public class Banco {
	public static void main(String args[]) {
		ArrayList<Correntista> listaClientes = new ArrayList<Correntista>();
		
		Correntista c = new CorrentistaFisico("Felipe", new ContaFisica());
		listaClientes.add(c);
		
		Correntista c2 = new CorrentistaFisico("Marcella", new ContaFisica());
		listaClientes.add(c2);
		
		CorrentistaJuridico c3 = new CorrentistaJuridico("Sys-Ala", "Alailton", new ContaJuridica());
		listaClientes.add(c3);
		
		c.exibiIdentificacao();
		c2.exibiIdentificacao();
		c3.exibiIdentificacao();
	}
}
