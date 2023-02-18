
public abstract class Correntista {
	private static int proxCod = 1;
	private Conta conta;
	private int codigo;
	private String nome;
	
	public Correntista (String nome, Conta conta) 
	{
		this.codigo = getProxCod();
		this.nome = nome;
		this.conta = conta;
	}
	
	public abstract void exibiIdentificacao();
	
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
	
	public Conta getConta()
	{
		return conta;
	}
	
	public void setConta (Conta conta)
	{
		this.conta = conta;
	}
}
