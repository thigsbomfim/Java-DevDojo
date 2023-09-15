package com.devdojo.maratonajava.javacore.Hheranca.test;

import com.devdojo.maratonajava.javacore.Hheranca.dominio.Endereco;
import com.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;
import com.devdojo.maratonajava.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
  public static void main(String[] args) {
    Endereco endereco = new Endereco();
    endereco.setRua("Rua 3");
    endereco.setCep("012345-289");
    Pessoa pessoa1 = new Pessoa("Toyohisa Shimazu");
    pessoa1.setCpf("11111111111");
    pessoa1.setEndereco(endereco);
    pessoa1.imprime();

    Funcionario funcionario = new Funcionario("Oda Nobunaga");
    funcionario.setCpf("22222222222");
    funcionario.setEndereco(endereco);
    funcionario.setSalario(20000);
    System.out.println("----------------");
    funcionario.imprime();
  }
}
