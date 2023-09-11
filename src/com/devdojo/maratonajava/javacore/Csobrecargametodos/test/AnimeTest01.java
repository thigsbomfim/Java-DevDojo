package com.devdojo.maratonajava.javacore.Csobrecargametodos.test;

import com.devdojo.maratonajava.javacore.Csobrecargametodos.dominio.Anime;

public class AnimeTest01 {
  public static void main(String[] args) {
    Anime anime = new Anime();
    anime.init("Akudama Drive", "TV", 12, "Ação");
    anime.init("Akudama Drive", "TV", 12, "Ação");
    anime.imprime();
  }
}
