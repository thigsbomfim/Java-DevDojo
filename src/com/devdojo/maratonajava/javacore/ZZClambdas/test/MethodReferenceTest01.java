package com.devdojo.maratonajava.javacore.ZZClambdas.test;

import com.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import com.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Method Reference -> a sintaxe do Method Reference é essa: "Classe::MetodoEstatico"
// o método é necessario ser um método estático, se não for estático, a classe precisa ser instânciada
// o Method Reference utiliza a sintaxe lambda

// Referência a um método estático

public class MethodReferenceTest01 {
  public static void main(String[] args) {
    List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Berserk", 43),
            new Anime("One Piece", 900),
            new Anime("Naruto", 500)
    ));

    // aqui estamos criando um comparator com uma classe anonima usando a sintaxe lambda, onde estamos passando 2
    // parametros e comparando esses dois parametros de animeList
    // seria a mesma coisa se estivessemos criando um comparator em outra classe
    // agora temos os animes da lista ordenados pelo titulo
//    Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));

    // estamos passando apenas um método para comparar valores e ordena-los
    Collections.sort(animeList, (a1, a2) -> AnimeComparators.compareByTitle(a1, a2)); // utilizando a sintaxe lambda

    // podemos observar, que ao usar o method reference, não estamos instanciando uma classe usando new e sim passando
    // ela e buscando um método estático dela
    Collections.sort(animeList, AnimeComparators::compareByTitle); // usando o Method Reference, ordenando pelo titulo
    // poderiamos utilizar outro método estático da propria classe se necessário
    // agora temos dois métodos estáticos na classe AnimeComparators que poderemos usar na ordenação
    Collections.sort(animeList, AnimeComparators::compareByEpisodes); // usando o Method Reference, ordenando pelo epis

    System.out.println(animeList);
  }
}
