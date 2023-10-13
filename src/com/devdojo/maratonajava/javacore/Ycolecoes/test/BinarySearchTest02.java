package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
  public static void main(String[] args) {
    MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
    List<Manga> mangas = new ArrayList<>(6);
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9));
    mangas.add(new Manga(1L, "Berserk", 11.20));
    mangas.add(new Manga(4L, "Pokemon", 3.2));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99));

    // precisamos ordenar para usar o binarySearch
    // ordenação padrão usando o compareTo, ordenando por nome
//    Collections.sort(mangas);
    // agora estamos comparando por ID
    // Ordenação Customizada
    mangas.sort(mangaByIdComparator);

    for (Manga manga : mangas) {
      System.out.println(manga);
    }

    // nós estamos ordenando por ID, então ele está falando que o ID 2 está na posição/indice 1, mas se trocarmos
    // digamos q agr está:  Manga mangaToSearch = new Manga(6L, "Dragon Ball Z", 2.99); e executarmos, vai retornar -6
    // pois é a posição do array que precisa ser inserido, (-(tamanho da lista) -1) = -6, onde precisa ser inserido
    Manga mangaToSearch = new Manga(6L, "Dragon Ball Z", 2.99);



    // se estivermos fazendo uma ordenação customizada, precisamos tbm passar o objeto por ordenação no binarySearch
    // usando o mangaByIdComparator
    System.out.println(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator));


    // também funciona com Arrays, mas eles também precisam estar ordenados para usarmos o binarySearch
    int[] numeros = {4,3,5,1,2};
    System.out.println(Arrays.toString(numeros));
    Arrays.sort(numeros);
    System.out.println(Arrays.toString(numeros));
    System.out.println(Arrays.binarySearch(numeros, 6)); // (-5 -1) = -6

  }

}
