
public interface Conta {
	
	public void extrato();
	
	public void deposito (double valor);
	
	public void saque (double valor);
	
	//cf=Capital financiado | n=Meses
	public double simulaEmprestimo (double cf, int n);
}
