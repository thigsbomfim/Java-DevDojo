package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;
import java.util.concurrent.atomic.AtomicInteger;

// Vamos imaginar que temos o seguinte problema:
// Imagine que estamos fazendo um jogo e nesse jogo você tem uma determinada quantidade de monstros que aparece no
// mapa.
// Imagine que temos duas threads, uma thread que vai trabalhar criando a quantidade de monstros, digamos que sempre
// tem que ter 20 mil monstros dentro do mapa no nosso jogo.
// E existe também a thread do jogador, você com o jogador está lá matando os monstros e você precisa que a thread
// que conte esses monstros e adicione esses monstros saiba o que você está fazendo.
// E no final das contas, o pacote de concorrência adiciona uma camada acima da camada básica de threads, mas você
// ter um bom conhecimento do que é sincronismo, o que é lock, o que é wait, notify, notifyAll e assim por diante.
// Você precisa saber muito bem como funcionam as threads para trabalhar nesse nível da concorrência.

// O que iremos fazer é ver por exemplo, imagine que você tem uma classe contador, e você tem duas threads acessando
// esse contador, você tem que ter por exemplo 20 mil, como fariamos?
// Vamos fazer de um jeito que a gente geralmente faz se nós não tivermos que se preocupar com threads.

class Counter{
  private int count;
  // Atributo destinado para trabalhar com concorrências
  private AtomicInteger atomicInteger = new AtomicInteger();

  /*
   * Esse é o primeiro exemplo onde não estamos usando o synchronized e podemos obter um valor diferente do que
   * queremos na nossa lógica de negócio da classe AtomicIntegerTest01.

     void increment(){
       count++;
     }

   * Esse é o segundo exemplo onde estamos usando o synchronized.
   * Mas como foi dito, quando adicionamos o sincronismo, nós perdemos um pouco da performance, por que só podemos ter
   * uma thread acessando aquele método naquele determinado momento e dessa forma você está trabalhando com baixo nível.
   * E na nossa explicação dentro da classe AtomicIntegerTest01, não é isso que queremos.

     synchronized void increment(){
       count++;
     }

  */

  // Forma certa de implementar a lógica de negócio que estamos querendo.
  void increment(){
    count++;
    atomicInteger.incrementAndGet();
  }

  public int getCount() {
    return count;
  }

  // Método getter para pegar o valor de atomicInteger
  public AtomicInteger getAtomicInteger() {
    return atomicInteger;
  }
}

public class AtomicIntegerTest01 {

  public static void main(String[] args) throws InterruptedException {
    // Quando executamos esse código, temos um problema, a contagem é bem diferente do que nós temos.
    // Porque isso acontece?
    // No método increment da classe Counter, o código count++, apesar de parecer apenas uma linha de instrução, na
    // verdade, quando compilamos o código e isso vai para a linguagem de máquina, na verdade podemos ter mais de uma
    // linha ao invés de ser apenas count++.
    // Então geralmente nessa parte do processador que vai fazer essa contagem, você não sabe o que o processador está
    // fazendo, ele pode guardar o valor em uma variavel temporária, depois ele pode verificar se o valor da variavel
    // temporária foi alterado, ou então ele só soma diretamente. Então depende do processador.
    // O que podemos fazer para mudar o código é adicionar synchronized na assinatura do método increment.
    // Mas como foi dito, quando adicionamos o sincronismo, nós perdemos um pouco da performance, por que só podemos ter
    // uma thread acessando aquele método naquele determinado momento e dessa forma você está trabalhando com baixo
    // nível.

    // Então agora iremos trabalhar com o pacote de concorrencia("concurrent") para melhorar o código e iremos
    // adicionar uma variavel na classe Counter chamada AtomicInteger atomicInteger.
    // Essa variavel foi criada dentro do pacote de concorrência justamente para trabalhar em situações onde você
    // precisa fazer contagens de forma atomica.
    // Você não precisa do lock, por que essa variavel utiliza o mecanismo chamado de Compare and Swap. É uma técnica
    // utilizada para fazer o design de algoritmos que trabalham em concorrência.
    // Basicamente ele faz uma comparação e troca os valores baseado se o valor da variavel temporária é o correto ou
    // não. Isso na verdade é mais complicado do que essa explicação.

    // O que precisamos entender como desenvolvedor Java e pelo menos para resolver o código, é que, essa operação no
    // método increment, eu quero contar de forma atomica, ou seja, eu quero ter certeza que esses valores não vão ser
    // alterados. Ele contém os métodos getAndIncrement e incrementAndGet, que basicamente é fazer o count++ ou ++count.
    // Então tanto faz, por que nós não estamos pegando.
    // Então dentro do método increment, ficaria "atomicInteger.incrementAndGet();".
    // Depois, criaremos um getter dentro da classe Counter para pegar o valor da variavel atomicInteger.
    // Então, dessa forma, esse incrementAndGet vai se encarregar, no final das contas, de fazer essa chamada.
    // Como ele vai fazer exatamente? Não importa. Mas ele mesmo vai se comportar do jeito que a gente espera sem
    // utilizar o sincronismo.
    // Então ele não precisa sincronizar, pois a forma que esse algoritmo foi desenvolvido, levando em consideração o
    // "Compare and Swap", vai fazer essa contagem de forma correta.
    // Além do AtomicInteger temos outras variaveis, que são AtomicDouble, AtomicIntegerArray, AtomicLongArray e assim
    // por diante.
    Counter counter = new Counter();


    // Imagine que temos uma thread que vai contar.
    // Precisamos primeiro de um Runnable para a thread.
    Runnable r = () -> {
      for (int i = 0; i < 10_000; i++){
        counter.increment();
      }
    };

    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    // Precisamos iniciar as threads
    t1.start();
    t2.start();
    // Precisamos que a thread main espere esses dois trabalhos serem finalizados, por que eu quero imprimir o count.
    // Então vamos falar "Thread main, se junte ao trabalho de t1. Depois quando acabar, se junte ao trabalho de t2".
    t1.join();
    t2.join();

    // Aqui estamos imprimindo o valor depois de ser incrementado
    // Nesse print, temos um valor que não é concreto.
    System.out.println(counter.getCount()); // Valor não concreto, então pode mudar cada vez que executamos o código.

    // Nesse print, temos um valor mais concreto utilizando uma variavel de concorrência que faz contagens de forma
    // atomica.
    System.out.println(counter.getAtomicInteger()); // Valor concreto 20_000
  }
}
