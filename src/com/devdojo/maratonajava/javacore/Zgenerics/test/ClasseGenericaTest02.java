package com.devdojo.maratonajava.javacore.Zgenerics.test;

import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import com.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentavelService;
import com.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentavelService;

public class ClasseGenericaTest02 {
  public static void main(String[] args) {
    BarcoRentavelService barcoRentavelService = new BarcoRentavelService();

    Barco barco = barcoRentavelService.buscarBarcoDisponivel();

    System.out.println("Usando o barco por um mês...");

    barcoRentavelService.retornarBarcoAlugado(barco);
  }
}
