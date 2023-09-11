package com.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Pessoa {
  private String nome;
  private int idade;

  public void imprime() {
    System.out.println(this.nome);
    System.out.println(this.idade);
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getIdade() {
    return idade;
  }
}
