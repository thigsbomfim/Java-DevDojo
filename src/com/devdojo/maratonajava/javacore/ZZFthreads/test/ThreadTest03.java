package com.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExampleRunnable2 implements Runnable {
  private final char c;

  public ThreadExampleRunnable2(char c) {
    this.c = c;
  }

  @Override
  public void run() {
    // estamos colocando esse código dentro do método run para observarmos todas as threads que serão executadas
    System.out.println(Thread.currentThread().getName());
    for (int i = 0; i < 500; i++) {
      System.out.print(c);
      // se o "i" for multiplo de 100 eu quero que quebre uma linha
      if(i % 100 == 0){
        System.out.println();
      }

      // Vamos falar sobre o Sleep:
      // Por exemplo, as vezes nós queremos utilizar uma thread, a thread está dentro de um looping, digamos que esse loop
      // vai consultar um estoque ou consulta uma API a cada determinado momento e não queremos que ele fique executando.
      // Geralmente existe a possibilidade de utilizarmos o "Thread.sleep();", então como podemos ver, o "Thread.sleep" é
      // um método estático, por que nenhuma outra thread pode falar "o thread2, você vai dormir agora" não é assim,
      // a thread2 mesmo que vai decidir se ela vai dormir ou não.

      // O argumento recebido é um milisegundos.
      // Então se decidirmos falar que "dorme por 2000 milisegundos", ou seja, 2 segundos, essa é uma das poucas coisas
      // que é garantido acontecer.
      // Podemos ver que é necessário tratar a exceção, e não podemos adicionar no método, pois estamos sobrescrevendo e
      // não tem essa exceção lá.
      // Então o sleep precisar estar dentro de um try/catch, por que se ela não dormir os 2 segundos teremos uma
      // exceção.
      // É uma das poucas garantias no mundo das threads é que ela vai dormir por 2 segundos, se colocarmos thread de
      // 2 segundos.
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * EXPLICAÇÃO DOS ESTADOS DA THREAD NO ARQUIVO ThreadTest02;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO DE PRIORIDADES E COMO COLOCAR UMA THREAD PARA DORMIR;
 * */

public class ThreadTest03 {
  public static void main(String[] args) {
    // Uma coisa interessante a ser fazer, é que podemos dar nomes para as threads, basta colocar como segundo argumento
    // do construtor.
    // Quando executarmos, poderemos ver que as threads terão seus nomes impressos no console.
    
    Thread t1 = new Thread(new ThreadExampleRunnable2('A'), "T1A");
    Thread t2 = new Thread(new ThreadExampleRunnable2('B'), "T2B");
    Thread t3 = new Thread(new ThreadExampleRunnable2('C'), "T3C");
    Thread t4 = new Thread(new ThreadExampleRunnable2('D'), "T4D");


    // Prioridades das threads:
    // As threads tem uma prioridade, geralmente a prioridade ela vai de 1 a 10.
    // podemos setar que queremos que a t4 execute primeiro, para isso, basta chamar o método setPriority, geralmente
    // vai de 1 a 10, mas a JVM é uma específicação, temos varios tipos de implementações de JVM, então por exemplo,
    // temos a JDK, da ORACLE a da MICROSOFT, ou seja, a implementação pode ser diferente.
    // Então em algumas, vai de 1 a 10, sendo 1 a menor prioridade e 10 a maior prioridade.
    // O aconselhado é usar:
    // Thread.MIN_PRIORITY = 1 -> para menor prioridade;
    // Thread.NORM_PRIORITY = 5 -> para prioridade média;
    // Thread.MAX_PRIORITY = 10 -> para prioridade maxima.

    // O que estamos dizendo quando colocamos uma prioridade 10, estamos dizendo que, estamos dando uma indicação para
    // o Scheduler para ele dar uma prioridade para t4, significa que ele terá uma prioridade? não, não é garantido que
    // tenha uma prioridade, mas estamos dando uma indicação.
    // Podemos ver que mesmo setando uma prioridade, a thread está sendo executada posteriormente a t1.
    // Na maioria das vezes a prioridade não vai mudar muita coisa, depende muito da implementação da JVM.
    // Não devemos desenvolver nosso código baseado nessa prioridade.
    t4.setPriority(Thread.MAX_PRIORITY);


    t1.start();
    t2.start();
    t3.start();
    t4.start();

    System.out.println("###################### "+Thread.currentThread().getName());
  }
}
