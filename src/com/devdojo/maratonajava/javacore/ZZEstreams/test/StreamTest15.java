package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest15 {
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
    Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
            .collect(
                    Collectors.groupingBy(
                            LightNovel::getCategory,
                            Collectors.summarizingDouble(LightNovel::getPrice)
                    )
            );

    System.out.println(collect);

    Map<Category, Set<Promotion>> collect1 = lightNovels.stream()
            .collect(
                    Collectors.groupingBy(
                            LightNovel::getCategory,
                            // o collectors.mapping ele meio que faz o map do stream, passamos o que queremos que é
                            // o ln.getPrice que busca o preço menor que 6 é UNDER_PROMOTION e se for maior vai ser
                            // NORMAL_PRICE
                            Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())
                    )
            );
    System.out.println(collect1);

    Map<Category, Set<Promotion>> collect2 = lightNovels.stream()
            .collect(
                    Collectors.groupingBy(
                            LightNovel::getCategory,
                            // toCollection é um fabricador de coleções, e temos que passar a coleção que queremos
                            Collectors.mapping(StreamTest15::getPromotion, Collectors.toCollection(LinkedHashSet::new))
                    )
            );
    System.out.println(collect2);
  }

  private static Promotion getPromotion(LightNovel ln){
    return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
  }
}
