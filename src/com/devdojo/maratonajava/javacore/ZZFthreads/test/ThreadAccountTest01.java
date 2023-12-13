package com.devdojo.maratonajava.javacore.ZZFthreads.test;

import com.devdojo.maratonajava.javacore.ZZFthreads.dominio.Account;

/**
 * EXPLICAÇÃO SOBRE THREAD NO ARQUIVO ThreadTest01 EM DIANTE.
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE SINCRONISMO DE THREAD
 * */


// aqui estamos implementando a interface Runnable para criarmos uma thread.
// temos que sobrescrever o método run.
public class ThreadAccountTest01 implements Runnable{
  private final Account account = new Account();


  public static void main(String[] args) {

    // o que está acontecendo aqui? temos esse objeto abaixo
    // esse objeto contém uma conta como atributo "account", ou seja, na memoria temos 1 objeto só.
    /*
     * Temos apenas um objeto, esse objeto é a minha conta, a minha conta tem um valor que é o balance, que o valor é
     * 50. Estamos falando que vamos ter a thread t1 e a thread t2 acessando o mesmo objeto, ou seja, vão estar fazendo
     * operações matematicas no mesmo objeto.
     *    ______
     *   |      |                    Account
     *   |  T1  |--------|            ______
     *   |______|        |           |      |
     *    ______         |---------->|  50  |
     *   |      |        |           |______|
     *   |  T2  |--------|
     *   |______|
     *
     * Mas esse código contém um sério problema, pois esse é o problema da concorrencia, temos duas threads acessando
     * o mesmo objeto, estamos falando:
     * "Bell Cranel está indo sacar o dinheiro"
     * "Hestia está indo sacar o dinheiro"
     * "Bell Cranel completou o saque, o valor atual da conta: 40"
     * "Hestia completou o saque, o valor atual da conta: 30"
     *
     * E assim por diante, até zerar o valor.
     * Vamos ao problema:
     * Quando a thread t2 "Bell Cranel" vai sacar, ele entra no if "account.getBalance() >= amount" e para de executar
     * na primeira linha do if, sem ao menos ter sacado o valor e ainda não é alterado o valor pós o saque.
     * Dai a thread t1 "Hestia" é executada logo em seguida e ve que o saldo da conta ainda é 10 e ainda é possivel
     * sacar outro valor. A thread t1 "Hestia" entra no if e saca o valor e imprime o valor do saque.
     * Assim que a thread t1 "Hestia" termina de sacar e a thread t2 "Bell Cranel" executa novamente de onde parou,
     * o valor atual agora da conta é 0, pois ja foi solicitado pela thread t1 "Hestia" e é ai que está o problema.
     *
     * Para não ocorrer esse problema, basicamente temos que falar: "Eu preciso que esse código do método withdrawal
     * seja executado de forma atômica" ou seja, a thread que começar a executar esse método withdrawal,
     * tem que terminar esse método withdrawal, uma outra thread não pode entrar no mesmo momento, isso significa que
     * temos que dar um "lock".
     * Todos os objetos tem um "lock".
     * "Lock" é como se fosse uma chave que temos no objeto, se alguma thread pegar esse "lock", outra thread não vai
     * conseguir acessar esse objeto ao mesmo tempo.
     * Então quando colocamos o modificador synchronized no método withdrawal, estamos falando agora que esse método é
     * um método sincronizado, ou seja, não vai existir paralelismo, por que duas threads não vão poder acessar esse
     * método ao mesmo tempo.

     * Quem tem o "lock"? Onde está o "lock"?
     * esse método withdrawal está dentro da classe ThreadAccountTest01, significa que o "lock" é para essa classe, para
     * esse objeto que instânciamos da classe ThreadAccountTest01.
     * A ordem de qual thread vai executar primeiro no método não é garantida. Algo que é garantido é que a thread que
     * começar a executar esse método, vai terminar de executar esse método, nenhuma outra thread vai poder entrar nesse
     * método enquanto alguma thread estiver executando.
     * Mesmo se utilizarmos um sleep, para colocar a thread para dormir dentro do método, podemos ver que mesmo assim
     * a thread que está executando não solta o "lock", ou seja, se a thread t1 "Hestia" ou a thread t2 "Bell Cranel"
     * entrar, por mais que esteja dormindo, esse método está bloqueado, então a thread que não executou o método
     * vai tentar executar o método, e ai vai acontecer "opa, não consigo executar esse método por que tem alguma thread
     * segurando o "lock" nesse objeto".
     * Quando a thread que executou o método termina de executar, o "lock" é liberado. E ai quem vai pegar ou não esse
     * "lock", é completamente por vontade do "Scheduler", não tem como saber.
     *
     * */
    ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
    Thread t1 = new Thread(threadAccountTest01, "Hestia");
    Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");
    t1.start();
    t2.start();
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      // aqui estamos sacando de 10 em 10
      // significa que quando executarmos esse laço, ele vai executar 5 vezes, temos 50 na conta, ele vai sacar 50 e
      // se executarmos com 2 threads, uma delas não pode sacar, vai ter tipo que uma concorrencia
      withdrawal(10);
      // por via das duvidas, vamos por um if
      // se o valor da conta for menor que 0
      if(account.getBalance() < 0) {
        System.out.println("FODEO");
      }
    }
  }


  // método para realizar o saque da conta
  // O synchronized pode ser utilizado no proprio método ou podemos criar um bloco de código dentro do próprio método
  // onde passamos como paramêtro o que queremos sincronizar, mas devemos tomar cuidado ao utilizar desta forma pois o
  // parâmetro que estamos passando precisar ter o modificador final, por que se não criarmos como final, significa que
  // depois em algum momento nós podemos pegar o account em algum momento e reatribuir o atributo, desta forma:
  // account = new Account();
  // Ai temos um novo objeto em memoria, e estamos dando um "lock" em quem?

  // Outra coisa, também podemos sincronizar métodos estáticos.
  // esse synchronized, estamos sincronizando com o método estático pertence a classe, estamos sincronizando
  // praticamente a classe.
  // O que poderiamos fazer, além de utilizar o synchronized dessa forma:
//  private static synchronized void print() {
  // é fazer assim:
  // mas não vemos muito acontecendo dessa forma.
//  private static void print() {
//    synchronized (ThreadAccountTest01.class){
//
//    }
//  }

  private void withdrawal(int amount) {
    // criando o synchronized dentro de um bloco, dessa forma, qualquer thread poderá entrar dentro desse método mas
    // apenas uma poderá entrar dentro do bloco de código synchronized e executar uma por vez, a outra thread só poderá
    // executar o bloco de código quando a thread que está executando terminar de executar.
    // Esse bloco só pode ser executado uma thread por vez.
    // Estamos dando um "lock" no objeto account, ou seja, quando uma thread vai entrar nesse bloco, ela pergunta:
    // "Opa, tem alguma thread executando esse objeto?" se estiver uma thread, ai vai falar: "Opa, o "lock" ta ocupado"
    // Ai a thread vai ficar no estado "Runnable" ou se tiver algum outro código, vai ficar no estado "Blocked".
    System.out.println(getThreadName() + " #### fora do synchronized");
    System.out.println();
    synchronized (account){
      // se o valor da minha conta for maior do que o valor, ou seja, se tivermos 50 na minha conta, não podemos fazer
      // o saque de 100, não podemos deixar a conta ficar negativa.
      // Então se o valor da minha conta for maior que o valor do saque, podemos sacar
      System.out.println(getThreadName() + " **** dentro do synchronized");
      System.out.println();
      if(account.getBalance() >= amount) {
        System.out.println(getThreadName() + " está indo sacar dinheiro");
        account.withdrawal(amount);
        System.out.println(getThreadName() + " completou o saque, o valor atual da conta: " + account.getBalance());
      } else {
        System.out.println("Sem dinheiro para " + getThreadName() +" efetuar o saque "+account.getBalance());
      }
    }

//    if(account.getBalance() >= amount) {
//      System.out.println(getThreadName() + " está indo sacar dinheiro");
//      account.withdrawal(amount);
//      System.out.println(getThreadName() + " completou o saque, o valor atual da conta: " + account.getBalance());
//    } else {
//      System.out.println("Sem dinheiro para " + getThreadName() +" efetuar o saque "+account.getBalance());
//    }
  }

  // método para pegar o nome da thread
  private static String getThreadName() {
    return Thread.currentThread().getName();
  }


}
