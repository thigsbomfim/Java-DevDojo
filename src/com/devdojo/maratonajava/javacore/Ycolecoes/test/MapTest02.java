package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.*;

public class MapTest02 {
  public static void main(String[] args) {
    Consumidor consumidor1 = new Consumidor("William Suane");
    Consumidor consumidor2 = new Consumidor("DevDojo Academy");

    Manga manga1 = new Manga(5L, "Hellsing Ultimate", 19.9, 0);
    Manga manga2 = new Manga(1L, "Berserk", 11.20, 5);
    Manga manga3 = new Manga(4L, "Pokemon", 3.2, 0);
    Manga manga4 = new Manga(3L, "Attack on Titan", 9.5, 2);
    Manga manga5 = new Manga(2L, "Dragon Ball Z", 2.99, 0);

    // agora eu quero criar o seguinte map, o map que vai guardar o consumidor e o manga que aquele consumidor comprou
    // um map que associe um consumidor como chave e um manga como valor
    Map<Consumidor, Manga> consumidorManga = new HashMap<>();
    consumidorManga.put(consumidor1, manga1);
    consumidorManga.put(consumidor2, manga4);
    for(Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()){
      System.out.println(entry.getKey().getNome()+" - "+entry.getValue().getNome());
    }
  }
}
