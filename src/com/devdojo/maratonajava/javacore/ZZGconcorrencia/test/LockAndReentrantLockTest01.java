package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * EXPLICAÇÃO SOBRE AtomicInteger DO PACOTE concurrent NO ARQUIVO AtomicIntegerTest01
 * NESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE A CLASSE Lock E ReentrantLock DO PACOTE concurrent
 * */


class Counter2{
  private int count;
  private AtomicInteger atomicInteger = new AtomicInteger();

  // Qual a diferença do modificador synchronized e essa interface Lock e ReentrantLock?
  // Basicamente, quando utilizamos o synchronized, não temos muito controle, o lock é totalmente gerenciado pela JVM.
  // Agora quando estamos trabalhando com a classe Lock, temos algumas vantagens:
  // A primeira delas é que o construtor do ReentrantLock tem esse conceito que basicamente fala "Olha, agora que eu to
  // com o lock, quando eu for liberar esse lock, se o argumento que passarmos no construtor do ReentrantLock for true,
  // ele vai tentar passar a bola para thread que está esperando a mais tempo", quando estamos utilizando synchronized
  // não tem isso.
  // Outra diferença significante é que você pode tentar obter o lock, então esse lock tem um método chamado tryLock,
  // onde você pode falar "Olha, tenta ai esperar esse lock por 3 segundos, caso você não consiga, continua a execução"
  // Então você consegue obter, quando você está usando o synchronized não é possível, simplesmente trava, as threads
  // ficam em estado de Waiting.
  // Outra diferença que vale a pena mencionar é que você tem a possibilidade de interromper a thread que está esperando
  // pelo lock.
  // Então se você tiver uma thread esperando pelo lock, se você tiver utilizando esse ReentrantLock, você consegue
  // interromper aquela thread.
  // Mas tem uma grande desvantagem, é que o código fica muito feio, por que agora você está trabalhando manualmente com
  // o lock, quando você está trabalhando manualmente com o lock, você tem que ter certeza absoluta de que você
  // vai liberar o lock.
  private Lock lock = new ReentrantLock();
  void increment(){
    // Método para tentar esperar o lock, se não conseguir, continua na execução.
//    lock.tryLock(3, TimeUnit.SECONDS);


    // Para pegar o lock, é utilizamos esse método "lock()".
//    lock.lock();
    // Mas o problema é que quando você obtem o lock, você tem que ter certeza absoluta de que você vai liberar esse
    // lock, se não você vai tendo o que nós chamamos de "Memory Leak" e você pode até mesmo fazer o seu programa travar
    // Imagine que você tem uma exceção, se você tem uma exceção, simplesmente o seu código vai passar a parte, se você
    // liberar o lock, utiliza-se "lock.unlock()", essa é a forma que você libera um lock, mas se tiver uma exceção no
    // meio do nosso código, dessa forma:
    /*
      Exemplo

      lock.lock();

      // Se houver exceções nessas linhas entre o lock e o unlock, você simplesmente vai deixar aquela thread com o lock
      // e não vai liberar.
      int soma = 1+1;

      lock.unlock();
    */
    // Então como resolvemos esse problema? Dessa forma:
    // Como não precisa tratar a exceção, quer dizer, não precisa ter uma exceção do tipo checked, você pode utilizar
    // o try/finally, onde você coloca o unlock no finally e no try o código que você precisa fazer.
    // Caso de algum problema, independente ter exceção de ter exceção ou não, o finally sempre vai ser executado.
    // Você tem que fazer isso todas as vezes que você tentar adquirir o lock manualmente, então no final das contas
    // o código acaba ficando bem poluído, não tem muita saída para esse código. Você poderia passar ele para um método
    // Mas no final das contas só estou jogando o problema para outro lugar.

    // Então devemos usar esse lock? A não ser que que você queira realmente utilizar uma das vantagens que é o fairness
    // ou você utilizar o tryLock, ou a habilidade de interromper a thread que ela está esperando, eu diria que você
    // pode simplesmente usar o synchronized. Muitas pessoas tem os costumes "Ah, utilizar o lock é maneiro, é avançado"
    // Os desenvolvedores realmente que são mais avançados, eles tentam manter o código o mais simples possível, se você
    // utilizar o synchronized para manter o código mais simples tendo o mesmo objetivo que o nosso lock vai trazer,
    // simplesmente vai com synchronized.
    lock.lock();
    try{
      count++;
      atomicInteger.incrementAndGet();
    } finally {
      // Método usado para liberar o lock, geralmente é utilizado no final do seu código.
      lock.unlock();
    }

  }

  public int getCount() {
    return count;
  }

  // Método getter para pegar o valor de atomicInteger
  public AtomicInteger getAtomicInteger() {
    return atomicInteger;
  }
}

public class LockAndReentrantLockTest01 {

  public static void main(String[] args) throws InterruptedException {

    Counter2 counter = new Counter2();
    Runnable r = () -> {
      for (int i = 0; i < 10_000; i++){
        counter.increment();
      }
    };

    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(counter.getCount());
    System.out.println(counter.getAtomicInteger());
  }
}
