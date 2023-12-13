package com.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

// Interface Consumer é uma interface funcional, parecida com Predicate, a diferença é que ele executa uma operação
// e não retorna nada, o tipo que retorna é void
public class LambdasTest02 {
  public static void main(String[] args) {

    List<String> strings = List.of("Thiago", "William", "Luffy", "Zoro");
    List<Integer> integers = List.of(1, 2, 3, 4, 5);
    // dessa forma, podemos trabalhar com o consumer, onde ele irá usar o lambda e não espera retornar nada
    forEach(strings, str -> System.out.println(str));
    forEach(integers, integer -> System.out.print(integer + " "));
  }

  // método que imprime qualquer tipo de lista no console
  private static <T> void forEach(List<T> list, Consumer<T> consumer){
    for (T element : list) {
      consumer.accept(element);
    }
  }
}
