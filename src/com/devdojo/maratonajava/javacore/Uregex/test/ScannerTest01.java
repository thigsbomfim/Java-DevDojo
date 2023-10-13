package com.devdojo.maratonajava.javacore.Uregex.test;

public class ScannerTest01 {
  public static void main(String[] args) {
    // temos uma string onde o delimitador é a virgula
    // queremos pegar o true como um boolean e o 200 como inteiro
    String texto = "Levi, Eren, Mikasa, true, 200";
    // delimitador é o argumento passado no método split
    String[] nomes = texto.split(",");
    for (String nome : nomes) {
      System.out.println(nome.trim());
    }


  }
}
