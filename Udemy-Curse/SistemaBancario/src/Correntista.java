
public class Correntista {
	private static int proxCod = 1;
	private int codigo;
	private String nome;
	
	public Correntista (String nome) 
	{
		this.codigo = proxCod;
		proxCod++;
		this.nome = nome;
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
