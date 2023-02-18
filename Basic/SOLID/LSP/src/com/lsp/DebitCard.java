package com.lsp;

public class DebitCard extends NubankCard{
    @Override
    public void validat() throws Exception {
        System.out.println("Verificando saldo...");
        System.out.println("Saldo disponivel");
    }
}
