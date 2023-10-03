package com.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
  public static void main(String[] args) {
    String nome = "Luffy";
    String nome2 = "    Luffy    ";
    String numeros = "012345";

    System.out.println(nome.charAt(0)); // L
    System.out.println(nome.length()); // 5
    System.out.println(nome.replace("f", "l")); // Lully
    System.out.println(nome.toLowerCase()); // luffy
    System.out.println(nome.toUpperCase()); // LUFFY

    System.out.println(numeros.length()); // 6
    System.out.println(numeros.substring(0)); // 012345
    System.out.println(numeros.substring(0, numeros.length())); // 012345
    System.out.println(numeros.substring(3, numeros.length())); // 345

    // System.out.println(numeros.charAt(numeros.length())); // erro, pois não existe o indice 6

    // remove os valores em branco do começo e do final da string, exemplo, o nome está  "    Luffy    "
    System.out.println(nome2.trim()); // "Luffy"
  }
}
