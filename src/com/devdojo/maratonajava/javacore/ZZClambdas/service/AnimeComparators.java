package com.devdojo.maratonajava.javacore.ZZClambdas.service;

import com.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;

// agora temos um método estático, dentro da classe abaixo, que iremos passar na Collections.sort do arquivo
// MethodReferenceTest01
public class AnimeComparators {
  public static int compareByTitle(Anime a1, Anime a2){
    return a1.getTitle().compareTo(a2.getTitle());
  }
  public static int compareByEpisodes(Anime a1, Anime a2){
    return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
  }

  public int compareByEpisodesNonStatic(Anime a1, Anime a2){
    return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
  }

}
