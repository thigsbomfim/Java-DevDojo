package com.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// vamos imaginar que nós temos uma classe chamada Animal
class Animal {
  // temos o método
  // imagina que queremos mudar o comportamento do método walking, digamos que queremos outro comportamento diferente
  // desse abaixo.
  // a forma como fariamos isso, seria criar uma subclasse de animal e sobrescrever o método.
  // digamos que queremos fazer a troca desse método, do comportamento, mas só por um determinado momento do código
  // onde não precisamos criar outra classe e poluir o código como fizemos com a classe Cachorro abaixo,
  // sendo que não iremos mais reutiliza-la.
  public void walk(){
    System.out.println("Animal walking");
  }
}

// class Cachorro extends Animal {

//  @Override
//  public void walk() {
//    System.out.println("Cachorro walking");
//  }
//}

public class AnonymousClassesTest01 {
  // classes anonimas são classes que vão existir brevemente por um determinado periodo de tempo no codigo e que não ser
  // reutilizada em nenhum outro lugar
  public static void main(String[] args) {
    // nós queremos mudar o comportamento do método walk mas só nesse pedaço de código
    // ao invés de só instânciarmos o animal, utilizaremos "{}" depois de "()", e nesse exato momento, temos uma classe
    // anonima, parece que estamos criando um objeto do tipo animal, mas na vdd estamos criando uma subclasse de Animal
    // e como sabemos que é uma subclasse? sabemos pq dentro desse bloco é possivel sobrescrever o método walk, esse
    // bloco tem acesso ao método walk
    // estamos criando uma subclasse anonima e estamos sobrescrevendo o método walk
    Animal animal = new Animal(){
      @Override
      public void walk() {
        System.out.println("Walking in the shadows");
//        jump();
      }

      // se criarmos um novo método dentro dessa subclasse, não é possível chama-lo fora, igual estamos fazendo com
      // o método walk.
      // poderiamos chamar dentro do método walk, pois temos acesso a ele, mas fora não tem como
      public void jump(){

      }
    };

    // quando executarmos esse código, veremos "Walking in the shadows" e não "Animal walking", pois nós sobrescrevemos
    // o método logo quando instânciamos a sua classe
    animal.walk();
//    animal.jump(); // não é possível, pois é uma classe anonima e não temos acesso a ela
  }
}
