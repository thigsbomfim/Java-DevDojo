package com.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Time {
  // Associação unidirecional um para muitos
  private String nome;

  public Time(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
