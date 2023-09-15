package com.devdojo.maratonajava.javacore.Npolimorfismo.servico;

import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {
  // uma superclasse (Produto) que recebe um objeto subclasse(Televisao, Computador, Tomate)
  // Esse método recebe uma referência especifica(Computador,Televisão...) e passa uma referencia genérica(Produto)
  public static void calcularImposto(Produto produto) {
    System.out.println("Relatório de imposto");
    double imposto = produto.calcularImposto();
    System.out.println("Produto: " + produto.getNome());
    System.out.println("Preço: " + produto.getValor());
    System.out.println("Imposto a ser pago: " + imposto);
    // se o produto(o objeto que o produto ta referenciando) for uma instância(instanceof) da classe Tomate
    if(produto instanceof Tomate) {
      // este é um exemplo de Narrowing cast
      // primeira forma de usar:
      Tomate tomate = (Tomate) produto;
      // segunda forma de usar:
      String dataValidade = ((Tomate) produto).getDataValidade();
      System.out.println(dataValidade);
    }
  }
}
