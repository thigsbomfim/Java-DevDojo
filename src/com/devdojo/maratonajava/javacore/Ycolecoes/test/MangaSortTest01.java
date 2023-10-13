package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
   Para usar o Comparator, precisamos que a classe passada no generics seja implementada com Comparable.
   A classe Manga deve ser implementada da seguinte forma:
   public class Manga implements Comparable<Manga>
 */

class MangaByIdComparator implements Comparator<Manga> {

  @Override
  public int compare(Manga manga1, Manga manga2) {
    /*
       Aqui temos dois objetos, onde "manga1" faz referência ao primeiro argumento passado no método,
       e "manga2" faz referência ao segundo argumento passado no método.
       As regras para sobrescrever são as seguintes, no caso de valores numéricos:
       1° -> Deve retornar um número negativo se "manga1" for menor que "manga2";
       2º -> Deve retornar 0 se "manga1" for igual a "manga2";
       3° -> Deve retornar um número positivo se "manga1" for maior que "manga2".
     */
    return manga1.getId().compareTo(manga2.getId());
  }
}

public class MangaSortTest01 {

  public static void main(String[] args) {
    List<Manga> mangas = new ArrayList<>(6);
    // Estamos criando os objetos conforme os adicionamos à lista.
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9));
    mangas.add(new Manga(1L, "Berserk", 11.20));
    mangas.add(new Manga(4L, "Pokemon", 3.2));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99));

    // Vamos exibir os mangás na lista.
    for (Manga manga : mangas) {
      System.out.println(manga);
    }

    /*
       Para usar o método Collections.sort em uma lista de objetos, é necessário q a classe implemente a interface
       Comparable.
       Nessa interface, você deve sobrescrever o método "compareTo" da maneira desejada.
       O Java chamará automaticamente esse método quando for necessário.
       Neste caso, estamos organizando os mangás por ordem alfabética de nome.
    */
    Collections.sort(mangas);

    // Exibindo a lista ordenada por nome.
    System.out.println("-----------------");
    System.out.println("Ordenado pelo Nome");
    for (Manga manga : mangas) {
      System.out.println(manga);
    }

    /*
       Agora, queremos ordenar a lista por ID, em vez de usar o comportamento padrão definido na classe Manga,
       que organiza por nome. O método sort aceita um objeto que atende ao requisito de ser um "Comparator".
       Nesse caso, estamos usando a classe MangaByIdComparator, que implementa o Comparator e usa o tipo Manga como
       genérico.
       Isso é tudo o que precisamos, pois o Java cuidará de chamar o método "compare" da classe MangaByIdComparator.
     */
    mangas.sort(new MangaByIdComparator());

    // Exibindo a lista ordenada por ID.
    System.out.println("-----------------");
    System.out.println("Ordenado pelo ID");
    for (Manga manga : mangas) {
      System.out.println(manga);
    }
  }
}
