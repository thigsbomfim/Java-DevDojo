package com.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.List;

public class WildcardTest02{

  public static void main(String[] args) {
    // vamos trabalhar de uma forma diferente do WildcardTest01, vamos trabalhar com listas
    // vamos supor que tenhamos uma lista de cachorros:
    List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
    List<Gato> gatos = List.of(new Gato(), new Gato());
    // aqui temos um erro de compilação, uma vez que o código é compilado, o java não sabe o tipo de lista que estamos
    // passando, lembrando que o nome desse termo é Type Erasure, e por causa do type erasure, o java não sabe por
    // exemplo, depois que compilamos, que o que estamos passando é uma lista de cachorros, que uma lista de cachorros
    // pode ser referenciada por uma lista de animais, é a mesma coisa se tentassemos passar gatos, ele não funciona.
    // mas ainda conseguimos adicionar dentro dessa lista de animais do método printConsulta, objetos independentes, que
    // seja um filho de um animal
    // diferente de quando usamos Array no WildcardTest01, com listas ocorre um erro de compilação.
//    printConsulta(cachorros);
//    printConsulta(gatos);
  }

  // vamos supor que estamos criando esse método, mas quando estamos trabalhando com listas, devemos passar o tipo dessa
  // lista, quando estamos tentando passar através de parametros, o objeto precisa passar exatamente o que foi definido
  // nessa sintaxe, onde Animal é uma classe genérica, e o que o método recebe como parâmetro é um classe extendida, da
  // classe Animal, como a classe Cachorro, é por isso que temos o Wildcard para esse tipo de situação.
  private static void printConsulta(List<Animal> animais) {
    for (Animal animal : animais) {
      animal.consulta();
    }
    // podemos adicionar um cachorro, por que exatamente o que fizemos com arrays, é como se tivessemos um animal,
    // criando uma referência com o objeto do tipo cachorro, dessa forma:
//    Animal a = new Cachorro();
    animais.add(new Cachorro());
  }
}


