package com.devdojo.maratonajava.javacore.Zgenerics.test;

import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import com.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentavelService;
import com.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
  public static void main(String[] args) {
    // Através do uso de genérics em uma classe, conseguimos customizar nosso código de uma forma, que dependendo do
    // codigo que criarmos, criando uma classe, resolve o problema de 3/4/5 classes

    List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes")));
    List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

    // o construtor do RentalService está pedindo uma lista de objetos do tipo Carro, onde nós definimos no generics
    // o T que está sendo passado no generics da classe RentalService significa que podemos passar o tipo que quisermos
    // dentro do generics, como estamos passando no exemplo abaixo:
    RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
    Carro carro = rentalService.buscarObjetoDisponivel();
    System.out.println(" ______________________________");
    System.out.println("| Usando o carro por um mês... |");
    System.out.println("|______________________________|");
    System.out.println();
    rentalService.retornarObjetoAlugado(carro);

    System.out.println();
    System.out.println();

    // Aqui estamos passando a classe Carro como classe genérica
    RentalService<Barco> rentalService2 = new RentalService<>(barcosDisponiveis);
    Barco barco = rentalService2.buscarObjetoDisponivel();
    System.out.println(" ______________________________");
    System.out.println("| Usando o barco por um mês... |");
    System.out.println("|______________________________|");
    System.out.println();
    rentalService2.retornarObjetoAlugado(barco);
  }
}
