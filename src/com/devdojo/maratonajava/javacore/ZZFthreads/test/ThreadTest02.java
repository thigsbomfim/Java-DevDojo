package com.devdojo.maratonajava.javacore.ZZFthreads.test;

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO DOS ESTADOS DA THREAD;
 * */

public class ThreadTest02 {

  // todas as vezes que nós damos start no método main, temos a thread main sendo executada.
  // imagina a thread main como se fosse um corredor, a thread main vai executar linha por linha, que irá executar uma
  // por uma.
  // quando chegar na linha do objeto t1, a thread main vai bater no ombro da t1, desse objeto t1, e vai dizer "você
  // pode startar";
  // depois vai para o objeto t2 e dizer a mesma coisa;
  // depois para o t3 e dizer a mesma coisa;
  // dps para o t4 e dizer a mesma coisa.
  // não necessariamente significa que vai acontecer nessa sequencia, por que quando iniciamos uma thread o scheduler
  // pode decidir, "opa, perai, agora main, antes de ir para a linha do objeto t2, perai que vou deixar a t1 rodar um
  // pouco, mas no final das contas a thread main que é principal nunca vai entrar nesse método run, por que para entrar
  // no método run, teriamos que chamar o método run e não start
  public static void main(String[] args) {
    Thread t1 = new Thread(new ThreadExampleRunnable('A'));
    Thread t2 = new Thread(new ThreadExampleRunnable('B'));
    Thread t3 = new Thread(new ThreadExampleRunnable('C'));
    Thread t4 = new Thread(new ThreadExampleRunnable('D'));
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    // podemos ver que logo lá em cima da exibição, podemos ver a thread main, então possivelmente depois dessa linha
    // a thread main morreu.
    // Quando a thread main morreu, nós ainda temos as outras threads sendo executadas.
    // Lembrando, o programa para quando todas as threads do usuario, que são as threads que nós criamos, elas se
    // encerram, elas mudam de estado para estado de thread morta.
    // Então a thread main, continua correndo, ai se ela vai parar para descansar ou não, é o scheduler que decide quem
    // vai continuar em execução, e como funcionam esses estados?
    /*
    *                                           ____________
    *                                          |  Waiting/  |
    *                                          |  Blocked   |
    *                                          |____________|
    *                                             |       ▲
    *                                             |       |
    *                                             |       |
    *                                     ________|       |________
    *                                    |                         |
    *                                    |                         |
    *                                    |                         |
    *      ____________            ______▼_____               _____|______            ____________
    *     |            |          |            |             |            |          |            |
    *     |    New     | -------> |  Runnable  | <---------> |   Running  | -------> |    Dead    |
    *     |____________|          |____________|             |____________|          |____________|
    *
    *
    * Então basicamente, quando criamos um objeto "New", nós temos a thread em estado de novo, quando damos um start,
    * a Thread passa a ser "Runnable".
    * Não necessariamente significa que a thread vai estar sendo executada, isso é o Scheduler que decide se a thread
    * vai executar ou não vai executar, mas quando damos um start, ela está pronta para mudar de estado para "Running".
    * E de "Running" você pode ou voltar para "Runnable" ou a thread pode ser bloqueada, você pode colocar a thread para
    * dormir.
    *
    * Lembrando que, uma thread não pode interferir na outra, então se uma thread está dormindo no estado
    * "Waiting/Blocked", foi decisão da propria thread.
    *
    * Por exemplo, a thread pode decidir esperar um recurso que uma outra thread está decidindo se vai ter ou não,
    * ou a thread pode falar "perai que to dormindo por 10 segundos, daqui a 10 segundos eu vou voltar a executar",
    * mas nunca do estado "Blocked", iremos voltar para "Running", sempre iremos voltar do estado "Blocked" para o estado
    * "Runnable".
    *
    * No nosso caso, da t1,t2,t3,t4, o que está acontecendo é que as threads não estão sendo bloqueadas "Blocked", elas
    * estão sendo executadas e muito provavelmente elas estão indo do estado "Running" para "Runnable", ou seja, quando
    * executamos a t1, ai a t1 está executando, ai agora estamos vendo t2, significa que t1 saiu do estado "Running"
    * e voltou para o estado de "Runnable" e agora t2 que está sendo executada, assim acontece com as outras threads.
    *
    * E quando todas as threads terminam, por exemplo, a main abaixo que acabou de ser executada, ela vai para o estado
    * de "Dead", ou seja, ela morreu. Depois que uma thread morre, a unica forma de reiniciarmos é criando um outro
    * completamente novo, não tem como reutilizarmos a mesma thread.
    * Quando uma thread morre, ela simplesmente morre, não temos mais o que fazer.
    *
    * Basicamente, esses são os estados principais:
    * Ela está preparada para ser executada = "Runnable";
    * Ela está executando = "Running";
    * Volta para preparada para ser executada = "Runnable";
    * Pode ser bloqueada ou depois de ser bloqueada colocar para esperar = "Waiting/Blocked";
    * Depois de bloqueada ou de esperar ela vai necessariamente voltar para o estado "Runnable", nem que seja para
    * executar só para morrer, mas ela precisa passar pelo estado "Runnable" depois pelo estado "Running" para assim
    * conseguir chegar no estado "Dead";
    * */

    System.out.println("###################### "+Thread.currentThread().getName());
  }
}
