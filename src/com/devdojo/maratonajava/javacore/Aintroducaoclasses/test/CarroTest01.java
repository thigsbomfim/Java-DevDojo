package com.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import com.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest01 {
  public static void main(String[] args) {
    Carro car1 = new Carro();
    Carro car2 = new Carro();

    car1.nome = "Ferrari";
    car1.modelo = "Esportivo";
    car1.ano = 2023;

    car2.nome = "Lamborghini";
    car2.modelo = "Esportivo";
    car2.ano = 2023;

    System.out.println("Carro 1");
    System.out.println(car1.nome);
    System.out.println(car1.modelo);
    System.out.println(car1.ano);

    System.out.println("\nCarro 2");
    System.out.println(car2.nome);
    System.out.println(car2.modelo);
    System.out.println(car2.ano);
  }

}