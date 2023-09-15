package com.devdojo.maratonajava.javacore.Hheranca.test;

import com.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {
  // Ordem de seguimento de uma classe com herança - ordem de inicialização de uma classe com herança
  // 0 - Bloco de inicialização estático da superclasse/pai é executado apenas uma vez quando a JVM carregar a superclasse
  // 1 - Bloco de inicialização estático da subclasse/filha é executado apenas uma vez quando a JVM carregar a subclasse
  // 2 - Alocado espaço em memória dos atributos da superclasse
  // 3 - Cada atributo de superclasse/pai é criado e inicializado com valores default ou o que for passado da superclasse
  // 4 - Bloco de inicialização não estático da superclasse é executado na ordem que aparece
  // 5 - Construtor da superclasse é executado
  // 6 - Alocado espaço em memória dos atributos da subclasse
  // 7 - Cada atributo de subclasse/filha é criado e inicializado com valores default ou o que for passado da subclasse
  // 8 - Bloco de inicialização não estático da subclasse é executado na ordem que aparece
  // 9 - Construtor da subclasse é executado

  public static void main(String[] args) {
    Funcionario funcionario = new Funcionario("Jiraya");
  }
}
