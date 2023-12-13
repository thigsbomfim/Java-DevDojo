package com.devdojo.maratonajava.javacore.ZZFthreads.test;

import java.util.ArrayList;
import java.util.List;

// Podemos ver que ao executar as threads no método main, ocorre uma exceção.
// O que podemos ver o que está acontecendo aqui?
// A nossa coleção names, ela é thread safe, mas quando estamos trabalhando com classes que são thread safe, precisamos
// olhar um nível acima.
// Então no nosso caso, nós criamos uma classe ThreadSafeNames que está trabalhando com uma coleção que é
// thread safe, mas os métodos que estão acima, não são thread safe, como o método add e o método removeFirst.
// Então, vamos ter mais de uma thread acessando os método mais de uma vez.
// Se executarmos o if do método removeFirst, ele vai cair no mesmo problema que vimos no ThreadAccountTest01.
// Temos duas threads executando um mesmo pedaço de código.
// Então quando falamos que uma classe é uma thread safe, a classe em si é, os métodos são, mas se tivermos um
// método acima que está fazendo algum tipo de operação, precisamos sincronizar esse método também.
// Para ser completamente thread safe, basta passar o synchronized nos métodos e fazendo isso, não vamos mais precisar
// do método synchronizedList da classe Collections.

// Agora como podemos ver, agora nossa classe é thread safe, por que todos métodos que vão acessar o objeto que pertece
// a essa classe, estão sincronizados.
// Então sempre que formos trabalhar com objetos que são thread safe, temos que tomar cuidado com o código que estamos
// fazendo, por que se não, não vai adiantar nada os objetos, a classe em si, os métodos sincronizados e thread safe e
// o nosso não for.
class ThreadSafeNames {
  // Collections.synchronizedList() -> é um método que vai retornar uma lista thread safe, onde precisamos passar um
  // objeto por argumento.
  // usando o synchronizedList para sincronizar uma coleção.
//  private final List<String> names = Collections.synchronizedList(new ArrayList<>());

  // Aqui estamos criando um array sem sincronizar, pois os próprios métodos ja estarão sincronizados.
  // então nossos nomes serão thread safe, por que quando adicionarmos, o método add contém o synchronized e quando
  // formos remover o primeiro nome, o método removeFirst também contém o synchronized.
  // Como não temos o get e nem o set, não podemos acessar diretamente esses names, ele não existe.
  // Tudo que eu tenho para acessar essa variavel names está sincronizado.
  private final List<String> names = new ArrayList<>();

  // aqui estamos criando um método para adicionar um novo nome.
  // ao invez de acessar diretamente names.add, estamos fazendo uma camada de abstração em cima.
  // é um método é sincronizado.
  public synchronized void add(String name) {
    names.add(name);
  }

  // método criado para remover o primeiro elemento
  // é um método sincronizado.
  public synchronized void removeFirst(){
    if(names.size() > 0) {
      System.out.println(Thread.currentThread().getName());
      System.out.println(names.remove(0));
    }
  }
}

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * EXPLICAÇÃO DOS ESTADOS DA THREAD NO ARQUIVO ThreadTest02;
 * EXPLICAÇÃO DE PRIORIDADES E COMO COLOCAR UMA THREAD PARA DORMIR NO ARQUIVO ThreadTest03;
 * EXPLICAÇÃO SOBRE yield E join ESTÁ NO ARQUIVO ThreadTest04;
 * EXPLICAÇÃO SOBRE DEADLOCK ESTÁ NO ARQUIVO DeadlockTest01;
 * EXPLICAÇÃO SOBRE wait, notify E notifyAll ESTÁ NO ARQUIVO Members DO PACOTE dominio;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE THREAD SAFE.
 * */
public class ThreadSafeTest01 {
  public static void main(String[] args) {
    // Nós vimos que tem algumas classes que são chamadas thread safe.
    // a diferença entre StringBuilder e StringBuffer é que a classe StringBuffer ela é uma thread safe
    // O que significa uma classe thread safe?
    // Os métodos que nós temos para acesso dessa classe são métodos sincronizados, mas devemos ter muito cuidado quando
    // estamos trabalhando com thread safe, por que também precisamos tomar cuidado para ter certeza absoluta do que
    // estamos fazendo é thread safe.
//    StringBuffer

    // criamos um objeto, que é um thread safe
    ThreadSafeNames threadSafeNames = new ThreadSafeNames();
    threadSafeNames.add("Junkrat");

    // aqui podemos tanto utilizar a sintaxe lambda quanto a method refence para criar um "Runnable", onde o código
    // que fornecemos dentro é o código que vai dentro do método run.
    // Sintaxe lambda:
//    Runnable r = () -> {
//      threadSafeNames.removeFirst();
//    };

    // Sintaxe method reference:
    Runnable r = threadSafeNames::removeFirst;

    // agora que temos um runnable, precisamos passar o runnable para uma thread se não, não conseguimos dar start
    new Thread(r).start();
    new Thread(r).start();


  }
}
