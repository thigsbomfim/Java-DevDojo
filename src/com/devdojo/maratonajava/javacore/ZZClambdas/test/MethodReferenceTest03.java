package com.devdojo.maratonajava.javacore.ZZClambdas.test;

// Referência a um método de instância de um objeto arbitrário de um tipo específico

import com.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import com.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceTest03 {
  public static void main(String[] args) {
    AnimeComparators animeComparators = new AnimeComparators();
    List<String> list = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimaru"));


    // aqui estamos utilizando um método da classe String que é o compareTo
    // irá imprimir em ordem alfabética
    // como podemos ver, o compareTo não é estático e estamos chamando através do nome da classe String
    list.sort(String::compareTo);

    // vamos imaginar que queremos criar uma função que transforme uma string em um inteiro
    // aqui estamos criando essa função que é uma lambda
    Function<String, Integer> numberStringToInteger1 = s -> Integer.parseInt(s);
    // aqui estamos criando essa função que é um Method Reference
    Function<String, Integer> numberStringToInteger2 = Integer::parseInt;

    // utilizando uma interface funcional que é a Function para criar funções
    Integer num = numberStringToInteger2.apply("123456");
    System.out.println(num);


    // utilizando uma interface funcional que é a BiPredicate, que podemos passar dois argumentos
    // passando uma lista de string para saber se meu nome está la
    BiPredicate<List<String>, String> checkeName = List::contains;

    // aqui estamos perguntando se dentro da lista list contem um nome "Rimuru"
    System.out.println(checkeName.test(list, "Rimuru"));

  }
}
