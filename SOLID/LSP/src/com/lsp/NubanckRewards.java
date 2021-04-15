package com.lsp;

public class NubanckRewards implements IPaymentInstrument{
    @Override
    public void validat() throws Exception
    {
        //Validators
        System.out.println("Limite ok! Rewars ok!");
    }

    @Override
    public void collectPayment()
    {
        System.out.println("Pagamento realizado com sucesso");
        System.out.println("Pontos add");
    }
}
