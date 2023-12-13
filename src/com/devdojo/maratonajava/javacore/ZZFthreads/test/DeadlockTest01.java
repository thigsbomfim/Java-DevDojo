package com.devdojo.maratonajava.javacore.ZZFthreads.test;

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * EXPLICAÇÃO DOS ESTADOS DA THREAD NO ARQUIVO ThreadTest02;
 * EXPLICAÇÃO DE PRIORIDADES E COMO COLOCAR UMA THREAD PARA DORMIR NO ARQUIVO ThreadTest03;
 * EXPLICAÇÃO SOBRE YIELD E JOIN ESTÁ NO ARQUIVO ThreadTest04;
 * EXPLICAÇÃO SOBRE THREAD SAFE ESTÁ NO ARQUIVO ThreadSafeTest01.
 * EXPLICAÇÃO SOBRE wait, notify e notifyAll ESTÁ NO ARQUIVO Members DO PACOTE dominio;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE DEADLOCK.
 * */
public class DeadlockTest01 {
  // Deadlock é um problema que pode acontecer quando estamos trabalhando com sincronismo e deadlock

  // Para exemplificar, imagina que temos duas threads, onde uma irá acessar o objeto A e a outra thread o objeto B:
  /*
    _________             _________
   |         |           |         |
   |  Natsu  |----------→|    A    |
   |_________|           |_________|
        |                         ↑
        |__________________       |
                          |       |
        __________________|_______|
        |                 |
    ____|____             ↓________
   |         |    Lock   |         |
   |  Lucy   |----------→|    B    |
   |_________|           |_________|

  Como fizemos na ultima aula ThreadAccountTest01, temos um sincronismo acontecendo no objeto account que na verdade
  é uma variavel de referência mas na verdade o objeto é o Account, que está sendo passado dentro do synchronized do
  método withdrawal.
  Agora imagine, que temos a thread t1 e threadt2.
  Quando a thread t1 pega o lock e a thread t2 chega no bloco de código criado dentro do método withdrawal do
  ThreadAccountTest01, e a thread t2 ve que o lock se encontra em outra thread, a thread t2 vai ficar esperando até que
  aquele lock seja liberado.
  Então, vamos supor que criarmos 300 threads, se uma thread pegar o lock, 299 threads ficaram esperando a thread que
  pegou o lock, liberar. Teremos aquela disputa de qual thread vai conseguir acessar o objeto e pegar o lock quando ser
  liberado.
  O que acontece é que, as threads que estão sem o lock, não é por que o bloco de código que elas querem acessar está
  bloqueado, que ela vai passar para a linha depois do bloco, não. Na verdade, a thread que está com o lock, vai ficar
  esperando aquele lock ser liberado.
  Vamos observar o exemplo abaixo:

  Na ilustração acima, temos o Natsu segurando o lock do objeto A, e a Lucy segurando o lock do objeto B.

  Mas ai imagine que por um acaso do destino, nós precisamos que o Natsu, ou seja, a thread Natsu, esteja segurando
  o lock do objeto A, mas ai o Natsu vai e diz "Puts, preciso utilizar o objeto B", na hora em que ele vai acessar o
  objeto B ele diz "Opa, Lucy está segurando o lock", ou seja, a thread Natsu fica esperando a thread Lucy liberar o
  lock, e a thread Lucy então está fazendo o processamento.
  Porém, por algum motivo, acabei desenvolvendo um código que fez "Opa, agora a thread Lucy, vai precisar acessar o
  objeto A", mas a thread Lucy precisa liberar o lock do objeto B para a thread Natsu processar o objeto B e conseguir
  liberar o lock do objeto A.
  Resumindo, para a thread Lucy conseguir acessar o objeto A, é preciso que ela libere o objeto B, para assim, a thread
  Natsu liberar o objeto A e processar o objeto B, que fica em um looping infinito de espera.
  Esse tipo de problema é chamado de DEADLOCK.
  Quando acontece um Deadlock, não tem muito o que ser feito, só reiniciando a aplicação.
  Essa classe "DeadlockTest01" deste arquivo, é um exemplo de Deadlock.
  */
  public static void main(String[] args) {
    Object lock1 = new Object();
    Object lock2 = new Object();

    // Estas variáveis, é a mesma coisa que a ilustração acima.
    Runnable r1 = ()-> {
      synchronized (lock1) {
        System.out.println("Thread Natsu: Segurando o lock 1.");
        System.out.println(
                "Thread Natsu: Esperando o objeto 'lock2' que está com a 'Thread Lucy' ser liberado para acessá-lo..."
        );
        System.out.println();

        synchronized (lock2){
          System.out.println(
                  "Thread Natsu: Dentro do synchronized do objeto 'lock2' e segurando o lock 2."
          );
        }

        // esse print abaixo só irá ser mostrado quando a "Thread Lucy" liberar o lock do objeto "lock2"
        System.out.println("Não passei do bloco de código acima ainda, é necessário que ele termine para ler");
      }
    };

    // para resolver esse problema de Deadlock do código, basta trocarmos o lock que está dentro do parâmetro do
    // primeiro synchronized de lock2 para lock1 e o synchronized que está dentro do bloco "synchronized (lock1)" mudar
    // para "synchronized (lock2)", como está na variavel "r1" acima.
    Runnable r2 = ()-> {
      synchronized (lock2) {
        System.out.println("Thread Lucy: Segurando lock 2.");
        System.out.println(
                "Thread Lucy: Esperando o objeto 'lock1' que está com a 'Thread Natsu' ser liberado para acessá-lo..."
        );
        System.out.println();

        synchronized (lock1){
          System.out.println("Thread Lucy: Dentro do synchronized do objeto 'lock1' e segurando o lock 1.");
        }

        // esse print abaixo só irá ser mostrado quando a "Thread Natsu" liberar o lock do objeto "lock1"
        System.out.println("Não passei do bloco de código acima ainda, é necessário que ele termine para ler");
      }
    };

    // aqui a thread Natsu está esperando a thread Lucy liberar o lock para conseguir acessar o bloco de código do lock2
    new Thread(r1).start();
    new Thread(r2).start();
  }
}
