package osn.study.coesao;

public class QuinzeOuVinteCincoPorCento implements RegraDeCalculo{

    public double calcula(Funcionario funcionario)
    {
        if (funcionario.getSalarioBase() > 2000.0)
        {
            return funcionario.getSalarioBase() * 0.79;
        }
        else
        {
            return funcionario.getSalarioBase() * 0.85;
        }
    }

}
