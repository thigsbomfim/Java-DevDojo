package com.devdojo.maratonajava.javacore.Zgenerics.service;

import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
  // representa meu banco de dados com carros disponiveis
  private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

  public Barco buscarBarcoDisponivel(){
    System.out.println("Buscando barco disponível");
    Barco barco = barcosDisponiveis.remove(0);
    System.out.println("Alugando barco: "+ barco);
    System.out.println("Barcos disponíveis para alugar:");
    System.out.println(barcosDisponiveis);
    return barco;
  }

  public void retornarBarcoAlugado(Barco barco){
    System.out.println("Devolvendo barco: "+barco);
    barcosDisponiveis.add(barco);
    System.out.println("Barcos disponíveis para alugar:");
    System.out.println(barcosDisponiveis);
  }
}
