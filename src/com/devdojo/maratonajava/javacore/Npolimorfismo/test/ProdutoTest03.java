package com.devdojo.maratonajava.javacore.Npolimorfismo.test;

import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;
import com.devdojo.maratonajava.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {
  public static void main(String[] args) {
    Produto produto = new Computador("Ryzen 9", 3000);
    Tomate tomate = new Tomate("Americano", 20);
    tomate.setDataValidade("11/12/2021");

    // este é um exemplo de Widening cast
    CalculadoraImposto.calcularImposto(tomate);
    System.out.println("---------------------");
    CalculadoraImposto.calcularImposto(produto);
  }
}
