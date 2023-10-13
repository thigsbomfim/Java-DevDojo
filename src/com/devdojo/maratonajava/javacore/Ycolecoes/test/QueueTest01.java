package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
  public static void main(String[] args) {
    // Queue tem por padrão a caracteristica FIFO(First In First Out), ou seja, o primeiro a entrar é o primeiro a sair
    // Queue em portugues é fila, podemos pegar exemplo de uma fila de banco, o primeiro a entrar é o primeiro a ser
    // atendido e a sair
    // No Queue também é necessaria que a classe que estamos passando no generics seja um comparable
    // Estamos usando a classe herdada PriorityQueue, que também podemos passar como argumento um Comparator, caso
    // não tenhamos passado um tipo generics que utiliza o Comparable
    // Essa classe "PriorityQueue" foi criada justamente pra isso, para trabalhar com prioridades customizadas
    // a PriorityQueue vai manter a ordem, mas não necessariamente quando tivermos esse objeto dentro em memoria
    Queue<String> fila = new PriorityQueue<>();
    // nós adicionamos os valores, mas não significam que eles ficaram ordenados dentro da memoria, dentro do heap, mas
    // quando tirarmos os valores, vamos ter de volta a forma ordenada, a forma como definimos no comparable ou
    // comparator
    fila.add("C");
    fila.add("A");
    fila.add("B");

    // podemos iterar sobre esses valores
    for (String s : fila) {
      System.out.println(s);
    }

    System.out.println(fila);

    // o certo mesmo quando estamos trabalhando com PriorityQueue, é utilizarmos um dos métodos disponiveis
    // temos os métodos:
    // peek
    // poll
    // offer
    // remove
    // a diferença entre o peek e o poll é que o peek vai sempre me mostrar o primeiro elemento, se tivermos em um while
    // ele vai mostrar o elemento sem remover da lista. O poll pega o primeiro elemento da fila e vai remover. O offer
    // é parecido com o add, a diferença é que o add retorna uma exceção se tivermos um PriorityQueue com um tamanho
    // definido, o remove também remove o primeiro elemento, e também temos o remove mas passando um objeto como
    // argumento, que ele vai utilizar o equals para achar aquele objeto e remover.
    // o offer retorna um boolean caso não consiga inserir uma queue com a capacidade restrita, e o add vai lançar uma
    // exceção caso não consiga inserir uma queue com a capacidade restrita

    while(!fila.isEmpty()) {
      // se utilizarmos o peek dentro de um laço, podemos ver que ele vai ficar em looping infinito, pois ele vai
      // sempre retornar o primeiro sem remover
//      System.out.println(fila.peek());
      // agora se utilizarmos o poll, ele irá retornar o primeiro e remover ele
      // podemos ver que agora realmente temos ABC, ou seja, quando nós inserimos utilizando o add e tirarmos o poll,
      // ele não estava ordenado, agora que estamos removendo o primeiro elemento utilizando o poll, ele ordena da forma
      // que o Comparable ou comparator está indicando.

      System.out.println(fila.poll());
    }

  }
}
