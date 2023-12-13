package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
  public static void main(String[] args) {
    // como podemos criar streams diretamente sem usar listas.
    // podemos utilizar o intStream que irá manter os valores primitivos, se estivermos trabalhando com alta performance
    // temos o IntStream.range() e InStream.rangeClosed(), onde todos tem o startInclusive, se colocarmos o valor
    // de zero, irá ser considerado o valor de 0
    // a diferença entre os dois é:
    // rangeClosed tem o int endInclusive, quando colocamos um segundo nesse método
    // no range o segundo argumento do método é um int endExclusive, quando utilizamos o range, e passamos um segundo
    // argumento, estamos dizendo que o valor é exclusivo, se contarmos de 1 a 50, ele irá contar até 49
    // ja se utilizarmos o rangeClosed, irá contar até de 1 a 50.
    // então digamos que queremos contar de 1 até 50 e queremos apenas os numeros pares e imprimir no console
    IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
    System.out.println();
    IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
    System.out.println();

    // assim utilizariamos para criar via IntStream
    // também temos a possibilidade de criar de outra forma
    // temos o Stream.of, onde ele aceita qualquer coisa, um objeto, uma stream, um valor numérico
    // esse código abaixo irá gerar um stream de string (Stream<String>)
    Stream.of("Eleve", "o", "cosmo", "no seu coração")
            .map(String::toUpperCase)
            .forEach(s -> System.out.print(s + " "));

    System.out.println();

    int[] nums = {1,2,3,4,5};
    // esse método do Arrays, retorna um IntStream
    // e ele ja tem um métodos úteis para gente
    // temos o min, max, sum, average
    // onde esses métodos retornam um Optional
    Arrays.stream(nums).average().ifPresent(System.out::println);


    // podemos também trabalhar com streams em arquivos
    // Files.lines retorna uma stream de strings Stream<String>
    try(Stream<String> lines = Files.lines(Paths.get("file.txt"))){
      // aqui estamos observando se contém a palavra java no arquivo txt
      lines.filter(s -> s.contains("Java")).forEach(System.out::println);
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}
