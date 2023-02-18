
public class CorrentistaFisico extends Correntista{
	
	public CorrentistaFisico (String nome, ContaFisica conta) 
	{
		super(nome, conta);
	}
	
	public void exibiIdentificacao() 
	{
		System.out.println ("Eu sou um correntista Fisico: " + getCodigo() + " - " + getNome());
	}
}
