package com.devdojo.maratonajava.javacore.Jmodificadorfinal.test;

import com.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio.Carro;
import com.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio.Comprador;
import com.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio.Ferrari;

public class CarroTest01 {
  public static void main(String[] args) {
    Carro carro = new Carro();

    // o objeto COMPRADOR da classe carro não pode ser alterado, pois é uma constante
    // carro.COMPRADOR = comprador2;
    System.out.println(carro.COMPRADOR);// null
    // porém, é possível alterar os atributos do objeto
    carro.COMPRADOR.setNome("Kuririn");
    System.out.println(carro.COMPRADOR);

    // Carro.VELOCIDADE_LIMITE = 150; // erro de compilação
    System.out.println(Carro.VELOCIDADE_LIMITE);
    System.out.println(Carro.VELOCIDADE_LIMITE);

    Ferrari ferrari = new Ferrari();
    ferrari.setNome("Enzo");
    ferrari.imprime();

  }
}
