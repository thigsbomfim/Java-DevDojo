package com.devdojo.maratonajava.javacore.Fmodificadoresestaticos.test;

import com.devdojo.maratonajava.javacore.Fmodificadoresestaticos.dominio.Carro;

public class CarroTest01 {
  public static void main(String[] args) {

    Carro.setVelocidadeLimite(180);

    // Carro c1 = new Carro("BMW", 280);
    // Carro c2 = new Carro("Mercedes", 275);
    // Carro c3 = new Carro("Audi", 290);

//    // Desta forma, estamos dizendo que todas as instâncias(c1,c2,c3) da classe Carro terão essa velocidade
//    // independente de existir ou não uma instância, a linha 13 irá funcionar
//    System.out.println(Carro.velocidadeLimite);
//    Carro.velocidadeLimite = 180;
//    System.out.println(Carro.velocidadeLimite);

    // c1.imprime();
    // c2.imprime();
    // c3.imprime();
  }
}
