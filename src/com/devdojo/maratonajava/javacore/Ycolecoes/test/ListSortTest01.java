package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
  public static void main(String[] args) {
    List<String> mangas = new ArrayList<>(6);
    mangas.add("Hellsing Ultimate");
    mangas.add("Attack on titan");
    mangas.add("Pokemon");
    mangas.add("Bersek");
    mangas.add("Dragon Ball Z");
    // collections é como se fosse uma classe utilitaria, onde os métodos são todos praticamente estáticos
    // vai reogarnizar a lista na ordem, do menor para o maior, em ordem alfabética
    Collections.sort(mangas);

    for (String manga : mangas) {
      System.out.println(manga);
    }

    List<Double> dinheiros = new ArrayList<>();

    dinheiros.add(100.21);
    dinheiros.add(23.98);
    dinheiros.add(21.21);
    dinheiros.add(98.10);

    System.out.println(dinheiros);
    Collections.sort(dinheiros);
    System.out.println(dinheiros);

  }
}
