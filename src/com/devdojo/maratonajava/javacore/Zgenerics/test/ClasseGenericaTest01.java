package com.devdojo.maratonajava.javacore.Zgenerics.test;

import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import com.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentavelService;
import com.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentavelService;

public class ClasseGenericaTest01 {
  public static void main(String[] args) {
    CarroRentavelService carroRentavelService = new CarroRentavelService();
    BarcoRentavelService barcoRentavelService = new BarcoRentavelService();

    Carro carro = carroRentavelService.buscarCarroDisponivel();
    Barco barco = barcoRentavelService.buscarBarcoDisponivel();

    System.out.println("Usando o carro por um mês...");
    System.out.println("Usando o barco por um mês...");

    carroRentavelService.retornarCarroAlugado(carro);
    barcoRentavelService.retornarBarcoAlugado(barco);
  }
}
