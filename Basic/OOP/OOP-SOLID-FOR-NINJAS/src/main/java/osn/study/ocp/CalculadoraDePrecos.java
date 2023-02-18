package osn.study.ocp;

public class CalculadoraDePrecos {

    private TabelaDePreco tabelaDePreco;
    private ServicoDeEntrega servicoDeEntrega;

    public CalculadoraDePrecos(TabelaDePreco tabelaDePreco, ServicoDeEntrega servicoDeEntrega)
    {
        this.tabelaDePreco = tabelaDePreco;
        this.servicoDeEntrega = servicoDeEntrega;
    }

    public double calcula(Compra produto)
    {
        double desconto = tabelaDePreco.descontoPara(produto.getValor());
        double frete = servicoDeEntrega.para(produto.getCidade());

        return produto.getValor() * (1 - desconto) + frete;
    }

}
