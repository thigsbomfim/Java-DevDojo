package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
  public static void main(String[] args) {
    // é preciso de um comparable ou comparator
    // existe o priorityQueue pois tem alguns sistemas onde a prioridade é importante, exemplo:
    // digamos que nós tenhamos uma classe Manga, o manga é um Comparable, o comparable está utilizando o nome como
    // ordenação do compareTo, mas imagina que nós tenhamos uma lista de mangá
//    Consumidor consumidor = new Consumidor("William Suane");
//    Queue<Consumidor> consumidorQueue = new PriorityQueue<>();
//    consumidorQueue.add(consumidor);

    // Manga está usando o Comparable e ordenando pelo nome
    // PriorityQueue quer dizer que podemos definir a prioridade, ele sempre remove o primeiro elemento da lista/fila
    // a gente quer definir qual é a prioridade/importancia, por exemplo, no nosso caso do Manga, nós sobrescrevemos
    // o compareTo do Comparable com a ordenação pelo nome, mas digamos que tenhamos outra regra de negócio onde quero
    // dar importancia para o preço, então se fosse um carrinho de compras, poderiamos dar prioridade para os elementos
    // que tenham uma maior quantidade de itens, maior preço, para darmos o checkout primeiro, então por exemplo, nós
    // temos o MangaPrecoComparator, podemos passar aqui. Então vamos ordenar pelo Comparator e não pelo Comparable:
    Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
    mangas.add(new Manga(1L, "Berserk", 11.20, 5));
    mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5, 2));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
    mangas.add(new Manga(10L, "Aragon", 2.99, 0));

    // agora digamos que eu queira remover de acordo com o preço, ou seja, eu quero meio que vender os mais importantes,
    // os mais caros, o que tem prioridade.
    // nosso Comparator está comparando do menor para o maior, em ordem crescente, podemos reverter usando o método
    // reversed na criação do PriorityQueue
    // então, se o manga não for vazio:
    while(!mangas.isEmpty()) {
      // ou seja, se isso aqui fosse um carrinho de compras, e nós tivessemos uns 50 clientes, se tivessemos ordenando
      // pelo valor total daquele carrinho de compras, nós iriamos tirar do carrinho de compras, independente da ordem
      // que os clientes foram adicionados, iriamos dar o checkout nos clientes que tem o maior preço
      System.out.println(mangas.poll());
    }
  }
}
