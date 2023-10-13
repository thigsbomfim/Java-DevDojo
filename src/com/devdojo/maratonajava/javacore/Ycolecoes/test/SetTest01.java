package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
  public static void main(String[] args) {
    // Set é uma interface, ela é uma Collection
    // A vantagem do set, é que eles não permitem elementos duplicados dentro da coleção
    // qual objeto que nós podemos criar? temos algumas opções, podemos começar com o HashSet, como ja vimos
    // o HashSet tem hash no nome, então quer dizer que serão organizados através do hash, ou seja, n tem como garantir
    // como esses objetos vão estar dentro da nossa lista, por que ele pode se reajustar baseado no que nós inserirmos
    // o HashSet não mantem a ordem de inserção, se quisermos ainda manter a ordem de inserção, ainda utilizando
    // um hash, podemos utilizar o LinkedHashSet:
    // Set<Manga> mangas = new LinkedHashSet<>();
    Set<Manga> mangas = new HashSet<>();
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
    mangas.add(new Manga(1L, "Berserk", 11.20, 5));
    mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5, 2));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
    // podemos observar que esse objeto abaixo, nunca é adicionado, pois o java vai checar através do método equals
    // por isso é importante ter o método equals sobrescrito na classe por que vai garantir que não adicionamos
    // elementos duplicados, se por exemplo, trouxermos dados do banco de dados sem ter esses dados filtrados por
    // distinção, se jogarmos dentro do set, o set mesmo se encarrega de eliminar os elementos duplicados
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));

    // vemos que não existe indice, um get para inserir o indice, pois o set não é indexado, não podemos pegar o get(1)
    // não existe isso quando estamos trabalhando com o set, você precisa navegar sobre a coleção, podemos utilizar o
    // foreach

    for (Manga manga : mangas) {
      System.out.println(manga);
    }
  }
}
