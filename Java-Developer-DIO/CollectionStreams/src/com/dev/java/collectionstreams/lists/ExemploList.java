package com.dev.java.collectionstreams.lists;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Felipe");
        nomes.add("Marcella");
        nomes.add("Yuno");
        nomes.add("Flopp");

        nomes.set(1, "Marcella D. Santos");

        System.out.println("List Names:" + nomes);

        Collections.sort(nomes);

        System.out.println("Order List Names: " + nomes);

        nomes.add("Intrusso");
        System.out.println("Intrusso:" + nomes);
        nomes.remove(4);
        System.out.println("List: " + nomes);

        String pet = nomes.get(1);
        System.out.println("Pet: " + pet);

        int size = nomes.size();
        System.out.println("Size: " + size );

        boolean temYuno = nomes.contains("Yuno");
        System.out.println("Yuno: " + temYuno);

        boolean listaVazia = nomes.isEmpty();
        System.out.println("List Vazia: " + listaVazia);

        //nomes.clear();
        //System.out.println("Lista vazia: " +  nomes.isEmpty());

        int felipe = nomes.indexOf("Felipe");
        System.out.println("Felipe index: " + felipe);

        for (String name : nomes)
        {
            System.out.println("Name: " + name);
        }

        Iterator<String> iterator = nomes.iterator();

        while (iterator.hasNext())
        {
            System.out.println("This element: " + iterator.next());
        }

    }
}
