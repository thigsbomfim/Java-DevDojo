package com.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class ImpressoraEstudante {
  public void imprime(Estudante estudante){
    System.out.println("----------------------");

    // Não fazer isso nunca, alterar um atributo/metodo de uma referencia
    // tudo que fizermos com o objeto passado por referência será alterado no proprio objeto
    estudante.nome = "Gohan";

    System.out.println(estudante.nome);
    System.out.println(estudante.sexo);
    System.out.println(estudante.idade);
  }

}
