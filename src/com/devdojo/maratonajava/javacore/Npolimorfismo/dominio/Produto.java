package com.devdojo.maratonajava.javacore.Npolimorfismo.dominio;

// o Produto está sendo uma classe abstrata pois não precisa ser instânciada, não podemos criar um produto
// e sim um Computador que é um produto
public abstract class Produto implements Taxavel{
  protected String nome;
  protected double valor;

  public Produto(String nome, double valor) {
    this.nome = nome;
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public double getValor() {
    return valor;
  }
}
