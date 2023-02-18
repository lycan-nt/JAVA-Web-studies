package com.dev.java.collectionstreams.comparators;

import java.util.ArrayList;
import java.util.List;

public class MainBanc {

    public static void main(String[] args) {
        List<Banc> listBanc = new ArrayList<>();
        Banc conta1 = new Banc();
        Banc conta2 = new Banc();
        Banc conta3 = new Banc();
        Banc conta4 = new Banc();

        conta1.setTitular("Felipe D. Santos");
        conta1.setCpf("123456");
        conta1.setAgencia("321");
        conta1.setNumeroConta("01");
        listBanc.add(conta1);

        conta2.setTitular("Marcella D. Santos");
        conta2.setCpf("123456");
        conta2.setAgencia("321");
        conta2.setNumeroConta("01");
        listBanc.add(conta2);

        conta3.setTitular("Yuno D. Santos");
        conta3.setCpf("123456");
        conta3.setAgencia("321");
        conta3.setNumeroConta("01");
        listBanc.add(conta3);

        conta4.setTitular("Floop D. Santos");
        conta4.setCpf("123456");
        conta4.setAgencia("321");
        conta4.setNumeroConta("01");
        listBanc.add(conta4);

        System.out.println("List not ordened: " + listBanc);

        List<Banc> listT = new ArrayList<>();
        listT.add(new Banc("Felipe", "78945612"));
        System.out.println("List: " + listT);

        for (Banc conta : listBanc)
        {
            System.out.println("Contas");
            System.out.println(" - " + conta.getTitular());
        }

        for (Banc conta : listT)
        {
            System.out.println("Contas 2");
            System.out.println(" -- " + conta.getTitular());
        }

    }

}
