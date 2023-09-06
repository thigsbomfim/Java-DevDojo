package com.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import com.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest02 {
  public static void main(String[] args) {
    Estudante estudante = new Estudante();
    Estudante estudante2 = new Estudante();
    // valores de iniciação padrão de cada tipo [string, int, char]
    System.out.println(estudante.nome);
    System.out.println(estudante.idade);
    System.out.println(estudante.sexo);

    System.out.println("--------------------");

    estudante.nome = "Sanji";
    System.out.println(estudante.nome);
    System.out.println(estudante.idade);
    System.out.println(estudante.sexo);

    System.out.println("--------------------");

    System.out.println(estudante2.nome);
    System.out.println(estudante2.idade);
    System.out.println(estudante2.sexo);



  }
}
