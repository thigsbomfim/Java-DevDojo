package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;
import java.util.Optional;

public class StreamTest07 {
  public static void main(String[] args) {
    List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
    // o reduce retorna um optional, por que pode ser que essa lista esteja vazia
    // aqui ele irá imprimir a soma
    integers.stream().reduce((x, y) -> x + y)
            .ifPresent(System.out::println);
    // existe outra forma, colocamos o valor inicial
    // colocando um valor inicial, ele não irá mais retornar um optional mas sim um retornar um valor final inteiro
    // o 0 significa o valor inicial, exemplo, estamos calculando todos os numeros da lista, o valor inicial é zero
    // ficaria assim: 0+1=1 -> 1+2=3 -> 3+3=6 -> 6+4=10 -> 10+5=15 -> 15+6=21
    // existe uma forma melhor de usarmos isso, que é utilizando o method reference
    Integer reduce = integers.stream().reduce(0, (x, y) -> x + y);
    System.out.println(reduce);

    // dessa forma ele retorna um optional
    Optional<Integer> reduce1 = integers.stream().reduce(Integer::sum);
    System.out.println(reduce1);

    // desta forma ele retorna um inteiro
    Integer reduce2 = integers.stream().reduce(0, Integer::sum);
    System.out.println(reduce2);

    // podemos fazer com multiplicação também, mas no integer não contém um método específico para isso
    integers.stream().reduce((x, y) -> x * y)
            .ifPresent(System.out::println);
    // se utilizarmos com valor inicial sendo o zero, o valor inicial sempre será 0, pois tudo que é multiplicado por
    // zero é zero
    Integer reduce3 = integers.stream().reduce(1, (x, y) -> x * y);
    System.out.println(reduce3);

    // e se quisermos trazer o máximo, trazer o maior numero de uma lista de inteiros
    // a forma feia de fazer é usando operador ternario
    integers.stream().reduce((x, y) -> x > y ? x : y)
            .ifPresent(System.out::println);
    // e a forma mais bonita de fazer isso é utilizando o método max do Wrapper Integer
    integers.stream().reduce(Integer::max).ifPresent(System.out::println);
    // utilizando o method reference e um valor inicial para achar o valor maximo
    // para não precisarmos pegar um optional
    Integer reduce4 = integers.stream().reduce(0, Integer::max);
    System.out.println(reduce4);
  }
}
