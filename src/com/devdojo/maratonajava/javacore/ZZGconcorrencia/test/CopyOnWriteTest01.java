package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;
// Como sabemos, existe uma opção para criarmos coleções onde elas são próprias para concorrências:
// Utilizando o método "unmodifiableCollection" ou "synchronizedCollection".
//    Collections.unmodifiableCollection();
//    Collections.synchronizedCollection();
// Porém, existe uma outra que é utilizando a coleção CopyOnWriteArrayList.
// É importante entender o conceito de imutabilidade.
// No java, geralmente quando estamos trabalhando com classes que tem acesso por multiplas threads, nós, de
// preferência, tentamos trabalhar com objetos imutáveis.
// Objeto imutável é, se você tiver uma classe, se você estiver trabalhando com imutabilidade, a classe é final.
// No fim, ninguém pode usar o extends e ninguém pode alterar os atributos sem a permissão.
// A primeira parte para criar uma classe imutável é fazer que ela seja final, como estamos fazendo abaixo:
// final class Anime{}
// Porém, para uma classe imutável, você tem que remover toda e qualquer forma de acesso para trocar os atributos
/*
  Digamos que nós temos a seguinte classe:

  final class Anime{
   private String name;

   public void setAnime(String name){
     this.name = name;
   }

   public String getAnime(){
     return this.name;
   }
  }

  Se nós criarmos um "getter" e um "setter" dentro da classe, essa classe passa a não ser mais uma classe imutável,
  porque uma vez criado o objeto, você pode ir lá e "setar" o nome.

  Então digamos que você tenha 10 threads, você vai alterar um mesmo objeto.

  Imutabilidade é: uma vez que o objeto foi criado, você não pode mais alterar nada daquele objeto.
  Se você tem um objeto Anime, você tem um anime que é imutável e você quer trocar o nome desse Anime, não é possível.
  Você terá que criar um novo objeto com um novo nome para adicionar um Anime com um nome diferente.

  Então o certo, quando criarmos uma classe imutável, é dessa forma:
  Criamos um construtor e criamos um "getter" caso queira pegar o nome:

  final class Anime{
   private String name;

   public Anime(String name){
     this.name = name;
   }

   public getName(){
     return this.name;
   }
  }

  Então dessa forma você tem uma classe que é final, o atributo que nós temos é final, se você tivesse 10 atributos,
  os 10 atributos teriam que ser finais e você só da acesso a leitura.
  A única forma de você trocar esses objetos é você instânciando/criando um novo objeto, isso é um objeto imutável.
  Se você tiver várias threads trabalhando, as threads teram que criar o próprio objeto, ai tecnicamente o seu objeto
  vão ficar, se você estiver trabalhando com outras threads trabalhando ao mesmo tempo, eles irão ficar seguros.
  Mas nosso foco nesse arquivo é o CopyOnWriteArrayList.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest01 {
  public static void main(String[] args) {
    // CopyOnWrite é básicamente uma lista "imutável".
    // Temos a coleção "CopyOnWriteArrayList" e "CopyOnWriteArraySet", que são basicamente a mesma coisa, a diferença
    // é que um é uma lista e outro um set.
    // A ideia dessa classe é justamentevocê trabalhar com uma lista imutável, mas a lista em si é imutável.
    // Vamos ao seguinte código:
    List<Integer> list = new CopyOnWriteArrayList<>();
//    List<Integer> list2 = new ArrayList<>();
    // Imagine que você tem uma lista de inteiros e adicione o valor [1];
    // O que acontece se você adicionar [2]?
    // Essa classe irá copiar o valor, ou seja, na lista original, o valor ainda está intacto, o valor ainda é [1].
    // Então ele irá criar uma nova lista com os valores [1,2].
    // Se quisermos adicionar o valor [3], ele irá criar uma nova lista/um novo objeto com os valores [1,2,3].
    // Você quer remover o valor [3]? Então ele vai criar uma nova lista removendo o valor [3] que ficaria [1,2].
    // Então não é a mesma, você estará sempre criando uma nova lista.
    // A performance dessa classe se você tiver que ficar inserindo e tirando toda hora vai dar problema, porque vai ter
    // um certo impacto na memória.
    // E ela não é totalmente thread safe, por que estamos trabalhando com inteiros, mas se nós tivessemos um Anime,
    // como no exemplo acima dessa classe, se tivessemos dessa forma [1,anime,3] e esse anime não fosse imutável.
    // O que iria acontecer? Você poderia trocar o valor de memória.
    // Então o nome do anime, você poderia chegar lá, trocar o nome, muitas threads acessando e ja ferrou toda a sua
    // aplicação.
    // Então a lista em si é imutável, você adiciona e remove "List<Anime>", mas temos que tomar cuidado quando estamos
    // atributos que sejam objetos dentro dessa lista, temos que ter certeza de que eles também são imutáveis.

    // Para exemplificar, vamos adicionar por exemplo 2 mil valores nessa lista.
    for(int i = 0; i < 2000; i++){
      list.add(i);
    }

    // Vamos criar dois Runnable para as threads:

    // Primeiro Runnable para as threads:
    // Temos esse Runnable que irá iterar e depois colocar a thread para dormir e por fim imprimir os valores, nesse
    // caso os 2mil.
    Runnable runnableIterator = () -> {
      // Por que iremos utilizar iterator? porque ele mantém uma cópia pro valor original, no momento da criação daquele
      // iterator.
      // Adicionamos um iterator e temos um iterator do tipo Integer.
      Iterator<Integer> iterator = list.iterator();
      try {
        // Vamos dar dois segundos para a thread dormir.
        // Depois que ela dormir, quero imprimir esses valores.
        TimeUnit.SECONDS.sleep(2);
        // Imprimindo de uma forma diferente sem utilizar o while.
        iterator.forEachRemaining(System.out::println);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };

    // Segundo Runnable para as threads:
    Runnable runnableRemover = () -> {
      // Esse runnableRemover vai ser simples.
      // Vamos criar um for de 1 até 500;
      // Dar um print "ThreadTal remove o valor 'indice'";
      for (int i = 0; i < 500; i++) {
        System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
      }
    };

    // Vamos startar duas threads do runnableIterator;
    // Porém, quando startamos essas duas threads, elas iram dormir por 2 segundos e quando elas estão dormindo, vamos
    // startar também o runnableRemover que irá remover 500 posições dessa lista de 2000.
    // Então estamos criando uma lista com 2mil posições;
    // Estamos startando 2 threads com runnableIterator que é para imprimir essas 2mil posições;
    // Mas, antes delas acordarem, a thread runnableRemover irá remover 500 valores.
    new Thread(runnableIterator).start();
    new Thread(runnableIterator).start();
    new Thread(runnableRemover).start();
    // Podemos ver que ele removeu 500 valores mas a thread que está com o "runnableIterator" ainda tem acesso ao objeto
    // antigo, antes de serem removido os valores na thread que está com o "runnableRemover".
    // Se mudarmos a objeto que instânciamos acima para "ArrayList<>()" ao invés de "CopyOnWriteArrayList<>()" o
    // comportamento será o mesmo.
    // Então, ele mantém uma cópia no momento da criação, mesmo uma outra thread removendo os 500, ainda temos os 2mil
    // valores que não foram removidos da thread que itera.
  }
}
