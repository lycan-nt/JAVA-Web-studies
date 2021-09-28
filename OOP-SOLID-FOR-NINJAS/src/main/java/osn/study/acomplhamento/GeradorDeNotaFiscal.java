package osn.study.acomplhamento;

import java.util.List;

public class GeradorDeNotaFiscal {
    private final List<AcaoAposGerarNota> acoes;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes)
    {
        this.acoes = acoes;
    }

    public NotaFiscal gerar(Fatura fatura)
    {
        double valor = fatura.getValorMensal();

        NotaFiscal notaFiscal = new NotaFiscal(
                "NoteBook",
                valor,
                importoSimplesSobreO(valor)
        );

        for (AcaoAposGerarNota acao : acoes)
        {
            acao.executar(notaFiscal);
        }

        return notaFiscal;
    }

    private double importoSimplesSobreO(double valor)
    {
        return valor * 0.06;
    }
}
