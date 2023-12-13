package com.devdojo.maratonajava.javacore.Zgenerics.service;

import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
  // representa meu banco de dados com carros disponiveis
  private List<Carro> carrosDiponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));

  public Carro buscarCarroDisponivel(){
    System.out.println("Buscando carro disponível");
    Carro carro = carrosDiponiveis.remove(0);
    System.out.println("Alugando carro: "+ carro);
    System.out.println("Carros disponíveis para alugar:");
    System.out.println(carrosDiponiveis);
    return carro;
  }

  public void retornarCarroAlugado(Carro carro){
    System.out.println("Devolvendo carro: "+carro);
    carrosDiponiveis.add(carro);
    System.out.println("Carros disponíveis para alugar:");
    System.out.println(carrosDiponiveis);
  }
}
