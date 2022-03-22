package osn.study.ocp;

import java.util.Locale;

public class Frete1 implements ServicoDeEntrega{

    public double para(String cidade)
    {
       if ("SAO PAULO".equals(cidade.toUpperCase()))
       {
           return 15;
       }

       return 30;
    }

}
