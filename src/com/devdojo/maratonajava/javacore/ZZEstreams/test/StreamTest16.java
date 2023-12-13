package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * DEMONSTRAÇÃO DA UTILIZAÇÃO DO PARALLEL STREAM
 * */

// DEVEMOS TOMAR MUITO CUIDADO AO UTILIZAR STREAMS DE PARALELOS, NÃO É SEMPRE QUE TEREMOS BOA PERFORMANCE, PRECISAMOS
// PENSAR NO TIPO DE PROBLEMA QUE ESTAMOS UTILIZANDO

public class StreamTest16 {
  public static void main(String[] args) {
    // aqui teremos uma ideia de quantas Threads a Parallels Streams irá utilizar, por padrão esse valor é 8, podemos
    // aumentar, mas aumentar não significa que a nossa performance vai aumentar
    System.out.println(Runtime.getRuntime().availableProcessors());

    // digamos que temos um numero bem grande
    // nosso for demora aproximadamente 10ms para realizar a soma de 10 milhões
    // o for para esse tipo de coisa, tem uma das melhores performances em relação a todos os tipos de iterações que
    // podemos fazer, ele foi desenvolvido para trabalhar dessa forma, basicamente trabalha no baixo nivel da máquina.
    long num = 100_000_000;
    sumFor(num);
    System.out.println("----------------");
    // podemos ver que usando streamIterate, levamos aproximadamente 220ms, o stream nesse caso, não é uma boa saida
    sumStreamIterate(num);

    System.out.println("----------------");

    // como podemos ver, pensamos que ao adicionar mais trabalhadores a performance seria bem melhor, mas como vimos
    // não é o caso, demorou mais tempo ainda de forma paralela, essa forma não é ideal para trabalhar de forma paralela
    // pois estamos trabalhando iterando de 1 por 1, então fica dificil para as threads saberem tipo, apartir do numero
    // tal o trabalhador 1 faz a conta, a partir de numero tal o trabalhador 2 faz outra conta
    // não tem como saber como as threads irão trabalhar pois justamente eles não sabem o tamanho, então se ja tivesse
    // o tamanho predefinido, nós saberiamos. mas nesse caso estamos iterando de 1 por 1, então n tem como separar o
    // trabalho
    sumParallelStreamIterate(num);

    System.out.println("----------------");

    // como podemos ver, o valor ja caiu, o for ainda continua sendo mais rápido
    sumLongStreamIterate(num);

    System.out.println("----------------");

    sumParallelLongStreamIterate(num);
  }

  private static void sumFor(long num){
    System.out.println("Sum for");
    long result = 0;
    // quanto tempo leva para processar esse código
    long init = System.currentTimeMillis();
    for(long i=1; i<=num; i++){
      result+=i;
    }
    long end = System.currentTimeMillis();
    System.out.println(result + " " + (end - init) + "ms");
  }

  private static void sumStreamIterate(long num){
    System.out.println("Sum StreamIterate");
    // quanto tempo leva para processar esse código
    long init = System.currentTimeMillis();
    long result = Stream.iterate(1L, i -> i+1).limit(num).reduce(0L, Long::sum);
    long end = System.currentTimeMillis();
    System.out.println(result + " " + (end - init) + "ms");
  }


  // como acontece a execução do Parallel em multiplas threads?
  // vamos supor que temos uma lista:
  // [1,2,3,4,5,6,7,8,9,0]
  // quando estamos trabalhando com uma thread só, que é o que geralmente acontece, com um trabalhador só, que é o que
  // geralmente acontece quando nós executamos nossos programas, que vem acontecendo durante o curso
  // é que 1 trabalhador só está fazendo isso, ele vai fazer a soma dos valores de toda a lista individualmente, uma
  // thread só vai fazer essa soma, mas quando estamos trabalhando em paralelo, nesse caso temos 8, onde observamos
  // nesse código: System.out.println(Runtime.getRuntime().availableProcessors());
  // o que ele vai fazer é:
  // o trabalhador 1 vai fazer a soma de 1 até 5
  // 1 - 1-5
  // o trabalhador 2 vai fazer a soma de 6 até 0
  // 2 - 6-0
  // na vdd, não sabemos como irá funcionar mas depende muito do que chamamos escalaminador vai agendar isso, não
  // sabemos, não tem como controlar, mas temos varios trabalhadores, trabalhando nesse mesmo bloco de informações
  private static void sumParallelStreamIterate(long num){
    System.out.println("Sum sumParallelStreamIterate");
    // quanto tempo leva para processar esse código
    long init = System.currentTimeMillis();
    // para usar o parallel stream, basicamente mudamos pouca coisa do código acima, só chamamos apenas o parallel em
    // em qualquer lugar, depois do limit, antes, a ordem tanto faz.
    // o Parallel é como se fosse uma flag, que estamos colocando dentro do stream e dizendo que agora ele irá executar
    // em multiplas threads
    long result = Stream.iterate(1L, i -> i+1).parallel().limit(num).reduce(0L, Long::sum);
    long end = System.currentTimeMillis();
    System.out.println(result + " " + (end - init) + "ms");
  }

  private static void sumLongStreamIterate(long num){
    System.out.println("Sum sumLongStreamIterate");
    // quanto tempo leva para processar esse código
    long init = System.currentTimeMillis();
    // aqui usaremos o LongStream, ele basicamente ja irá dizer para o stream os valores que nós temos, estamos
    // dizendo de 1 a 10 milhões
    // aqui, como podemos ver, não estamos utilizando a forma paralela e sim da forma normal utilizando LongStream
    long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
    long end = System.currentTimeMillis();
    System.out.println(result + " " + (end - init) + "ms");
  }

  private static void sumParallelLongStreamIterate(long num){
    System.out.println("Sum sumParallelLongStreamIterate");
    // quanto tempo leva para processar esse código
    long init = System.currentTimeMillis();
    // aqui usaremos o LongStream, ele basicamente ja irá dizer para o stream os valores que nós temos, estamos
    // dizendo de 1 a 10 milhões
    // aqui, como podemos ver, estamos utilizando a forma paralela junto com o LongStream
    long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
    long end = System.currentTimeMillis();
    System.out.println(result + " " + (end - init) + "ms");
  }
}
