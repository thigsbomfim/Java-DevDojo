package com.devdojo.maratonajava.javacore.Zgenerics.service;

import java.util.List;

// Geralmente, T é para type, quando trabalhamos com coleções, trabalhamos com E
// aqui, não sabemos qual tipo que irá vir, mas na hora que criarmos um objeto que iremos saber, ele é um tipo
// que vai ser definido no futuro.
// podemos colocar quantos atributos quisermos dentro do generics, exemplo:
// public class RentalService<T, X, I>
// é tudo valido.
// ficaria mais ou menos assim:
// class MaisDeDoisTiposGenericos<T, X, I> {
//    private T t;
//    private X x;
//    private I i;
//  }
//
// class ExibeMaisDeDoisTiposGenericos {
//    public static void main(String[] args) {
//      MaisDeDoisTiposGenericos<Leao, Cachorro, Gato> maisDeDoisTiposGenericos = new MaisDeDoisTiposGenericos<>();
//    }
// }

public class RentalService<T> {
  private List<T> objetosDisponiveis;


  public RentalService(List<T> objetosDisponiveis){
    this.objetosDisponiveis = objetosDisponiveis;
  }

  // aqui ao invés de passarmos carro como tipo, estamos passando o T como o tipo
  public T buscarObjetoDisponivel(){
    System.out.println("Buscando objeto disponível");
    T t = objetosDisponiveis.remove(0);
    System.out.println("Alugando objeto: "+ t);
    System.out.println("Objetos disponíveis para alugar:");
    System.out.println(objetosDisponiveis);
    return t;
  }

  public void retornarObjetoAlugado(T t){
    System.out.println("Devolvendo objeto: "+t);
    objetosDisponiveis.add(t);
    System.out.println("Objetos disponíveis para alugar:");
    System.out.println(objetosDisponiveis);
  }
}
