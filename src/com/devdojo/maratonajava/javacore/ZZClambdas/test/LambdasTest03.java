package com.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// Predicate (Predicado):
// Definição Simples: Um Predicate é uma função que recebe um valor como entrada e retorna verdadeiro ou falso com base
// em uma condição específica.
// Descrição: Você usa um Predicate para verificar se um elemento atende a uma determinada condição.
// Por exemplo, você pode usá-lo para verificar se um número é par ou ímpar.
//
// Consumer (Consumidor):
// Definição Simples: Um Consumer é uma função que recebe um valor como entrada, realiza uma ação com esse valor e
// não retorna nenhum resultado.
// Descrição: O Consumer é útil quando você deseja realizar uma operação em um elemento, como imprimir, formatar ou
// modificar, mas não precisa de um valor de retorno. É como um "consumidor" de dados.
//
// Function (Função):
// Definição Simples: Uma Function é uma função que recebe um valor como entrada e retorna um valor transformado com
// base em uma regra específica.
// Descrição: Você usa uma Function para transformar um valor de entrada em um valor de saída de acordo com uma regra
// ou transformação específica.
// Por exemplo, você pode usar uma Function para converter uma temperatura de Celsius para Fahrenheit.


// Function é uma interface funcional.
// Function tem uma pequena diferença, ela contém o tipo T e o tipo R passado no generics
// Function<T, R>
// o tipo T é o que vamos receber, o tipo R o que vamos retornar, e pode ser absolutamente qualquer coisa

public class LambdasTest03 {
  public static void main(String[] args) {

    List<String> strings = List.of("Thiago", "William", "Luffy", "Zoro");

    // nesse casso, <T> passado no parâmetro da Function seria str e R seria o retorno esperado que é str.length
    // aqui podemos observar que o tipo da variavel que estamos declarando é integer, e o que estamos passando no map
    // é o tipo string que retorna o tamanho da string, que é um Integer
    List<Integer> lengthStr = map(strings, str -> str.length());
    System.out.println(lengthStr);
    // aqui estamos retornando todos os elementos em letras maiusculas
    List<String> upperCaseStr = map(strings, str -> str.toUpperCase());
    System.out.println(upperCaseStr);
    List<String> lowerCaseStr = map(strings, str -> str.toLowerCase());
    System.out.println(lowerCaseStr);

  }

  // método que retorna o uma lista com os tamanhos de cada string
  private static <T, R> List<R> map(List<T> list, Function<T, R> function){
    List<R> result = new ArrayList<>();
    for (T element : list) {
      // aqui estamos usando o método apply para adicionar elementos do tipo <T>, que não sabemos qual é
      R r = function.apply(element);
      // aqui estamos adicionando o retorno dentro da nova lista que criamos acima, onde poderia ser qualquer coisa
      result.add(r);
    }
    return result;
  }
}
