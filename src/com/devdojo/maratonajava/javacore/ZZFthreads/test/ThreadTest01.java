package com.devdojo.maratonajava.javacore.ZZFthreads.test;

// Thread tem duas definições:
// pode ser um objeto, pq temos uma classe chamada thread onde podemos criar literalmente um objeto do tipo Thread
// e temos um processo, uma linha de execução.
// no sistema operacional, temos diversos tipos de threads, indo no gerenciador de tarefas podemos observar na aba
// desempenho, vemos que o proprio sistema operacional tem varias threads sendo executadas, ou seja, são como se fossem
// trabalhadores que dividem a carga de tarefas de um determinado processo, então vamos supor que tenhamos 215 processos
// e 3000 threads subindo e descendo para cada um dos processos é meio que divido entre essas threads, a parte de
// não importa pra gente, não tem como a gente dizer.
// Basicamente, quando estamos trabalhando com threads, pouca coisa é garantida, a JVM vai tomar conta da execução das
// threads e na maioria dos casos, não temos muito o que fazer, podemos só meio que dar indicações do que gostariamos
// que acontecesse, mas a parte de escalonamento quando a thread vai ser executada, quando ela vai ser parada, quando
// ela vai ser terminada, é tudo parte da JVM.

// E pra que utilizamos threads?
// Quando temos processadores, geralmente o processador temos os núcleos e os processadores lógicos, que geralmente são
// o dobro do núcleo, ou seja, no nosso pc da quarta geração, temos 4 núcleos e processadores lógicos que são 8,
// ou seja, temos 8 threads que podem ser utilizadas paralelamente nesse caso, todas as outras threads que temos aqui,
// são threads virtuais, não são threads consideradas threads nativas.

// Então o java, nós podemos trabalhar também com threads nativas.
// Nós temos dois tipos de threads:
// Daemon
// User
// O que precisamos saber sobre as threads do tipo "Daemon" e "User" é:
// O java encerra o programa quando todas as threads do tipo "User" são terminadas.
// Threads do tipo "Daemon" não tem tanta prioridade e é por exemplo uma thread que toma conta do "Garbage collector",
// ou seja, que vai remover e limpar os objetos de memoria e uma thread do tipo "Daemon", ou seja, se aquela thread estiver sendo executada e as threads do tipo User tiverem sido finalizadas o programa vai
// acabar independente da thread do tipo Daemon estiver rodando ou não, então ele meio que descarta.

// E quando nós falamos, se temos múltipas threads em algumas operações podemos executar em paralelo, como vimos em
// paralel streams, aqui nós vamos fazer manualmente o processo de trabalhar com threads.

// lembrando que essa forma não é indicada, pois quando estamos trabalhando com heranças, estamos falando que estamos
// especializando uma classe, mas na verdade aqui não estamos especializando a classe thread.
class ThreadExample extends Thread{
  private final char c;

  public ThreadExample(char c) {
    this.c = c;
  }

  // agora temos um objeto que é do tipo thread, e o código que nós queremos que sejam executados por threads diferentes
  // precisa ir no método, se observarmos, temos o método run que precisamos sobrescrever.
  // e dentro desse método run é o código que colocarmos que vai ser executado pela thread separada.
  // agora que temos esse exemplo, o que podemos fazer? primeiro criar um objeto na main.
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
    }
  }
}

// aqui faz mais sentido pois estamos dizendo que essa classe é um Runnable e ela obrigatoriamente terá que sobrescrever
// o método run.
// Forma indicada para criar uma Thread.
class ThreadExampleRunnable implements Runnable {
  private final char c;

  public ThreadExampleRunnable(char c) {
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
    }
  }
}

public class ThreadTest01 {
  public static void main(String[] args) {
    // Todos os programas tem threads e todas as threads tem nomes, como pegamos esse nome da thread?
    // podemos ver que o resultado é "main", mas não é por causa do nome do método acima, mas sim por que é a thread que
    // inicia o programa no java é chamada de thread "main"
//    System.out.println(Thread.currentThread().getName());

    // como podemos criar uma thread?
    // existem algumas formas:
    // 1° dela é extendendo a classe Thread, como criamos acima com a classe ThreadExample.
//    ThreadExample t1 = new ThreadExample('A');
//    ThreadExample t2 = new ThreadExample('B');
//    ThreadExample t3 = new ThreadExample('C');
//    ThreadExample t4 = new ThreadExample('D');
    // se chamarmos assim, não estamos executando em threads diferentes
    // podemos ver que se chamarmos assim, ele vai imprimir o nome da thread que é main e o atributo "c" que é "A"
    // depois novamente imprime a thread main que está sendo executada dps o atributo "c" que é "B",
    // depois novamente imprime a thread main que está sendo executada dps o atributo "c" que é "C",
    // depois novamente imprime a thread main que está sendo executada dps o atributo "c" que é "D",
    // quando chamamos o método run, estamos falando thread main, executa o método run do objeto t1/t2/t3/t4.
//    t1.run();
//    t2.run();
//    t3.run();
//    t4.run();
    // ou seja, utilizamos apenas uma thread que é a thread main, por que não damos um start, quando estamos trabalhando
    // com múltiplas threads, ao invés de chamarmos run, chamamos o método start que as coisas mudam, por que agora
    // estamos falando para a JVM começar uma nova thread, ou seja, todas as vezes que a thread main chegar no t1, a
    // thread main vai dar um start em uma outra thread.
    // dessa forma abaixo, podemos ver que as threads estão sendo alternadas, fica mais dificil saber quem está
    // imprimindo no console ou não, por que ele troca, não temos como saber a ordem de execução das threads, se
    // executarmos novamente esse código, podemos ver que a ordem ja é completamente diferente, ou seja, não temos
    // garantia nenhuma de que o resultado vai ser sempre o mesmo. Então meio que estamos executando esse código em
    // paralelo mas a porcentagem de tempo que cada uma das threads vai ficar executando esse código é decidido pela
    // JVM, não tem o que nós fazermos muito para isso.
    // não podemos dar start mais de uma vez na thread, uma vez que damos start uma vez na thread, não podemos dar
    // um start novamente pois teremos uma exceção.
//    t1.start();
//    t2.start();
//    t3.start();
//    t4.start();


    // 2° forma que temos de criar threads é implementando a interface Runnable:
    // Como criamos a classe acima ThreadExampleRunnable.
    // aqui estamos criando uma thread, que recebe o ThreadExampleRunnable, mas podemos ver que contém um erro, por que
    // o que estamos querendo é uma thread e estamos passando um ThreadExampleRunnable.
//    Thread t1 = new ThreadExampleRunnable('A');
    // para resolver isso, podemos passar o objeto que é um Runnable por argumento do objeto Thread, estamos
    // encapsulando o objeto ThreadExampleRunnable dentro de um objeto Thread, que tem um construtor sobrecarregado
    // que aceita um Runnable.
    // é a forma mais recomendavel de trabalhar com Threads, implementando a interface Runnable.
    Thread t1 = new Thread(new ThreadExampleRunnable('A'));
    Thread t2 = new Thread(new ThreadExampleRunnable('B'));
    Thread t3 = new Thread(new ThreadExampleRunnable('C'));
    Thread t4 = new Thread(new ThreadExampleRunnable('D'));
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
