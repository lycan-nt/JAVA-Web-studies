package digital.innovation.one.ultils.operacao;

import digital.innovation.one.ultils.operacao.internal.DivHelper;
import digital.innovation.one.ultils.operacao.internal.MultHelper;
import digital.innovation.one.ultils.operacao.internal.SubHelper;
import digital.innovation.one.ultils.operacao.internal.SunHelper;

public class Calculadora {

    private SunHelper somar;
    private SubHelper subtrair;
    private MultHelper multiplicar;
    private DivHelper dividir;

    public Calculadora()
    {
        somar = new SunHelper();
        subtrair = new SubHelper();
        multiplicar = new MultHelper();
        dividir = new DivHelper();
    }

    public int sun(int a, int b)
    {
        return somar.execulte(a, b);
    }

    public int sub(int a, int b)
    {
        return subtrair.execulte(a, b);
    }

    public int mult(int a, int b)
    {
        return multiplicar.execulte(a, b);
    }

    public int div(int a, int b)
    {
        return dividir.execulte(a, b);
    }

}
