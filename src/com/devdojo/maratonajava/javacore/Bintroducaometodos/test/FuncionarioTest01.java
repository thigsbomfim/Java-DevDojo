package com.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import com.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {
  public static void main(String[] args) {
    Funcionario funcionario01 = new Funcionario();

    funcionario01.setNome("Sanji");
    funcionario01.setIdade(25);
    funcionario01.setSalarios(1200, 987.32, 2000);
    funcionario01.imprime();
    System.out.println("Média " + funcionario01.getMedia());
  }
}
