package com.devdojo.maratonajava.javacore.Lclassesabstratas.test;

import com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.Desenvolvedor;
import com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.Funcionario;
import com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
  public static void main(String[] args) {
    // Classe abstrata não pode ser instânciada, não podemos usar a palavra new para um objeto
    // Funcionario funcionario = new Funcionario("Zoro", 2000);
    Gerente gerente = new Gerente("Nani", 5000);
    Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 12000);
    System.out.println(gerente);
    System.out.println(desenvolvedor);
    gerente.imprime();
    desenvolvedor.imprime();

  }
}
