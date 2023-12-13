package com.devdojo.maratonajava.javacore.ZZClambdas.test;


// Referência ao método de instância de um objeto específico

import com.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import com.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReferenceTest02 {
  public static void main(String[] args) {
    AnimeComparators animeComparators = new AnimeComparators();
    List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Berserk", 43),
            new Anime("One Piece", 900),
            new Anime("Naruto", 500)
    ));

    // Ordenando a lista de animes a partir de um método não estático
    // Lista          Classe            Método não estático
    animeList.sort(animeComparators::compareByEpisodesNonStatic);

    // agora através de um lambda
    animeList.sort((a1,a2) -> animeComparators.compareByEpisodesNonStatic(a1, a2));

    System.out.println(animeList);
  }
}
