package olw.factorymethods;

import java.util.*;

public class StaticFactoryMethods {

    public static void main(String[] args) {
        // Nomes com siguinificado
        Optional<Integer> empty = Optional.empty();
        Optional<Integer> cemOpt = Optional.of(100);
        Optional<Integer> vazio = Optional.ofNullable(null);

        // Flexibilidade no retorno
        ArrayList<Object> list = new ArrayList<>();
        List<Object> newList = Collections.unmodifiableList(list);
        // newList.add(1) <-- Lança uma execption

        //Controle das Instâncias
        Integer cem = Integer.valueOf(100);
        Integer duz = Integer.valueOf(200);
        Integer tre = Integer.valueOf(300);

        //Construindo uma lista com valores antes do java 9
        List<Integer> list2 = Arrays.asList(cem, duz, tre);

        //Construindo uma lista com valores no java 9
        List<Integer> of1 = List.of();
        List<Integer> of2 = List.of(cem);
        List<Integer> of3 = List.of(cem, duz);
        List<Integer> of4 = List.of(cem, duz, tre);

        

    }

}
