package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
  public static void main(String[] args) {
    // método antigo
//    List nomes = new ArrayList(); // 1.4
//    // o que estamos adicionando aqui é um objeto, nós sabemos que só são strings aqui dentro, mas o java não sabe
//    // então ele transforma tudo em objeto
//    nomes.add("William");
//    nomes.add("DevDojo Academy");
//    // nomes1.add(123);
//    // aqui estamos passando um object para referenciar o conteúdo do arrayList
//    for (Object nome : nomes) {
//      System.out.println(nome);
//    }


    // novo método usando generics a partir da versão 1.5
    // aqui estamos forçando usando o "<>" para que o tipo desse arrayList seja de String
    // temos a opção de passar como argumento do ArrayList um numero, que representa o tamanho da capacidade
    // A capacidade inicial é definida como 2, mas a lista pode crescer automaticamente.
    // se não passarmos nada, o valor padrão é de 10
    // lembrando, podemos fazer isso aqui abaixo, mas não é indicado:
//    ArrayList<String> nomes1 = new ArrayList<>(2); // 1.5
    // o mais indicado é esse:
    List<String> nomes1 = new ArrayList<>(2); // 1.5
    // quando usamos o generics, o valor do generics obrigatoriamente tem que ser um Objeto, podemos usar o Wrapper

    nomes1.add("William");
    nomes1.add("DevDojo");
    nomes1.add("Academy");
    nomes1.add("Thiago");
    // não podemos colocar numeros inteiros nesse array
    // nomes1.add(123); // irá gerar um erro de compilação
    // podemos usar o remove, para remover valores da lista
    nomes1.remove(1);
    nomes1.remove("William");
    System.out.println(nomes1.remove("academy"));

    // agora que ja foi definido no generics, o tipo da List, podemos usar para referenciar os objetos como String
    for (String nome : nomes1) {
      System.out.println(nome);
      // se usarmos o nomes1.add dentro do for each, irá gerar uma exceção
//      nomes1.add("Suane");
    }

    System.out.println("-----------------");
    // quando estamos trabalhando com listas, não pegamos mais o tamanho da forma antiga: nomes1.length
    // pegamos dessa forma, utilizando size:
    int size = nomes1.size();
    for (int i = 0; i < size; i++) {
      // para pegar o valor, não podemos pegar o valor como nós pegavamos com o array "nomes1[i]", devemos pegar assim:
      System.out.println(nomes1.get(i));

      // se usarmos o nomes1.add dentro do for indexado, é possível, só que, irá gerar um looping eterno
      // para conseguirmos fazer isso, basta criar um int size = nomes1.size(); fora do for, pois ele vai pegar o
      // tamanho atual e colocar dentro da variavel de referencia
//      nomes1.add("Suane");
    }


    List<Integer> numeros = new ArrayList<>();
    numeros.add(10);
    numeros.add(20);
    numeros.add(30);

    for (Integer numero : numeros) {
      System.out.println("numero: "+numero);
    }


    // digamos agora que temos duas listas:
    List<String> nomes3 = new ArrayList<>();
    List<String> nomes4 = new ArrayList<>();

    nomes3.add("Thiago");
    nomes3.add("Academy");
    nomes4.add("William");
    nomes4.add("DevDojo");


    // para adicionar todos os valores de uma coleção, que passa no teste "é uma string"
    // nesse caso, nomes4 é uma string
    nomes3.addAll(nomes4);

    for (String n : nomes3) {
      System.out.println(n);
    }

  }
}
