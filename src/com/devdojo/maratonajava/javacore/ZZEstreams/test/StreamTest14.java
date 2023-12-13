package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
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
    // para saber a quantidade de lightNovel por categoria
    Map<Category, Long> collect = lightNovels.stream()
            .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));

    System.out.println(collect);

    // aqui estamos pegando cada lightNovel por categoria e por maior preço, mas podemos ver que ele retorna um Optional
    Map<Category, Optional<LightNovel>> collect1 = lightNovels.stream()
            .collect(Collectors.groupingBy(
                    LightNovel::getCategory,
                    Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)
                    )));
    System.out.println(collect1);

    // para não retornar um optional
    // collectingAndThen vai chamar o maxBy
    // aqui estamos usando o Collectors.groupingBy para agrupar, como primeiro argumento, estamos dizendo que queremos
    // primeiramente agrupar por categoria, e no segundo argumento seria a utilização de outro
    // Collectors.collectingAndThen onde passariamos como primeiro argumento o maior lightNovel baseado no preço
    // e como segundo argumento passariamos o Optional::get que queremos e retirando o lightNovel de dentro do Optional
    Map<Category, LightNovel> collect2 = lightNovels.stream().collect(
            Collectors.groupingBy(
                    LightNovel::getCategory,
                    Collectors.collectingAndThen(
                            Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),
                            Optional::get
                    )
            )
    );
    System.out.println(collect2);

    // forma mais simplificada ainda da forma de cima
    Map<Category, LightNovel> collect3 = lightNovels.stream().collect(
            Collectors.toMap(
                    LightNovel::getCategory,
                    Function.identity(),
                    BinaryOperator.maxBy(
                            Comparator.comparing(LightNovel::getPrice)
                    )
            )
    );
    System.out.println(collect3);


  }
}
