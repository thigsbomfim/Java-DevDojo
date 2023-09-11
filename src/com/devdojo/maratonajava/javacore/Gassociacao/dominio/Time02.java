package com.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Time02 {
  // Associação bidirecional
  private String nome;
  private Jogador02[] jogadores;


  public void imprime() {
    System.out.println("Time: " + this.nome);
    if(jogadores == null) return;
    for (Jogador02 jogador : jogadores) {
      System.out.println("Jogadores: " + jogador.getNome());
    }
  }

  public Time02(String nome) {
    this.nome = nome;
  }

  public Time02(String nome, Jogador02[] jogadores) {
    this.nome = nome;
    this.jogadores = jogadores;
  }

  public Jogador02[] getJogadores() {
    return jogadores;
  }

  public void setJogadores(Jogador02[] jogadores) {
    this.jogadores = jogadores;
  }



  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
