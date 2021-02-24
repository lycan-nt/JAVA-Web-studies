
public class Correntista {
	private int codigo;
	private String nome;
	
	public Correntista () 
	{
		this.codigo = 0;
		this.nome = "";
	}
	
	public Correntista (int codigo, String nome) 
	{
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo (int codigo)
	{
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
