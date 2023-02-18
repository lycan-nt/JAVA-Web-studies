package osn.study.acomplhamento;

public class NotaFiscal {
    private String produto;
    private double valor;
    private double impostoSimplesSobreOValor;

    public NotaFiscal(String produto, double valor, double impostoSimplesSobreOValor)
    {
        this.produto = produto;
        this.valor = valor;
        this.impostoSimplesSobreOValor = impostoSimplesSobreOValor;
    }

    public String getProduto()
    {
        return this.produto;
    }
    public void setProduto(String produto)
    {
        this.produto = produto;
    }

    public double getValor()
    {
        return this.valor;
    }
    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public double getImpostoSimplesSobreOValor()
    {
        return this.impostoSimplesSobreOValor;
    }
    public void setImpostoSimplesSobreOValor(double impostoSimplesSobreOValor)
    {
        this.impostoSimplesSobreOValor = impostoSimplesSobreOValor;
    }
}
