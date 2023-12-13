package com.devdojo.maratonajava.javacore.ZZClambdas.test;

// Referência a um método de instância de um objeto arbitrário de um tipo específico

import com.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import com.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
  public static void main(String[] args) {
//    AnimeComparators animeComparators = new AnimeComparators();
    // existe uma interface funcional muito interessante, chamada de Supplier
    // a interface funcional Supplier não recebe nenhum argumento e retorna um tipo T
    // podemos utiliza-lo da seguinte forma, ao invés de instânciar da forma como estamos fazendo acima, poderiamos
    // fazer dessa forma:

    // temos a interface funcional Supplier, onde estamos passando como tipo, a classe que contém os métodos que
    // queremos, e na atribuição, usamos a sintaxe lambda
//    Supplier<AnimeComparators> newAnimeComparators = () -> new AnimeComparators();
    // isso aqui poderia virar uma variavel Method Reference, dessa forma:
    // mas lembrando que não é nessa linha abaixo que o objeto está sendo criado
    Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
    // para criar um objeto, temos que utilizar o método do Supplier "get()"
    AnimeComparators animeComparators = newAnimeComparators.get();

    List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Berserk", 43),
            new Anime("One Piece", 900),
            new Anime("Naruto", 500)
    ));

    animeList.sort(animeComparators::compareByEpisodesNonStatic);

    System.out.println(animeList);


    // como fariamos para criar um objeto do tipo Anime?
    // no nosso anime, temos um construtor que recebe titulo e episodios
    // se tentarmos criar um objeto anime a partir do supplier, não funciona por que não temos um construtor sem
    // parâmetros.
//    Supplier<Anime> anime = Anime::new;
    // o que podemos fazer?
    // primeiro precisamos definir algo que vai receber dois argumentos diferentes e vai retornar um terceiro argumento
    // nós temos o function, que ele recebe e retorna, mas queremos que receba 3 argumentos
    // Temos o BiFunction
    // aqui temos uma sintaxe lambda que contém 2 argumentos de entrada e 1 de retorno
    // lembrando que os objetos não estão sendo criados nessa linha, estamos apenas utilizando interfaces funcionais
    BiFunction<String, Integer, Anime> animeBiFunction1 = (title, episodes) -> new Anime(title, episodes);
    // aqui estamos utilizando o Method Reference
    BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;

    // agora estamos criando um objeto
    Anime anime1 = animeBiFunction2.apply("Super Campeões", 36);

    System.out.println(anime1);
  }
}
