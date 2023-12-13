package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// O pacote de frameworks de coleções no java, possuem varias classes que foram criadas especificamente para trabalhar
// com concorrência, e essa BlockingQueue é uma dessas.

// A BlockingQueue é especial por dois motivos:
// 1º Motivo: É uma classe onde você tem um "BlockingQueue"(É uma interface), que nós chamamos de "Bounded", ou seja,
// você tem um limite de valores para você colocar la dentro.
// 2º Motivo: Se você tentar colocar um valor dentro do BlockingQueue abaixo, que esteja com a capacidade de 1, e você
// tentar adicionar um segundo valor nesse BlockingQueue, a thread ficará bloqueada. Enquanto você não tirar aquele
// espaço, você não vai poder colocar um outro valor e ele bloqueia realmente a thread.
// Exemplo:
/*
   O primeiro argumento desse ArrayBlockingQueue é a capacidade que estamos passando, no 2º motivo, vemos que se
   tentarmos adicionar algo além de sua capacidade, a thread que estiver rodando será bloqueada.

   BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
*/


public class BlockingQueueTest01 {
  public static void main(String[] args) throws InterruptedException {
    // BlockingQueue é uma interface.
    BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);

    // Queremos adicionar um nome
    // Temos que adicionar uma exceção na assinatura do método main.

    bq.put("William");
//    bq.peek(); // Retorna o valor sem remover da lista
    System.out.printf("Thread '%s' adicionou o valor '%s' na BlockingQueue 'bq'.%n", Thread.currentThread().getName(),
            bq.peek());
    System.out.println("Tentando adicionar um novo valor...");

    // Pegando e removendo o primeiro valor da queue  com a classe interna "RemoveFromQueue" e criando um novo valor
    // "Suane" abaixo da thread, depois "startando" a thread.
    new Thread(new RemoveFromQueue(bq), "RemoveQueue").start();

    bq.put("Suane");
    System.out.printf("Thread '%s' adicionou o valor '%s' na BlockingQueue 'bq'.%n", Thread.currentThread().getName(),
            bq.peek());
    // Como podemos ver ao executar o código, a thread "main" adicionou o valor "William" e agora está esperando o
    // espaço ser liberado para adicionar o novo valor "Suane".
    // Enquanto ele está esperando o espaço ser liberado para adicionar um novo valor, ele bloqueia a thread enquanto
    // você não liberar o espaço, retirando um valor da lista, então ele não vai deixar o programa continuar.

    // Resultado do código:
    /*
      Thread 'main' adicionou o valor 'William' na BlockingQueue 'bq'.
      Tentando adicionar um novo valor...
      Thread 'RemoveQueue' dormiu por 2 segundos...
      Thread 'RemoveQueue' removeu o valor 'William' da BlockingQueue 'bq'.
      Thread 'main' adicionou o valor 'Suane' na BlockingQueue 'bq'.
    */
  }

  // Essa thread foi feita para dormir por dois segundos e depois para pegar e remover o primeiro elemento da Queue
  static class RemoveFromQueue implements Runnable{
    private final BlockingQueue<String> bq;

    public RemoveFromQueue(BlockingQueue<String> bq) {
      this.bq = bq;
    }

    @Override
    public void run() {
      System.out.printf("Thread '%s' dormiu por 2 segundos...%n", Thread.currentThread().getName());
      // Colocando a thread para dormir por 2 segundos
      try {
        TimeUnit.SECONDS.sleep(2);
        // bq.take() é usado para pegar e remove o primeiro elemento da fila.
        // Ou ele vai esperar até um novo elemento ser adicionado. Então por exemplo, se você tentar executar o take,
        // acima, no método "main", estamos tentando executar o metodo "put", então, se o método "put" estiver cheio,
        // ele irá bloquear, você não vai conseguir colocar dois valores por que não tem capacidade. Mas por exemplo,
        // se estiver 0 valores e você tentar dar um bq.take(), ai ele vai bloquear esperando que alguém adicione outro
        // valor dentro dessa Queue.
        System.out.printf("Thread '%s' removeu o valor '%s' da BlockingQueue 'bq'.%n",
                Thread.currentThread().getName(), bq.take());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}