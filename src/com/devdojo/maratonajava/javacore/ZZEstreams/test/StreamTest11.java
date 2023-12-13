package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest11 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
    List.of(
      new LightNovel("Tensei Shittara", 8.99),
      new LightNovel("Overlord", 3.99),
      new LightNovel("Violet Evergarden", 5.99),
      new LightNovel("No Game no life", 2.99),
      new LightNovel("Fullmetal Alchemist", 5.99),
      new LightNovel("Kumo desuga", 1.99),
      new LightNovel("Kumo desuga", 1.99),
      new LightNovel("Monogatari", 4.00)
    )
  );


  public static void main(String[] args) {
    System.out.println(lightNovels.stream().count()); // como podemos pegar o tamanho trabalhando com streams
    // podemos utilizar o collectors
    System.out.println(lightNovels.stream().collect(Collectors.counting())); // temos o mesmo resultado com o de cima

    // aqui podemos pegar o maximo usando o max que retorna um optional método com max
    lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);

    // aqui estamos pegando o valor maximo, assim como estamos fazendo acima
    // método usando o collect e utilizando o Collectors que retorna um Optional, quando utilizamos o collect, a
    // legibilidade do código é um pouco afetada.
    // assim como temos o maxBy, temos o minBy, para pegarmos o menor numero
    lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
            .ifPresent(System.out::println);


    // também podemos fazer a soma
    // método com mapToDouble
    System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
    // método utilizando o collect
    System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));

    // também temos o average
    // método com mapToDouble
    lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
    // método com collect e collectors
    System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));


    // agora vamos ver o verdadeiro poder dos collectors
    // vamos falar primeiro do summarizing
    // isso trás para gente, tudo que estamos realizando acima, dentro do objeto que criamos
    // agora collect, contém todos os métodos que estavamos pegando acima, como sum, count, average
    // DoubleSummaryStatistics{count=8, sum=35,930000, min=1,990000, average=4,491250, max=8,990000}
    // estamos resumindo tudo que fizemos acima em uma unica linha abaixo, onde o objeto já nos trás a soma, o tamanho
    // a média, o numero min e maximo
    DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
    System.out.println(collect);

    // também existe para String, que é o join
    // digamos que queremos pegar todos os nomes dos light novels e separa-los por virgulas
    // primeiro precisamos fazer um map e pegar os nomes
    // depois chamamos o Collectors dentro do collect e chamamos o método joining, se não passarmos argumentos
    // ele irá apenas retornar todos em uma única string, agora se passarmos um argumento tipo "," ele irá delimitar
    // por virgulas, e ele leva em consideração o último elemento, ou seja, ele não inclui uma virgula no último
    // elemento
    String titles = lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));
    System.out.println(titles);
  }
}
