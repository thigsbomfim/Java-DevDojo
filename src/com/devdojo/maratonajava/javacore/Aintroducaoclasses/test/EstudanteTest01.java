package com.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import com.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest01 {
  public static void main(String[] args) {
    Estudante estudante = new Estudante();
    Estudante estudante2 = new Estudante();

    estudante.nome = "Luffy";
    estudante.idade = 21;
    estudante.sexo = 'M';

    System.out.println(estudante.nome);
    System.out.println(estudante.idade);
    System.out.println(estudante.sexo);

    estudante2.nome = "Luffy";
    estudante2.idade = 21;
    estudante2.sexo = 'M';

    System.out.println(estudante2.nome);
    System.out.println(estudante2.idade);
    System.out.println(estudante2.sexo);
  }
}
