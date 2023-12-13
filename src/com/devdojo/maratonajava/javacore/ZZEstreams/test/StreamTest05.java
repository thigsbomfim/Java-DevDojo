package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest05 {
  public static void main(String[] args) {
    List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
    String[] letters = words.get(0).split("");
    System.out.println(Arrays.toString(letters)); // indice 0 -> [G, o, m, u]

    // aqui estamos coletando uma lista de array de string, mas queremos pegar apenas os valores
    List<String[]> collect = words.stream().map(w -> w.split("")).toList();
    // para pegar os valores, podemos usar o Arrays.stream() e passar letters como argumento
    Stream<String> stream = Arrays.stream(letters);
    // ou também podemos também utilizar o flatMap
    // agora esse código abaixo está retornando um stream de String e não um stream de um array de string
    // antes: Stream<String[]>
    // depois: Stream<String>
    List<String> letters2 = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).toList();
    System.out.println(letters2); // [G, o, m, u, G, o, m, u, N, o, M, i]

  }
}
