package com.lsp;

abstract public class NubankCard implements IPaymentInstrument{
    public void validat() throws Exception
    {
        //Validação basica
    }
    public void collectPayment()
    {
        System.out.println("Pagamento realizado!");
    }
}
