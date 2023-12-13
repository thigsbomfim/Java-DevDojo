package com.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExampleRunnable3 implements Runnable {
  private final String c;

  public ThreadExampleRunnable3(String c) {
    this.c = c;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
    for (int i = 0; i < 500; i++) {
      System.out.print(c);
      if(i % 100 == 0){
        System.out.println();
      }

      // o yield foi criado para dizer para a thread que está em execução para dar uma pausa
      // ele basicamente está dizendo, meio que dando uma indicação, que queremos que o agendador "a JVM",
      // o "Scheduler", queremos que ele faça a thread voltar para "Runnable".
      // Imagina que temos uma thread que está rodando sem parar, o yield é uma indicação que fala, "ei, agora você
      // pode dar a vez para as outras pessoas".
      // o yield também é um método estático, ou seja, a propria thread decide e é apenas uma dica para "Scheduler" que
      // essa thread que está em execução, agora está querendo disponibilizar o processador, mas não é garantia por que
      // o "Scheduler" liga para ignorar essa dica.
//      Thread.yield();

      // usando o sleep para conseguirmos observar que a thread t2 fica bloqueada assim até a thread t1 terminar
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * EXPLICAÇÃO DOS ESTADOS DA THREAD NO ARQUIVO ThreadTest02;
 * EXPLICAÇÃO DE PRIORIDADES E COMO COLOCAR UMA THREAD PARA DORMIR NO ARQUIVO ThreadTest03;
 * EXPLICAÇÃO SOBRE THREAD SAFE ESTÁ NO ARQUIVO ThreadSafeTest01.
 * EXPLICAÇÃO SOBRE DEADLOCK ESTÁ NO ARQUIVO DeadlockTest01;
 * EXPLICAÇÃO SOBRE wait, notify E notifyAll ESTÁ NO ARQUIVO Members DO PACOTE dominio;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO DO yield E join
 * */

public class ThreadTest04 {
  public static void main(String[] args) throws InterruptedException {

//    // podemos criar uma Thread diretamente do nosso código com programação funcional
//    // aqui estamos criando uma thread com classes anonimas
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//
//      }
//    });

//    // ou podemos criar com sintaxes lambdas
//    new Thread(() -> {
//
//    }).start();

//    // ou também tem essa outra forma, utilizando lambda também mas passando como argumento da Thread essa variavel
//    // example.
//    Runnable example = () -> {
//
//    };
//    Thread t1 = new Thread(example);


    Thread t1 = new Thread(new ThreadExampleRunnable3("KA"));
    Thread t2 = new Thread(new ThreadExampleRunnable3("ME"));

    // Vamos falar sobre o join
    /*
     * Temos a thread main, que é a thread que está executando tudo, e também temos outras threads, que são a t1 e t2
     * essas threads estão executando um método, eles estão executando o método run.
     * Quando damos t1.start na thread, estamos dizendo para thread main "thread main, você agora ta dando um t1.start,
     * você está deixando essa thread t1 do estado "New" para o estado "Runnable".
     * E depois, não é garantia de que vai ser exatamente depois mas continuando o fluxo do programa, a thread main vai
     * dar start no t2.
     * Então:
     * main -> t1.start
     * main -> t2.start
     * essas duas threads, t1 e t2 irão trabalhar no run.
     *
     * O que o join faz?
     * Quando iniciamos, vimos que não temos garantia de que o t1 vai sendo executado até o final, mas as vezes nós
     * queremos que, por exemplo, antes de chamarmos a t2, precisamos que a t1 finalize o trabalho dela e nesse caso
     * usamos o join.
     * O join, estamos falando para thread main, que é a thread que está iniciando as outras duas, está falando:
     * "Join("Junte-se") a thread que dermos o join, que pode ser t1.
     * Quando usamos o join, um exemplo, na t1, estamos falando para a main:
     * "Main, você não pode prosseguir, enquanto a thread t1 não terminar" ou seja, estamos falando para a main, inicia
     * e fica esperando a thread t1 terminar, a thread t1 vai fazer todos os processo que tem que fazer la no método
     * run e quando terminar, ai quando o processo terminar, vai mandar basicamente uma mensagem para a thread t1 e vai
     * falar: "Thread t1, agora você ta liberado", e quando liberar, ele vai continuar para a thread t2.
     *
     *                                    JOIN
     *                                     |
     *                                     |
     *                                     |               __________
     *                                     |              |          |----------------------|
     *   __________                        |------------->|    T1    |                 _____▼____
     *  |          |                       |              |__________|                |          |
     *  |   main   |-----------------------X               __________                 |    run   |
     *  |__________|                       |              |          |                |__________|
     *                                     |------------->|    T2    |                      ▲
     *                                     |              |__________|----------------------|
     *                                     |
     *                                     |
     *                                     |
     * */


    t1.setPriority(10);

    t1.start();

    // vemos que ele precisa de um tratamento de exceção, para este exemplo, podemos utilizar no proprio método main
    // podemos ver que a thread t2 só é executada quando a thread t1 é terminada
    t1.join();

    t2.start();



  }
}
