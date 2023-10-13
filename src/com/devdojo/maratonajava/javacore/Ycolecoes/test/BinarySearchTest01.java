package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
  public static void main(String[] args) {
    List<Integer> numeros = new ArrayList<>();
    numeros.add(2);
    numeros.add(0);
    numeros.add(4);
    numeros.add(3);

    // BinarySearch vai fazer uma busca na lista que nós passarmos, e ele vai retornar um índice caso ele encontre o que
    // nós estamos procurando ou caso ele não encontre, ele vai retornar algo seguindo essa regra abaixo:
    // (-(ponto de inserção) - 1)
    // Como ele vai nos dar a posição em que devemos inserir o elemento caso o elemento não exista, existe uma regra:
    // A lista deve ser ordenada. A ordem pode ser definida pelas classes Wrappers ou pelo Comparator, que deve ser passado.
    // Portanto, é obrigatório passar uma lista que já esteja ordenada, caso contrário, o resultado pode ser indefinido.
    // É importante lembrar que a lista precisa ser ordenada para o resultado ser confiável.

    // Vamos ordenar a lista:
    Collections.sort(numeros);

    // Exemplo de uso do binarySearch:
    // (-(ponto de inserção) - 1)
    // Índices: 0, 1, 2, 3
    // Valores: 0, 2, 3, 4
    // O primeiro argumento é a lista, e o segundo é o valor que queremos buscar.
    // Quando buscamos um valor que não existe, ele retorna (-(ponto de inserção) - 1).
    // o resultado vai ser -2 pois o numero 1 que estamos tentando inserir não existe, e o local mais provavel para
    // ele ficar, seria depois do 0, que seria o indice 1, então a conta ficaria:
    // (-1 -1) resultado -2
    System.out.println(Collections.binarySearch(numeros, 1)); // Resultado: -2 (Exemplo: valor não encontrado)
  }

}
