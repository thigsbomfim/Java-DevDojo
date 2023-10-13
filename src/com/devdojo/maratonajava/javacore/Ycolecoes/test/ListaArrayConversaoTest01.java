package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
  public static void main(String[] args) {
    List<Integer> numeros = new ArrayList<>();
    numeros.add(1);
    numeros.add(2);
    numeros.add(3);

    // digamos que nós precisamos de um array
    // temos duas opções, na primeira ele vai retornar um array de objetos, o que geralmente não é mt bom
    Object[] array = numeros.toArray();
    // temos a segunda opção, que sobrecarregada, pede um array de objetos, podemos utilizar dessa forma:
    // utiliza-se [0], o java vai descobrir o tamanho que ele precisa criar,
    // também temos a opção de passar "new Integer[numeros.size()]
    // Em um artigo, foi visto que o desempenho utilizando-se "Integer[0]" era mais rápido
    Integer[] listToArray = numeros.toArray(new Integer[0]);
    System.out.println(Arrays.toString(listToArray));

    System.out.println("--------------");

    // agora vamos fazer de outro jeito, digamos que nós temos um array de inteiros e queremos transformar em lista
    Integer[] numerosArray = new Integer[3];
    numerosArray[0] = 1;
    numerosArray[1] = 2;
    numerosArray[2] = 3;

    // temos algumas opções, primeira opção é utilizando o método Arrays
    // mas devemos tomar bastante cuidado ao usar esse Arrays.asList(), pois ele meio que cria um link com o array
    // que nós temos
    List<Integer> arrayToList = Arrays.asList(numerosArray);
    // ambos os valores são os mesmos, mas se utilizarmos o set, ambos os valores serão alterados, pois ele cria um link
    // com o array original, então ambos serão alterados
    /*
    * Exemplo:
    * numerosArray = [1, 2, 3]
    * arrayToList = [1, 2, 3]
    *
    * Utilizando o set em qualquer um dos arrays:
    *
    * arrayToList.set(0, 12);
    * numerosArray = [12, 2, 3]
    * arrayToList = [12, 2, 3]
    *
    * Ambos os valores foram alterados
    *
    * */
    // aqui estamos mudando o valor do indice 0, para 12. Primeiro argumento é o indice e o segundo o valor/elemento
    arrayToList.set(0, 12);
    // isso fica mais complicado ainda se tentarmos adicionar um valor, digamos apenas que queremos adicionar um valor
    // qualquer
//    arrayToList.add(19); // teremos uma exceção, não podemos fazer alterações quando crio um Array através do asList
    System.out.println(Arrays.toString(numerosArray)); // utilizando o set [12, 2, 3]
    System.out.println(arrayToList); // utilizando o set [12, 2, 3]

    System.out.println("--------------");

    // Então como podemos criar um array com asList em que podemos fazer alterações?
    // podemos fazer da seguinte forma:
    // dessa forma, ele vai criar um novo ArrayList com os valores Arrays.asList e a gente vai poder alterar
    // estamos quebrando o vinculo que nós teriamos apenas utilizando o Arrays.asList sem o ArrayList
    List<Integer> numeroList = new ArrayList<>(Arrays.asList(numerosArray));
    numeroList.add(15);
    System.out.println(numeroList);
    System.out.println(Arrays.toString(numerosArray));


    // Duas formas para criar lista em apenas uma linha
    // primeira
    List<Integer> listInteiros = Arrays.asList(1, 2, 3, 4, 5); // dessa forma ele irá criar uma lista de inteiros
    // ou poderiamos passar os valores em String
    List<String> listString = Arrays.asList("1", "2", "3", "4"); // dessa forma ele irá criar uma lista de strings

    // segunda
    // também podemos criar assim apartir do java versão 11, é a mesma coisa que o de cima, mas é dessa forma:
    List<Integer> listIntegersOf = List.of(1, 2, 3, 4);


  }
}
