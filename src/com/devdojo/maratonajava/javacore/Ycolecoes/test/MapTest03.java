package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
  public static void main(String[] args) {
    Consumidor consumidor1 = new Consumidor("William Suane");
    Consumidor consumidor2 = new Consumidor("DevDojo Academy");

    Manga manga1 = new Manga(5L, "Hellsing Ultimate", 19.9, 0);
    Manga manga2 = new Manga(1L, "Berserk", 11.20, 5);
    Manga manga3 = new Manga(4L, "Pokemon", 3.2, 0);
    Manga manga4 = new Manga(3L, "Attack on Titan", 9.5, 2);
    Manga manga5 = new Manga(2L, "Dragon Ball Z", 2.99, 0);

    // aqui estamos criando uma lista com os mangas que o consumidor comprou
    List<Manga> mangaConsumidor1List = List.of(manga1,manga2,manga3);
    List<Manga> mangaConsumidor2List = List.of(manga3,manga4);
    // agora eu quero criar o seguinte map, o map que vai guardar o consumidor e o manga que aquele consumidor comprou
    // um map que associe um consumidor como chave e um manga como valor
    // aqui estamos adicionando o valor do map como uma Lista
    Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();
    // aqui estamos falando, que a chave vai ser o consumidor1, e o valor será a lista mangaConsumidor1List, que contém
    // todos os mangás que o consumidor1 comprou
    consumidorMangaMap.put(consumidor1, mangaConsumidor1List);
    consumidorMangaMap.put(consumidor2, mangaConsumidor2List);

    for(Map.Entry<Consumidor, List<Manga>> consumidor : consumidorMangaMap.entrySet()){
      // aqui estamos pegando a chave e imprimindo
      System.out.println("--"+consumidor.getKey().getNome());

      // aqui estamos percorrendo sobre o valor e imprimindo
      for(Manga list : consumidor.getValue()){
        System.out.println("----"+list.getNome());
      }
    }
  }
}
