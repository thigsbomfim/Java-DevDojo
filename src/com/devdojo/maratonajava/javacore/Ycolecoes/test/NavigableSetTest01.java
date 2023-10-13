package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

// A classe SmartphoneMarcaComparator permite criar um comparador personalizado para ordenar smartphones por marca.

class SmartphoneMarcaComparator implements Comparator<Smartphone> {

  @Override
  public int compare(Smartphone marca1, Smartphone marca2) {
    return marca1.getMarca().compareTo(marca2.getMarca());
  }
}

class MangaPrecoComparator implements Comparator<Manga> {
  @Override
  public int compare(Manga manga1, Manga manga2) {
    return Double.compare(manga1.getPreco(), manga2.getPreco());
  }
}


public class NavigableSetTest01 {
  public static void main(String[] args) {
    // O TreeSet é uma coleção que organiza objetos em ordem crescente. Para fazer isso, os objetos precisam ser comparáveis
    // (ou seja, implementar a interface Comparable) ou você pode fornecer um comparador personalizado (ou seja, um
    // Comparator) como argumento.
    // Temos duas opções ao usar o TreeSet:
    // 1. Implementar a interface Comparable na classe que estamos armazenando, como no caso da classe Smartphone.
    // 2. Fornecer um comparador personalizado, como o SmartphoneMarcaComparator, quando não temos controle sobre a classe.
    // O TreeSet se baseia no método compareTo do Comparable se estiver implementado na classe SmartPhone ou no método compare
    // do Comparator que passamos como argumento.
    // Use o TreeSet quando a classe que está sendo armazenada é um Comparable ou quando você fornece um Comparator personalizado.
    // Lembre-se de que o TreeSet não aceita valores duplicados.

    NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
    Smartphone smartphone = new Smartphone("123", "Nokia");
    // Tentar adicionar um objeto não comparável resulta em um ClassCastException, mas podemos criar um comparador
    // personalizado quando não controlamos a classe Smartphone.
    set.add(smartphone);

    // O TreeSet não segue o contrato do Set e não utiliza o método equals para verificar se dois elementos são iguais.
    // Ele se baseia no método compare do Comparator ou compareTo do Comparable, portanto, segue as regras de negócios
    // definidas nesses métodos.
    System.out.println("Ordem crescente");
    NavigableSet<Manga> mangas1 = new TreeSet<>(); // ordenando pelo nome
    // Neste exemplo, criamos um comparador e o passamos como argumento para ser usado no lugar do Comparable
    // do Manga, então estamos usando o método "compare" para comparar os valores.
    NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator()); // ordenando pelo preço

    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
    mangas.add(new Manga(1L, "Berserk", 11.20, 5));
    mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5, 2));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
    mangas.add(new Manga(10L, "Aragon", 2.99, 0));
    // No exemplo abaixo, podemos ver que ele se baseia no nome do manga porque foi sobrescrito no método "compareTo" na
    // classe Manga, então se tentarmos adicionar um nome igual, ele não será adicionado. Se tentarmos adicionar um
    // ID igual, ele será adicionado.
    // Não será adicionado, pois já existe um manga com este nome, mesmo que o ID seja diferente.
    mangas.add(new Manga(12L, "Aragon", 2.99, 0));
    // Será adicionado, pois o nome do manga é diferente.
    mangas.add(new Manga(10L, "Aragon 2", 2.99, 0));

    // Podemos ver que eles estão sendo impressos em ordem alfabética com base no atributo "nome", pois o TreeSet
    // organiza os dados usando o método "compareTo" do Comparable.
    for (Manga manga : mangas) {
      System.out.println(manga);
    }

    System.out.println("-----------------");
    System.out.println("Ordem decrescente");
    // Suponhamos que desejamos organizar os mangas pelo nome em ordem decrescente.
    for (Manga manga : mangas.descendingSet()) {
      System.out.println(manga);
    }

    // Agora que estamos organizando pelos preços (double/long), podemos usar outros métodos:
    // Métodos:
    // lower < (menor)
    // floor <= (menor ou igual)
    // higher > (maior)
    // ceiling >= (maior ou igual)
    // Esses métodos são para comparação com base no objeto que passamos. Se chamarmos "lower", ele trará o primeiro elemento menor.
    // Se chamarmos "floor", ele trará provavelmente o mesmo valor que estamos comparando ou, caso não exista, trará o imediatamente anterior a ele.
    // "higher" trará o primeiro elemento maior, e "ceiling" levará em consideração o valor que você está passando.

    System.out.println("-------------------");
    // Vamos criar outro mangá.
    Manga yuyu = new Manga(21L, "Yu Yu Hakusho", 3.2, 5);
    // Com base neste mangá, se fizermos isso, ele trará o primeiro preço menor que está abaixo de 3.2.
    // Nesse caso, retornará o preço 2.99, pois foi o primeiro preço menor encontrado.
    System.out.println("lower: " + mangas.lower(yuyu)); // 2.99 -> não considera preços iguais
    // Agora, se usarmos "floor", ele trará o próprio valor, pois existe um valor igual ao valor que estamos comparando, que é 3.2.
    System.out.println("floor preço: " + mangas.floor(yuyu)); // 3.2 -> considera preços iguais e os menores
    System.out.println("higher preço: " + mangas.higher(yuyu)); // 9.5 -> não considera preços iguais
    System.out.println("ceiling preço: " + mangas.ceiling(yuyu)); // 3.2 -> considera preços iguais e os maiores
    System.out.println("-----------------");

    // Se desejarmos remover elementos da lista, começando pelo primeiro ou pelo último.
    System.out.println(mangas.size()+" itens na lista"); // 5 itens
    System.out.println(mangas.pollFirst()); // Retorna e remove o primeiro elemento da lista
    System.out.println(mangas.size()+" itens na lista"); // 4 itens
    System.out.println(mangas.pollLast()); // Retorna e remove o último elemento da lista
    System.out.println(mangas.size()+" itens na lista"); // 3 itens
  }
}
