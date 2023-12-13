package com.devdojo.maratonajava.javacore.ZZEstreams.test;


import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Streams é uma sequência de elementos.
 * Quando falamos de coleções, estamos falando de elementos em um espaço, onde estamos guardando os dados, as coleções,
 * estamos falando de memória.
 * Quando a gente trabalha com Streams, que é uma sequência de elementos, esses elementos estão digamos que no tempo.
 * Coleções trabalha com dados em espaço e Streams trabalha com dados no tempo.
 * Streams trabalha com a sequencia e não estão guardando absolutamente nada.
 * */

// 1. Ordene todos os LightNovel por titulo
// 2. Traga os 3 primeiros LightNovel que tenham o valor menor que 4
public class StreamTest01 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
          List.of(
          new LightNovel("Tensei Shittara", 8.99),
          new LightNovel("Overlord", 3.99),
          new LightNovel("Violet Evergarden", 5.99),
          new LightNovel("No Game no life", 2.99),
          new LightNovel("Fullmetal Alchemist", 5.99),
          new LightNovel("Kumo desuga", 1.99),
          new LightNovel("Monogatari", 4.00)
          )
  );

  public static void main(String[] args) {
//    lightNovels.sort((l1, l2) -> l1.getTitle().compareTo(l2.getTitle()));
    // esse Comparator.comparing, passamos um Method Reference e ele se encarrega de quais titulos ele deve comparar
    // como estamos fazendo em cima
    lightNovels.sort(Comparator.comparing(LightNovel::getTitle));

    // aqui estamos criando uma lista de titulos
    List<String> titles = new ArrayList<>();
    // aqui estamos iniciando um for no lightNovels e criando condições, se o preço for menor que 4, adicione o
    // titulo na lista titles. Se o tamanho do titles for maior ou igual a 3, encerra o laço
    for (LightNovel lightNovel : lightNovels) {
      if(lightNovel.getPrice() <= 4) titles.add(lightNovel.getTitle());
      if(titles.size() >= 3) break;
    }


    System.out.println(lightNovels);
    System.out.println(titles);
  }
}
