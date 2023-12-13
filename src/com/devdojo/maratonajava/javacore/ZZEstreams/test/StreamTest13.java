package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
    List.of(
      new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
      new LightNovel("Overlord", 3.99, Category.FANTASY),
      new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
      new LightNovel("No Game no life", 2.99, Category.FANTASY),
      new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
      new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
      new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
      new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    )
  );

  public static void main(String[] args) {
    Map<Promotion, List<LightNovel>> collect = lightNovels.stream()
            .collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
            ));

    System.out.println(collect);

    // Map<Category, Map<Promotion, List<LightNovel>>>
    // aqui estamos criando um map onde a chave é a categoria e o valor é outro map de cada categoria onde a chave é
    // a Promotion e o valor a lista de lightNovel
    Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream()
            .collect(Collectors.groupingBy(LightNovel::getCategory,
            Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
            )));

    System.out.println(collect1);
  }
}
