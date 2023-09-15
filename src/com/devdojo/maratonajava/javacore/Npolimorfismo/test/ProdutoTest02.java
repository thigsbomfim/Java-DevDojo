package com.devdojo.maratonajava.javacore.Npolimorfismo.test;

import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import com.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class ProdutoTest02 {
  // polimorfismo
  public static void main(String[] args) {
    // a variavel de referencia será a superclasse produto e o objeto será uma das subclasses, classes
    // que extenderam(extends) as funcionalidades de produto
    // Um tipo mais generico(Produto/superclasse) fazendo referencia para um tipo mais especifico(Computador/subclasse)
    // tudo que eu tenho em produto computador vai ter, por que computador é o filho/herda caracteristicas do pai
    Produto produto = new Computador("Ryzen 9", 3000);
    Produto produto2 = new Tomate("Americano", 20);

  }
}
