package study.stream;

import study.stream.Pessoa;


import java.util.ArrayList;
import java.util.List;

public class Study {

    List<Pessoa> pessoas = new ArrayList<Pessoa>();
    Pessoa pessoa1 = new Pessoa();
    pessoas.add(pessoa1);

    //Retorna a quandidade
    pessoas.size();
    pessoas.stream().count();

    //Retorna um limite expecificado
    pessoas.stream().limit(10);

    //Ordena em ordem crecente
    pessoas.stream().sorted();

    //Ordena em ordem decrecente
    pessoas.stream().sorted(comparing(pessoa::getNome).reversed());

    //Filtra os elementos
    pessoas.stream().filter( p -> p.getIdade > 18 );

    //Faz um mapeamento
    pessoas.stream().map(Pessoa::getNome);

    //Realiza uma iteração sobre todos os elementos de uma stream e executa algum tipo de processamento. É equivalente ao loop for
    pessoas.stream().forEach(pessoa -> {
        pessoa.setIdade(18);
    });

    //Retorna true se todos os elementos da stream correspondem ao predicado fornecido.
    pessoas.stream.allMatch(p -> p.getIdade == 18);

    //Retorna true se qualquer um dos elementos da stream corresponde ao predicado fornecido.
    pessoas.stream().anyMatch(p -> p.getIdade == 18);

    //Retorna true se nenhum dos elementos da stream corresponde ao predicado fornecido.
    pessoas.stream().noneMatch(p -> p.getNome == "Ana");

    //Permite coletar o conteúdo da stream, por exemplo como uma lista.
    List<Pessoa> resultado = pessoas.stream().filter(p -> p.getIdade() == 18 ).collect(toList());


}
