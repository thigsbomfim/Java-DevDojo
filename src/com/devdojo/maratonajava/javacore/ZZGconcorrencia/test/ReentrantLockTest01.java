package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * EXPLICAÇÃO SOBRE Lock E ReentrantLock NO ARQUIVO LockAndReentrantLockTest01
 * NESSE ARQUIVO TEMOS MAIS ALGUNS EXEMPLOS UTILIZANDO ReentrantLock
 * */

class Worker implements Runnable{
  private String name;
  private ReentrantLock lock;

  public Worker(String name, ReentrantLock lock) {
    this.name = name;
    this.lock = lock;
  }

  @Override
  public void run() {
    // Todas as vezes que formos rodar essa classe, quero obter o lock.
    lock.lock();
    // caso fossemos utilizar esse código abaixo ao inves do código acima, teriamos que passar um if dentro do bloco
    // finally para saber se a thread que está executando esse código, se essa thread possui o lock, para assim
    // conseguir utilizar o "lock.unlock()"
//    lock.tryLock(2, TimeUnit.SECONDS);
    try{
      // Esse if é um exemplo se tivessemos utilizando o "lock.tryLock()" acima ao inves do "lock.lock()"
//      if(lock.isHeldByCurrentThread()){
//        System.out.printf("Thread %s pegou o LOCK%n", name);
//      }

      System.out.printf("Thread '%s' entrou em uma sessão crítica.%n", name);
      // Mais um método interessante que temos dentro do ReentrantLock é a quantidade de threads esperando para obter,
      // quando você quer pegar o numero, é utilizado o método "getQueueLength()" que basicamente retorna um valor do
      // numero de threads esperando para adquirir esse lock.
      // Para substituir um valor numérico no printf é usado "%d".
      // Para substituir um valor float numérico é usado "%f".
      // Para quebrar linha, é utilizado o "%n"
      System.out.printf("'%d' Threads esperando na fila.%n", lock.getQueueLength());
      System.out.printf("Thread '%s' vai esperar por 2s.%n", name);
      Thread.sleep(2000);
      System.out.printf("Thread '%s' finalizou a espera.%n", name);

    } catch (InterruptedException e) {
      throw new RuntimeException(e);

    } finally {
      // Exemplo utilizando um if
      // Esse exemplo com um if dentro do bloco finally é para quando estamos utilizando o "tryLock" ao invés do próprio
      // "lock.lock()".
      // Para saber se a thread que está executando esse código, se essa thread possui o lock, o método que utilizado é
      // chamado de "isHeldByCurrentThread()" e faz parte da interface ReentrantLock.
      // Ele verifica se o lock está nas mãos da thread que está executando o código agora.
      // Não precisamos utilizar esse if, foi apenas um exemplo de como poderia ser utilizado.
      // Esse if pode ser interessante, por exemplo, se a gente tentasse obter o lock.
      // Então digamos que a primeira linha do método run, o código ficasse dessa forma
      // "lock.tryLock(2, TimeUnit.SECONDS);" ao inves de "lock.lock();", estariamos dizendo para o if, que quando
      // conseguisse capturar o lock, ele iria chamar o unlock.
      // Mas nesse caso, poderia ocorrer uma exceção, pois no bloco finally, estamos pedindo para dar um unlock e não é
      // garantido que conseguiremos obter o lock pois estamos utilizando o tryLock, onde estamos tentando obter o lock
      // e não obtendo ele em si.
//      if(lock.isHeldByCurrentThread()){
//        lock.unlock();
//      }

      // Para não esquecer de liberar o lock.
      lock.unlock();
    }
  }
}

public class ReentrantLockTest01 {
  public static void main(String[] args) {
    // Mesmo utilizando o fairness no argumento do ReentrantLock, não é garantido que o Worker com o name de "G" vá
    // executar quando o lock for liberado.
    ReentrantLock lock = new ReentrantLock(true);
    new Thread(new Worker("A",lock)).start();
    new Thread(new Worker("B",lock)).start();
    new Thread(new Worker("C",lock)).start();
    new Thread(new Worker("D",lock)).start();
    new Thread(new Worker("E",lock)).start();
    new Thread(new Worker("F",lock)).start();
    new Thread(new Worker("G",lock)).start();
  }
}
