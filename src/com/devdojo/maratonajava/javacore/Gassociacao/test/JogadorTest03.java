package com.devdojo.maratonajava.javacore.Gassociacao.test;

import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador02;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Time02;

public class JogadorTest03 {
  // Associação bidirecional
  public static void main(String[] args) {
    // Criando jogadores
    Jogador02 jogador1 = new Jogador02("Messi");
    Jogador02 jogador3 = new Jogador02("Di Maria");
    Jogador02 jogador2 = new Jogador02("Pelé");
    Jogador02 jogador4 = new Jogador02("Neymar");

    // Criando times
    Time02 time1 = new Time02("Seleção Argentina");
    Time02 time2 = new Time02("Seleção Brasileira");

    // Atribuindo jogadores em respectivos arrays para serem incluidos nos times
    Jogador02[] jogadores1 = {jogador1, jogador3}; // Argentina
    Jogador02[] jogadores2 = {jogador2, jogador4}; // Brasil


    // adicionando na classe Jogador o time que ele joga
    jogador1.setTime(time1); // Adicionando a seleção argentina como time do messi
    jogador3.setTime(time1); // Adicionando a seleção argentina como time do di maria

    // adicionando o array de jogadores na classe time
    time1.setJogadores(jogadores1); // Adicionando jogadores na seleção argentina

    // -----------------------------------------------------------------

    // adicionando na classe Jogador o time que ele joga
    jogador2.setTime(time2); // Adicionando a seleção brasileira como time do pelé
    jogador4.setTime(time2); // Adicionando a seleção brasileira como time do neymar

    // adicionando o array de jogadores na classe time
    time2.setJogadores(jogadores2); // Adicionando jogadores na seleção brasileira


    System.out.println("-----Jogador1-----");
    jogador1.imprime();

    System.out.println();

    System.out.println("-----Jogador2-----");
    jogador2.imprime();

    System.out.println();

    System.out.println("-----Jogador3-----");
    jogador3.imprime();

    System.out.println();

    System.out.println("-----Jogador4-----");
    jogador4.imprime();


    System.out.println();


    System.out.println("-----Time1-----");
    time1.imprime();

    System.out.println();

    System.out.println("-----Time2-----");
    time2.imprime();
  }
}
