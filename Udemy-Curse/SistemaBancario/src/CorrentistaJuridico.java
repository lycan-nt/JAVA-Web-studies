
public class CorrentistaJuridico extends Correntista{
	
	private String nomeResponsavel;
	
	public CorrentistaJuridico (String nome, String nomeResponsavel) 
	{
		super(nome);
		this.nomeResponsavel = nomeResponsavel;
	}
	
	public void exibiIdentificacao() 
	{
		System.out.println ("Eu sou um correntista Juridico: " + getCodigo() + " - " + getNome());
	}
	
	public String getNomeResponsavel(String nomeResponsavel)
	{
		return nomeResponsavel;
	}
	
	public void setNomeResponsavel(String nomeResponsavel)
	{
		this.nomeResponsavel = nomeResponsavel;
	}
}
