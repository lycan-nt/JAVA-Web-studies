
public class CorrentistaFisico extends Correntista{
	
	public CorrentistaFisico (String nome) 
	{
		super(nome);
	}
	
	public void exibiIdentificacao() 
	{
		System.out.println ("Eu sou um correntista Fisico: " + getCodigo() + " - " + getNome());
	}
}
