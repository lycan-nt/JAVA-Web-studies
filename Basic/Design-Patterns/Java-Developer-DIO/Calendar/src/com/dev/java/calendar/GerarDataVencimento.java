package com.dev.java.calendar;

import java.util.Calendar;

public class GerarDataVencimento {
    Calendar dataVencimento;
    int diaSemJuros;

    public GerarDataVencimento(Calendar dataVencimento, int diaSemJuros)
    {
        this.dataVencimento = dataVencimento;
        this.diaSemJuros = diaSemJuros;
    }

    protected Calendar calcularDataVencimento() throws Exception
    {
        Calendar dataAtual = Calendar.getInstance();
        this.dataVencimento.add(Calendar.DATE, this.diaSemJuros);

        if (dataVencimento.before(dataAtual))
        {
            throw new Exception("Não e possivel gerar uma nova data este pagamento já ultrapassou o prazo!");
        }
        return dataVencimento;
    }
}
