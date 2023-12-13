package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamTest08 {
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
    lightNovels.stream()
            // aqui estamos pegando os preços
            .map(LightNovel::getPrice)
            // aqui estamos filtrando os preços maiores que 3
            .filter(price -> price > 3)
            // aqui estamos somando os preços maiores que 3 e imprimindo, pois é retornado um Double
            .reduce(Double::sum).ifPresent(System.out::println);

    lightNovels.stream()
            // aqui estamos pegando os preços
            .map(LightNovel::getPrice)
            // aqui estamos filtrando os preços maiores que 3
            .filter(price -> price > 3)
            // aqui estamos somando os preços maiores que 3 e imprimindo, pois é retornado um Double
            .reduce(Double::sum).ifPresent(System.out::println);

    // quando estamos trabalhando com streams, podemos usar os Wrappers que são especialmente feitos para Stream
    // como o Wrapper DoubleStream.
    // abaixo estamos utilizando o mapToDouble, que retorna um
    double sum = lightNovels.stream()
            // aqui estamos pegando os preços, mas aqui que vai a diferença do codigo acima, ao invés de nós fazermos
            // o map utilizando o getPrice, eu quero fazer o map para Double, que é o mapToDouble, onde temos:
            // mapToDouble, mapToInt, mapToLong
            // podemos reparar que o retorno agora não é um stream de Double e sim um DoubleStream
            .mapToDouble(LightNovel::getPrice)
            // e aqui, como ja estamos trabalhando com valores numéricos, temos algumas funcionalidades que diretamente
            // que podem ser utilizadas, mas teremos que usar o filter também nesse caso
            .filter(price -> price > 3)
            // adicionando o método sum dessa forma, ja que estamos trabalhando com tipos primitivos, ele irá
            // retornar um tipo primitivo
            .sum();
  }
}
