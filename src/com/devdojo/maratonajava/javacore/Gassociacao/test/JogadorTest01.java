package com.devdojo.maratonajava.javacore.Gassociacao.test;

import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador;

public class JogadorTest01 {
  public static void main(String[] args) {
    // Associação unidirecional um para muitos
    Jogador j1 = new Jogador("Neymar");
    Jogador j2 = new Jogador("Pelé");
    Jogador j3 = new Jogador("Romário");

    Jogador[] jogadores = {j1, j2, j3};

    for(Jogador jogador : jogadores) {
      jogador.imprime();
    }



  }
}
