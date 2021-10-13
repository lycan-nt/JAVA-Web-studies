package osn.study.lsp;

public class Gerente extends Funcionario{
    private String placaDoCaroo;

    public double bonus()
    {
        return this.salario * 0.3;
    }
}
