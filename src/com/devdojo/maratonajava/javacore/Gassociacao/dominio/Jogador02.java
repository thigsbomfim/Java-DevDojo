package com.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Jogador02 {
  // Associação bidirecional
  private String nome;
  private Time02 time;
  public void imprime() {
    System.out.println("Jogador: " + this.nome);
    if(time != null) System.out.println("Time: " + time.getNome());
  }

  public Jogador02(String nome) {
    this.nome = nome;
  }

  public Jogador02(String nome, Time02 time) {
    this.nome = nome;
    this.time = time;
  }

  public Time02 getTime() {
    return time;
  }

  public void setTime(Time02 time) {
    this.time = time;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
