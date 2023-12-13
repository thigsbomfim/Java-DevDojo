package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

/*
No pacote ZZFthreads, nós estavamos trabalhando com threads da forma mais baixa possível.
Fazendo o lock das threads sem utilizar synchronized, podemos ver isso na classe "Members" do pacote dominio dessa mesmo
pacote acima.
Vimos também uma parte de concorrência de coleções nesse mesmo pacote.

Mas no final das contas, tudo que estavamos fazendo com as threads eram bem baixo nível.
Se voltarmos na classe "ThreadExample" que está no pacote "test" que faz parte do pacote ZZFthreads, podemos ver que nós
estavamos criando threads da forma mais baixa possível.

Tem um pequeno problema em trabalhar com baixo nível dessa forma.
Imagine que você está criando uma thread para trabalhar em uma requisição de usuário;
Imagine que você criou uma thread e todas as vezes que o usuário entrar com o nome dele, você quer startar essa thread
para trabalhar de forma concorrente.
Mas o que acontece se, por exemplo, você tiver mil usuários?

Você está criando mil threads, e no final das contas você pode acabar tendo um sério problema no seu sistema operacional
porque quando você cria uma thread, você está criando um objeto. E quando você cria um objeto, você precisa de memória,
precisa de processamento e precisa levar em consideração tudo aquilo que envolve a criação de um objeto.

Pensando nesse problema, o pessoal do java criou o "Executors".
Ele tem um único objetivo, que é desacoplar a submissão de tarefas da execução.

Então digamos que você queira trabalhar com números fixos de threads, você quer trabalhar com 8 threads, independente da
quantidade de tarefas que você tem no seu código, você quer por exemplo, trabalhar sempre com 8/4 threads ou você quer
por exemplo, que cresça ilimitadamente o numero de threads.
Esse "Executors" vai tomar conta disso para você.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Vamos criar uma classe para explicar um pouco mais o assunto acima.
class Printer implements Runnable{
  private final int num;

  public Printer(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    System.out.printf("%s iniciou: %d%n", Thread.currentThread().getName(), num);

    // Colocando a thread para dormir por 3 segundos a partir do ENUM TimeUnit
    try {
      TimeUnit.SECONDS.sleep(3);
      System.out.printf("%s finalizou%n", Thread.currentThread().getName());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

public class ExecutorsTest01 {
  public static void main(String[] args) {
    // Temos varios métodos que vão criar outros pools de threads.
    // Vamos começar com o método newFixedThreadPool, que irá criar um pool de threads fixo.
    // Geralmente quando você está trabalhando, você tem na verdade um processador, o processador tem um número de
    // núcleos, dependendo do processador que você está utilizando o numero de threads é o dobro do número de núcleos.
    // Para você ver por exemplo quantos processadores, que no caso são 8, na verdade temos simulam 4 núcleos + 4.
    // Tecnicamente, eu tenho possibilidade de trabalhar com 8 threads.
    // É como se estivessem 8 cabeças pensando em paralelo.
    // Se colocarmos por exemplo, 15, na verdade temos 8 meio que real e o resto vão ser virtuais.
//    System.out.println(Runtime.getRuntime().availableProcessors());

    // Queremos começar com 4 threads, esse Executors retorna um ExecutorService.
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    // Podemos passar tambépm o código onde avaliamos quantos processadores contém no nosso pc, então no caso seriam
    // 8 threads trabalhando.
//    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // Se não quisessemos criar com um número fixo de 8 como estamos utilizando acima, seria utilizando esse método.
    // Esse método só aceita uma thread.
    // É bom para quando precisarmos criar uma thread e não se preocuparmos em dar thread.start().
//    Executors.newSingleThreadExecutor();

    // Outra opção seria utilizar o métodonewCachedThreadPool, ele vai criar threads conforme você vai precisando,
    // mas vai reutilizar as threads quando estiverem disponíveis.
    // Por exemplo, temos 8 threads. De repente precisamos só de 5 threads, depois precisamos de mais 2.
    // Então não vamos precisar ficar criando threads, por que enquanto tiver dentro desse oito, o "Executors" vai
    // utilizar e, depois de 60 segundos, as threads vão ser terminadas, vão ser removidas do cache.
//    Executors.newCachedThreadPool();

    // Falamos que ele desacopla a submissão de tarefas com a execução, então como isso funciona?
    // Funciona da seguinte forma:
    // Antes criavamos o Runnable e davamos start na thread, mas digamos que não queiramos fazer dessa forma, queremos
    // ter um pouco mais de flexibilidade quando deveria startar, porque quando damos start ja era, não tem mais o que
    // fazer.
    // Agora estamos dedicando essa responsabilidade para o Executors.
    // Estamos passando o Runnable como parâmetro do método execute, está como faziamos dessa forma, mas agora estamos
    // deixando a resposabilidade de start para o Executors.
    // Antes: new Thread(new Printer(1)).start();
    // Abaixo, o Executors que vai ser responsável por startar nossas threads.
    executorService.execute(new Printer(1));
    executorService.execute(new Printer(2));
    executorService.execute(new Printer(3));
    executorService.execute(new Printer(4));
    executorService.execute(new Printer(5));
    executorService.execute(new Printer(6));
    // Esse 4 passado como argumento do método "newFixedThreadPool()", quer dizer que estamos querendo que 4 threads
    // trabalhem, então serão 4 threads trabalhando, quando uma das 4 threads terminarem a sua primeira tarefa, ela
    // irá pegar a próxima tarefa.
    // Esse código que contém acima e também abaixo:
//    executorService.execute(new Printer(4));
    // O valor Printer, são como tarefas, onde o total de tarefas são 6.
    // Então quando uma das threads, onde determinamos que são 4 no Executors, quando uma dessas threads acabarem de
    // executar uma dessas 4 tarefas, ela irá pegar a próxima tarefa que seria do Printer 5 em diante.
    // O numero de threads sempre serão 4.
    // Isso é bom por que não precisamos nos preocupar, se estamos trabalhando com algo escalável, digamos que são
    // a quantidade de usuários que podem acessar o sistema, você ta com um número fixo de threads, não irá mudar.

    // O que fazemos para parar o executorsService? t
    // Temos o método shutdown, quando utilizamos ele, no momento que ele executar, ele simplesmente vai desligar.
    executorService.shutdown();
    // Então por exemplo, podemos imprimir alguma coisa dizendo que o programa foi finalizado.
    // O que vai acontecer?
    // Temos a thread main, a thread main vai estar com todos esses códigos acima, teremos outras threads sendo
    // executadas, mas a main vai falar "executorService agora você pode desligar".
    // O problema é que essas threads não estão em execução, então veremos o print abaixo antes das threads finalizarem.
    // Onde na verdade, o programa não foi finalizado, só demos um sinal para desligar e quando todas as threads acabam
    // de serem executadas, que o programa desliga.
//    System.out.println("Programa finalizado.");
    // Poderiamos fazer um while para verificar se as threads terminaram de ser executadas utilizando o método
    // isTerminated().
    // Aqui estamos dizendo que enquanto o programa não for terminado, queremos pegar o momento em que ele não terminou,
    // por isso estamos utilizando o "!" na frente, enquanto o executorService não terminou o código, segure o código e
    // quando terminar, libere o código que logo posteriormente veremos o print "Programa finalizado.".
    // É meio que uma gambiarra para utilizar o isTerminated, mas é muito feio.
    while(!executorService.isTerminated()){}

    System.out.println("Programa finalizado.");
  }
}
