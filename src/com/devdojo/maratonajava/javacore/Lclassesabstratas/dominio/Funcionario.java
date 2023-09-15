package com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio;

// As classes abstratas foram criadas para serem extendidas
// não pode usar final, ja que ela foi criada para ser uma superclasse
/*
  Quando usamos extends de uma classe abstrata para outra classe abstrata, as dependencias serão passadas para a
  classe que for concreta, ou seja, a classe que estiver definindo as funcionalidades, que nesse caso são:
  Desenvolvedor e Gerente, que são classes que não são abstratas.

  No caso, se sobrescrevermos um método da superclasse abstrata que no caso é a Pessoa, estariamos deixando o método
  concreto e definido, onde não precisaria ser obrigatoriamente criado nas subclasses não abstratas(Desenvolvedor e
  Gerente)
 */

public abstract class Funcionario extends Pessoa {
  protected String nome;
  protected double salario;

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
    calculaBonus();
  }

  @Override
  public void imprime() {
    System.out.println("Imprimindo ...");
  }

  public abstract void calculaBonus();

}
