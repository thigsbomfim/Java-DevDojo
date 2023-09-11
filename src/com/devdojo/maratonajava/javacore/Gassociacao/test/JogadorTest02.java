package com.devdojo.maratonajava.javacore.Gassociacao.test;

import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Time;

public class JogadorTest02 {
  public static void main(String[] args) {
    // Associação unidirecional um para muitos
    Jogador jogador1 = new Jogador("Pelé");
    Time time = new Time("Seleção Brasileira");

    jogador1.setTime(time);
  }
}

