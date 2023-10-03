package com.devdojo.maratonajava.javacore.Pwrapper.test;

import java.util.List;

public class WrapperTest01 {
  // Wrappers são mais usados em collections, para atribuir um tipo a uma lista
  // exemplo: List<Integer> list;
  // se usassemos os proprios tipos primitivos para atribuir a collection List, ocorreria um erro
  // exemplo: List<int> list; // Error;
  public static void main(String[] args) {
    // P no final de cada variavel para representar primitivo
    byte byteP = 1;
    short shortP = 1;
    int intP = 1;
    long longP = 10L;
    float floatP = 10F;
    double doubleP = 10D;
    char charP = 'W';
    boolean booleanP = false;

    // W no final de cada variavel para representar Wrapper
    // para criar um wrapper, é só pegar o nome do tipo primitivo e colocar a primeira letra em maiuscula
    // mas lembrando, quando usamos o Wrapper, devemos lembrar que isso não são mais tipos primitivos
    // abaixo, se aplica a regra de polimorfismo, ja nos tipos primitivos acima, se aplica a regra de bytes
    // esse Wrappers abaixo são chamados de autoboxing
    Byte byteW = 1;
    Short shortW = 1;
    Integer intW = 1;
    // não podemos utilizar o Long sem o valor ter a letra L no final, pois ele se torna um integer, e um long não é
    // uma subclasse do integer
    // o mesmo exemplo serve para os outros tipos
    Long longW = 10L;
    Float floatW = 10F;
    Double doubleW = 10D;
    Character charW = 'W';
    Boolean booleanW = false;


    // unboxing é ao contrario do autoboxing, é quando estamos passando para um tipo primitivo, um Wrapper
    // o java se encarrega de transformar esse tipo Wrapper em um tipo primitivo;
    int i = intW;
    Integer intW2 = Integer.parseInt("1");

    // converte um valor dentro de uma string para boolean
    boolean verdadeiro = Boolean.parseBoolean("TrUe");
    boolean falso = Boolean.parseBoolean("fAlSe");
    System.out.println(verdadeiro); // true
    System.out.println(falso); // false

    // é um numero?
    System.out.println(Character.isDigit('A')); // false;
    // é um numero?
    System.out.println(Character.isDigit('9')); // true;
    // é um numero ou um caracter?
    System.out.println(Character.isLetterOrDigit('!')); // false;
    // é maiúscula?
    System.out.println(Character.isLetterOrDigit('A')); // true;
    // é minúscula?
    System.out.println(Character.isLowerCase('a')); // true;

    // transforma em maiúscula
    System.out.println(Character.toUpperCase('a')); // A;
    // transforma em minúscula
    System.out.println(Character.toLowerCase('A')); // A;
  }
}
