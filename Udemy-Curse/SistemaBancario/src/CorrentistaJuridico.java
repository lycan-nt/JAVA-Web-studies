
public class CorrentistaJuridico extends Correntista{
	
	private String nomeResponsavel;
	
	public CorrentistaJuridico (String nome, String nomeResponsaString) 
	{
		super(nome);
		this.nomeResponsavel = nomeResponsaString;
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
