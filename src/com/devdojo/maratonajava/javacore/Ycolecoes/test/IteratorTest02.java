package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
// para saber mais sobre performance das interfaces e classes utilitarias, basta pesquisar a notação Big O
// https://www.bigocheatsheet.com/
public class IteratorTest02 {
  public static void main(String[] args) {
    // linkedList não aceita um tamanho igual ao ArrayList passado como argumento, mas ambos funcionam da mesma forma
    // um LinkedList ele é um array onde cada uma das posições do array sabe sobre a posição anterior e a proxima,
    // exemplo:
    // INDICES:        0   ->   1   ->   2   ->   3   ->   4
    // INDICES:        0   <-   1   <-   2   <-   3   <-   4
    // um sabe sobre o que tem no outro
    // a vantagem de usar um LinkedList, é melhor para remover, se fizermos bastante remoção em uma lista, seria mais
    // vantagem utilizar o LinkedList, e ja que estamos trabalhando orientado a interface, basta nós trocarmos apenas
    // o nome do objeto abaixo, de ArrayList para LinkedList
//    List<Manga> mangas = new ArrayList<>(6);
    List<Manga> mangas = new LinkedList<>();
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
    mangas.add(new Manga(1L, "Berserk", 11.20, 5));
    mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5, 2));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));

    Iterator<Manga> mangaIterator = mangas.iterator();

    while(mangaIterator.hasNext()) {
      if(mangaIterator.next().getQuantidade() == 0) mangaIterator.remove();
    }

    System.out.println(mangas);

    mangas.removeIf(manga -> manga.getQuantidade() == 0);
  }
}
