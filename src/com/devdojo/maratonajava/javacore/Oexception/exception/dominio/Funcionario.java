package com.devdojo.maratonajava.javacore.Oexception.exception.dominio;


import java.io.IOException;

public class Funcionario extends Pessoa{
 /*
 * Quando estamos sobrescrevendo um método,
 * não somos obrigados a declarar as mesmas exceções que o método da superclasse.
 * mas também podemos colocar a mesma exceção se quisermos, menos as exceções do tipo checked, a não ser que
 * a superclasse esteja com a 'throws' como exceções do tipo checked.
 *
 * ao tentar adicionar a exceção IOException no 'throws', ela lança um erro, pois na super ela não está
 * usando a classe do tipo checked e que são genéricas e quando tentarmos sobrescrever, irá dar um erro.
 *
 * resumindo: não se pode usar exceções genéricas e do tipo checked na sobrescrita de métodos das subclasses,
 * se a superclasse não tiver passado esse método pelo 'throws', não é possível passar no 'throws' da subclasse.
 *
 * exemplo: nessa classe, vamos sobrescrever o método salvar
 *
 * public void salvar() throws LoginInvalidoException, IOException {}
 *
 * esse código, lançará um erro, pois a superclasse Pessoa não está passando a exceção genérica no 'throws', portanto,
 * não é possível passar no 'throws' no método de uma subclasse, uma exceção genérica e do tipo checked.
*/

  public void salvar() throws LoginInvalidoException {
    System.out.println("Salvando funcionário");
  }
}
