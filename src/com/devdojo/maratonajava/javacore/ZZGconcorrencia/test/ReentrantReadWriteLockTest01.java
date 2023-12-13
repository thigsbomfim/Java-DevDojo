package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
  O objetivo desse ReentrantReadWriteLock é basicamente você ter um controle sobre leitura e escrita no mesmo objeto.
  Então quando estamos escrevendo, bloqueamos a leitura, por que não é ideal estarmos escrevendo e a pessoa lendo ao
  mesmo tempo, isso pode dar problema.
  E basicamente é um lock que funciona em par de "writeLock" e "readLock".


*/

class MapReadWrite {
  private final Map<String, String> map = new LinkedHashMap<>();
  private final ReentrantReadWriteLock rwl;

  public MapReadWrite(ReentrantReadWriteLock rwl) {
    this.rwl = rwl;
  }

  // Método para adicionar
  public void put(String key, String value){
    // Para obter o lock de escrita a partir da interface ReentrantReadLock.
    rwl.writeLock().lock();

//    Para obter o lock de leitura a partir da interface ReentrantReadLock.
//    rwl.readLock().lock();
    try {
      if(rwl.isWriteLocked()){
        System.out.printf("%s - obteve o lock de escrita!%n", Thread.currentThread().getName());
      }
      // Aqui estamos adicionando uma chave e valor dentro do Map que criamos nessa classe.
      map.put(key, value);
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      System.out.println("Liberando o lock de escrita!\n");
      rwl.writeLock().unlock();
    }
  }

  // Método para pegar todas as chaves de leitura e escrita
  public Set<String> allKeys(){
    // Você pode ter mais de uma thread obtendo o lock de leitura
    rwl.readLock().lock();
    try {
      return map.keySet();
    } finally {
      rwl.readLock().unlock();
    }
  }
}

public class ReentrantReadWriteLockTest01 {
  public static void main(String[] args) {
    // O que esse código está fazendo é basicamente:
    /*

     A thread "t1" obteve o lock de escrita "writeLock" e entrou no laço de repetição que é executado 20 vezes e
     que adiciona a cada iteração, pares de chave e valor no atributo "map" da classe "MapReadWrite" com o próprio
     indice desse laço de repetição.

     Esse laço de repetição executa o método "mapReadWrite.put(String.valueOf(i), String.valueOf(i))" 20 vezes.
     Quand ele acaba de executar, ele sai do laço e libera o "writeLock".

     Logo quando o "writeLock" é liberado, na variavel de referência "reader", é possível utilizar o "readLock".

     Nessa variavel de referência "reader" é onde verificamos se o "writeLock" está bloqueado ou não, utilizando o
     método "isWriteLocked()", que faz parte da classe "ReentrantReadWriteLock".

     Logo depois da verificação, utilizamos o "readLock" para imprimir dizendo que conseguimos capturar o lock de
     escrita "writeLock" e também para imprimir as chaves que foram atribuidas no atributo "map" da classe
     "MapReadWrite", quando fizemos a iteração com o método "put" na variável de referência "writer".

    */
    // RESUMO:
    // Podemos ter varias threads de leitura ("readLock") obtendo o mesmo lock depois do "writeLock" ter liberado.
    // O "readLock" só poderá ser executado quando o "writeLock" tiver liberado o lock.
    // E quando o "writeLock" liberou o lock, as threads "readLock" conseguiram realizar a leitura.

    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    MapReadWrite mapReadWrite = new MapReadWrite(rwl);

    Runnable writer = () -> {
      for(int i = 0; i < 20; i++){
        // Aqui estamos chamando o método "put" da classe "MapReadWritee" e adicionando o laço que vai ser executado 20
        // vezes, e adicionando o próprio índice desse laço de repetição para atribuir uma chave e um valor como
        // argumento do método.
        // Depois que esse laço de repetição for finalizado, irá ser liberado o lock de escrita "writeLock".
        // E assim, logo quando o lock de escrita "writeLock" for liberado, o lock de leitura "readLock" poderá ser
        // utilizado na variável de referência "reader", onde essa variável será atribuida na thread "t2" e "t3".
        mapReadWrite.put(String.valueOf(i), String.valueOf(i));
      }

      System.out.println(Thread.currentThread().getName()+
              " - FINALIZEI O LAÇO DE REPETIÇÃO E LIBEREI O 'writeLock' PARA O 'readLock' LER\n");
    };

    Runnable reader = () -> {
      // Para saber se o lock de escrita está bloqueado, basta utilizar o método "isWriteLocked" que faz parte da classe
      // "ReentrantReadWriteLock".
      // Não podemos pegar o lock de leitura ("readLock") se o lock de escrita ("writeLock") estiver bloqueado.

      if(rwl.isWriteLocked()) {
        // Esse if só é executado uma vez, para dizer que o lock de escrita está bloqueado.
        System.out.println("LOCK DE ESCRITA BLOQUEADO!");
      }

      // Abaixo estamos pegando o lock de leitura, pois a thread "t1" liberou o lock de escrita ("writeLock") logo
      // depois de ter terminado o laço de repetição na variavel de referência "writer".
      // Estamos utilizando o "readLock" dentro dessa thread, para aproveitar e utilizar o System.out.println, por que
      // pode ser que dê problema, não temos muita certeza.
      // Ou seja, só utilizamos o "readLock" dentro desse runnable "reader", que é o argumento da thread "t2" e "t3",
      // só por causa do lock de escrita ("writeLock") que está ocorrendo dentro dessa runnable "reader", quando
      // utilizamos o "if" acima, ele capturou o lock de escrita ("writeLock"), onde agora podemos utilizar o "readLock"
      rwl.readLock().lock();
      System.out.println(Thread.currentThread().getName()+" -> FINALMENTE CONSEGUI O 'writeLock' QUE ESTAVA BLOQUEADO");
      try{
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " - imprimindo somente as chaves do map -> " +
                mapReadWrite.allKeys());
      } finally {
        rwl.readLock().unlock();
      }
    };

    Thread t1 = new Thread(writer, "ThreadWrite");
    Thread t2 = new Thread(reader, "ThreadReader1");
    Thread t3 = new Thread(reader, "ThreadReader2");

    t1.start();
    t2.start();
    t3.start();
  }
}
