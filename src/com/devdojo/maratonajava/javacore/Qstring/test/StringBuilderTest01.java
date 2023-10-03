package com.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
  public static void main(String[] args) {
    String nome = "William Suave";
    nome.concat(" DevDojo");
    System.out.println(nome);

    // se não passarmos nada na StringBuilder, ele irá criar uma StringBuilder com uma capacidade para 16 caracteres
    // por padrão, a StringBuilder criará com uma capacidade de 16 caracteres
    StringBuilder sb = new StringBuilder(16);
    // Com StringBuilder e Buffer, não pode ser adicionado uma String dessa forma:
    // sb = nome;   OU    sb = "";

    // Para adicionar uma StringBuilder, se usa:
    // sb.append("Valor");

    // Quando criamos uma string diretamente no construtor
    StringBuilder sb1 = new StringBuilder("William Suane");
    // para concatenar essa string com uma nova string, basta usar append
    // não é legal criar varios appends dessa forma para concatenar strings
    sb1.append(" DevDojo").append(" Academy");

    // se necessario, crie dessa forma:
    // sb1.append(" DevDojo" + " Academy");

    System.out.println(sb1);

    // usar a substring com a StringBuilder, não quer dizer que o valor do objeto StringBuilder será alterado, pois
    // o método substring retorna uma string e não uma StringBuilder, resumindo: o método substring aloca a string
    // no pool de strings
    sb1.substring(0,3); // Wil
    System.out.println(sb1); // William Suane DevDojo Academy

    // Caso queira alterar realmente o valor pegando a substring, devemos criar outra variavel
    String substring = sb1.substring(0, 3); // Wil
    System.out.println(substring); // Wil


    // outros métodos da StringBuilder
    // ele reverte todas as letras, diferente da substring, ele altera realmente a StringBuilder
    sb1.reverse();
    System.out.println(sb1); // ymedacA ojoDveD enauS mailliW
  }
}
