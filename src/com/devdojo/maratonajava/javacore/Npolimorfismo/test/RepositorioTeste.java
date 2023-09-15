package com.devdojo.maratonajava.javacore.Npolimorfismo.test;

import com.devdojo.maratonajava.javacore.Npolimorfismo.repositorio.Repositorio;
import com.devdojo.maratonajava.javacore.Npolimorfismo.servico.RepositorioBancoDeDados;

public class RepositorioTeste {
  public static void main(String[] args) {
    // polimorfismo
    /*
      programação orientada a interface, você coloca o tipo como a propria interface Repositorio,
      e a instância do objeto como
      // as implementações da interface Repositorio
    */
    Repositorio repositorio = new RepositorioBancoDeDados();
    repositorio.salvar();
  }
}
