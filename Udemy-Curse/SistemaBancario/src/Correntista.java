
public class Correntista {
	private static int proxCod = 1;
	private int codigo;
	private String nome;
	
	public Correntista (String nome) 
	{
		this.codigo = getProxCod();
		this.nome = nome;
	}
	
	public void exibiIdentificacao() 
	{
		System.out.println ("Eu sou um correntista: " + getCodigo() + " - " + getNome());
	}
	
	public static int getProxCod()
	{
		return proxCod++;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
