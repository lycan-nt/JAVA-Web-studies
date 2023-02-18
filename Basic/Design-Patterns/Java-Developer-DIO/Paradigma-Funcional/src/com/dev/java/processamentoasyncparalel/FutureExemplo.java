package com.dev.java.processamentoasyncparalel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExemplo {
    private static final ExecutorService pessoaParaAtividades = Executors.newFixedThreadPool( 3);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        casa.obterAfazeresDaCasa().forEach( ativade -> pessoaParaAtividades.submit(() -> ativade.realizar()) );
        pessoaParaAtividades.shutdownNow();
    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) { this.comodos = Arrays.asList(comodos); }

    List<Atividade> obterAfazeresDaCasa()
    {
        return this.comodos.stream()
                .map(Comodo::obterAfazeresDaCasa)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    void realizar();
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDaCasa();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDaCasa() {
        return Arrays.asList(
                this::getArrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private void arrumarGuardaRoupa()
    {
        System.out.println("Arrumar o guarda roupa");
    }

    private void varrerOQuarto()
    {
        System.out.println("Varrer o quarto");
    }

    private void getArrumarACama()
    {
        System.out.println("Arrumar a cama");
    }
}

