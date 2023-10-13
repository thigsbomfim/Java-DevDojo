package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
  public static void main(String[] args) {
    String nome = "Thiago Bomfim";
    String nome2 = "Thiago Bomfim";
    String nome3 = new String("Thiago Bomfim");
    System.out.println(nome == nome2); // true, pois os dois estão alocando o mesmo espaço de memoria no pool de string
    // o que está sendo comparado não é o valor do objeto em si, mas sim a referencia de onde estão alocados
    // nome está no pool de strings e nome3 é um objeto que está no heap
    // Isso retornará false, mesmo que o objeto String contenha o mesmo valor.
    // A razão é que nome3 foi criado usando o operador new, o que força a criação de um novo objeto no heap,
    // independentemente do valor.
    System.out.println(nome == nome3); // false, pois o nome3 agora é um objeto de string e ele está no heap

    // para comparar os valores da string em si, independente de ser um objeto
    System.out.println(nome.equals(nome3)); // true



    // verificando logicamente se dois smartphones são iguais
    // como saber se algo é unico se tratando de eletronicos? quando o numero de serialNumber é exatamente o mesmo
    Smartphone s1 = new Smartphone("1ABC1", "IPhone");
    Smartphone s2 = new Smartphone("1ABC1", "IPhone");
    // os dois objetos são distintos dentro do heap, mesmo tendo os valores dentro sendo os mesmos
    System.out.println(s1.equals(s2)); // false

    // para dar true, é preciso que a nova variavel aponte para a variavel que queremos comparar, dessa forma:
    Smartphone s3 = s1;
    System.out.println(s1.equals(s3)); // true
  }
}
