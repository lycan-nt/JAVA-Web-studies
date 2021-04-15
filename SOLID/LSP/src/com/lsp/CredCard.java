package com.lsp;

public class CredCard extends NubankCard{
    @Override
    public void validat() throws Exception
    {
        //Validação do cartao de credito
        System.out.println("Validando limit...");
        System.out.println("Limit ok.");
    }
}
