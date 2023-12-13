package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest04 {
  public static void main(String[] args) {
    // FlatMap vai fazer a mesma coisa que o map faz, mas a diferença é que o flatMap é utilizada quando temos
    // propiedades aninhadas, uma dentro da outra
    List<List<String>> devdojo = new ArrayList<>();
    List<String> graphicDesigners = List.of("William Suane", "Catarina Santos", "Sandy Carolina");
    List<String> developers = List.of("William", "David", "Harisson");
    List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
    devdojo.add(graphicDesigners);
    devdojo.add(developers);
    devdojo.add(students);
    System.out.println(devdojo);

    // legal, temos uma lista de listas
    // como fariamos para imprimir elementos dessa lista utilizando o java sem ser o java 8, sem utilizar streams
    for (List<String> people : devdojo) {
      for (String string : people) {
        System.out.println(string);
      }
    }

    // o flatMap é utilizado nesses caso, onde temos que tirar atributo que está aninhado, como fariamos com flatMap?
    // quando atribuimos devdojo.stream a uma variavel, podemos ver que a variavel retorna uma stream de List<String>
    // Stream<List<String>>
    devdojo.stream()
            // esse stream acima está retornando um stream de lista
            // Se utilizarmos dessa forma abaixo e introduzirmos a uma variavel, podemos ver que será retornado um
            // Stream<Stream<String>>
            // o objetivo final que queremos é um: Stream<String>
            // quando temos um caso desse, onde precisamos retirar um atributo de dentro, um atributo aninhado, é
            // utilizado o flatMap, que irá da forma que estamos procurando: Stream<String>
//            .flatMap(l -> l.stream());
            // podemos utilizar o method Reference
            // flatMap é um método intermediario, flatMap pode ser utilizado quando precisamos retirar uma coleção
            // ou algum atributo de dentro de outro lugar
            .flatMap(Collection::stream).forEach(System.out::println);
  }
}
