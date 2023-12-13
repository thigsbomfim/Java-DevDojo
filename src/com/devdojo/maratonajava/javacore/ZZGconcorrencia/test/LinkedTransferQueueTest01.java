package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

// Basicamente essa classe "LinkedTransferQueue" é uma junção de outras 3 Queue:
// "ConcurrentLinkedQueue", "SynchronousQueue", "LinkedBlockingQueue".
// É uma classe que juntou as funcionalidades dessas três classes acima em um lugar só.

/**
 * ARQUIVO COM A EXPLICAÇÃO DA INTERFACE BlockingQueue NO ARQUIVO BlockingQueueTest01;
 * ESSE ARQUIVO ESTÁ FALANDO SOBRE A CLASSE LinkedTransferQueue E SEUS MÉTODOS: "add", "offer", "put", "transfer",
 * "tryTransfer", "element", "peek", "poll", "remove", "take" e "remainingCapacity".
 * */
public class LinkedTransferQueueTest01 {
  public static void main(String[] args) throws InterruptedException {
    // Foi introduzido na versão 1.7 do java.
    // Se precisarmos trabalhar com esse tipo de coleções de concorrências, quanto mais nova for a versão, provavelmente
    // vamos ter um melhor desempenho.
    // A interface "TransferQueue" contém todas as funcionalidades que temos na "LinkedTransferQueue".


    TransferQueue<Object> tq = new LinkedTransferQueue<>();
    // Temos um método "add" na classe LinkedTransferQueueque.
    // Esse método basicamente vai inserir o elemento, se for possível, vai fazer imediatamente, sem violar a
    // capacidade de elementos de dentro e vai retornar um true ou vai retornar um throw "IllegalStateException", caso
    // não tenha espaço para colocar o elemento lá dentro, vai lançar essa exceção.
    // Aqui estamos imprimindo o resultado da inserção.
    System.out.println(tq.add("william"));

    // Para capturar true se inserir com sucesso e false se não tiver espaço disponível, basta utilizar o método
    // "offer".
    // Então quando estamos utilizando alguma classe que tenha capacidade limitada de elementos, podemos utilizar o
    // método "offer" dependendo da nossa regra de negócio.
    System.out.println(tq.offer("william"));

    // E também temos o método "offer" de uma forma diferente.
    // Digamos que você queira tentar, em vez de ser imediatamente tentar inserir, você quer tentar inserir, por
    // exemplo, em 10 segundos, basta utilizar como segundo argumento o tempo e o terceiro a classe TimeUnit:
    // Essa versão basicamente vai tentar inserir o elemento e vai esperar por 10 segundos, o tempo que definimos, vai
    // esperar o espaço ficar disponível.
    System.out.println(tq.offer("william", 10, TimeUnit.SECONDS));

    // Temos o método "put".
    // Ele basicamente insere um elemento caso um espaço esteja disponível, se não tiver, ele bloqueia, esperando que
    // um espaço fique disponível, igual fizemos na aula "BlockingQueueTest01".
    tq.put("DevDojo");

    // Temos também dois métodos bem interessante, chamado "transfer" e "tryTransfer".
    // Ele literalmente vai bloquear a thread, ou seja, vai ficar esperando um elemento tentar pegar o valor que
    // colocamos.
    // Isso é uma caracteristica da classe "SynchronousQueue", ela começa com um tamanho 0, quando você adiciona um
    // valor, aquele valor imediatamente fica esperando até que uma outra thread pegue. Então o conceito de consumidor,
    // "Producer" e "Consumer", aquele que produz e aquele que consome, é utilizado aqui nesse "transfer".
    // Então quando você adiciona um elemento, ele vai ficar esperando até que um outro elemento venha e pegue o
    // elemento através do "take" do "poll".
    // Ele basicamente fica esperando uma outra thread vir e pegar o elemento imediatamente.
    // O que poderiamos fazer é utilizar o método "hasWaitingConsumer". Esse método basicamente vai verificar se você
    // tem um consumidor esperando, ou seja, se alguem tentou dar um take e não tem nenhum valor.
    if(tq.hasWaitingConsumer()) {
      tq.transfer("Devojo");
    }
    // Caso não queira utilizar um if, podemos utilizar o método "tryTransfer".
    // Esse método vai fazer justamente o que está falando, ele vai tentar transferir o elemento imediatamente, e caso
    // não tenha, ele vai retornar false.
    // Ele retorna false caso não tenha nenhum consumidor/elemento esperando.
    System.out.println(tq.tryTransfer("Academy"));

    // Caso queiramos esperar, podemos utilizar dessa forma:
    // Ele vai esperar até o consumidor aparecer em 5 segundos, caso algum consumidor apareça, se não, vai retornar
    // false.
    System.out.println(tq.tryTransfer("Academy", 5, TimeUnit.SECONDS));

    // Também temos o método "element".
    // Ele basicamente vai exibir o primeiro elemento dessa fila mas não vai remover.
    // A única diferença desse método é que ele vai lançar uma exceção se a lista estiver vazia.
    System.out.println(tq.element());

    // Caso você só queira pegar, podemos utilizar o método "peek", como vimos anteriormente, que ele trás somente o
    // o primeiro elemento e se estiver vazio, retorna "null".
    System.out.println(tq.peek());

    // E temos também o método "poll".
    // Ele pega e remove o primeiro elemento dessa fila, ou vai retornar nulo se esse elemento for vazio.
    // O "poll" e o remove trabalham meio que similarmente, a diferença é que o remove, vai lançar uma exceção caso
    // esteja vazia enquanto o "poll" simplesmente vai retornar nulo.
    System.out.println(tq.poll());
    System.out.println(tq.remove());

    // E temos o método "take".
    // Ele mostra e remove o primeiro elemento da lista e vai ficar esperando, caso esteja vazia, ele vai ficar
    // esperando até que alguém coloque um valor lá dentro.
    System.out.println(tq.take());

    // Apesar do "LinkedTransferQueue" não ter como colocar uma capacidade de elementos que vai ter dentro da fila, ele
    // já tem uma capacidade definida, que é "2147483647".
    // Para ver qual é a capacidade, basta usar o comando abaixo:
    System.out.println(tq.remainingCapacity());

  }
}
