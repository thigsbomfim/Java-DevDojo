package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
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

    // anyMatch retorna um boolean, aqui estamos perguntando se existe um lightNovel que o preço seja maior que 8
    System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
    // outro método interessante é o allMatch, ele percorre por cada valor comparando se tem valores maiores que 0
    System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
    // também temos o noneMatch, que vai retornar true se nenhum dos preços forem maiores que zero
    // nenhum preço é maior que 0? false, pois todos são maiores que 0
    System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() > 0));
    // nenhum preço dessa lista é menor que 0? true
    System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));

    lightNovels.stream()
            .filter(ln -> ln.getPrice() > 3)
            // quero que retorne qualquer um, não me importo com a ordem, quero que retorne um lightnovel que tenha um
            // preço maior do que 3, esse findAny, seleciona qualquer elemento dessa lista, só utilizamos ele quando
            // não nos importamos com resultado
            // ele retorna um optional
            .findAny()
            .ifPresent(System.out::println);

    // também podemos utilizar o findFirst
    lightNovels.stream()
//            .filter(ln -> ln.getPrice() > 3)
//            // aqui estamos ordenando pelo preço e revertendo a ordem colocando decrescente
//            .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
//            // ele encontra o primeiro elemento dessa lista, onde o preço é maior do que 3, e retorna um Optional
//            .findFirst()
//            .ifPresent(System.out::println);
            // método mais legivel
            .filter(ln -> ln.getPrice() > 3).max(Comparator.comparing(LightNovel::getPrice))
            .ifPresent(System.out::println);
  }
}
