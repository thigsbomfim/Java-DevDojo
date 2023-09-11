package com.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Professor {
  // Associação unidirecional muitos para um
  private String nome;

  public Professor(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
