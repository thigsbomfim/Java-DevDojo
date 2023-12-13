package com.devdojo.maratonajava.javacore.Zgenerics.test;


import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.List;

// a sintaxe de um método genérico é assim:

// digamos que agora eu quero receber apenas objetos que seja um Comparable
//                 tipo genérico       retorno    nome do método          parâmetro do tipo genérico
//  private static <T>                 List<T>    criarArrayComUmObjeto2  (T t){
//          return List.of(t);
//  }

// vamos imaginar o seguinte problema, temos uma classe MetodoGenerico, e queremos criar um método onde ele crie um
// array para mim, eu vou passar um objeto e ele vai retornar um array desse objeto para mim
public class MetodoGenericoTest01 {
  public static void main(String[] args) {
    // aqui estamos criando um novo objeto e passando para uma lista de objetos do tipo Barco
    // estamos criando um método genérico que não retorna nada, apenas insere o objeto dentro de uma lista
    criarArrayComUmObjeto(new Barco("Canoa Marota"));

    // aqui estamos criando uma nova lista com um objeto do tipo barco
    List<Barco> barcoList = criarArrayComUmObjeto1(new Barco("Canoa Marota"));
    System.out.println(barcoList);

    // esse método, o objeto que estamos criando dentro desse método, precisa ter implementado o comparable
//    List<Barco> barcoList1 = criarArrayComUmObjeto2(new Barco("Canoa Marota"));
  }

  // primeira coisa quando estamos definindo um método generico, é definindo um tipo
  // esse T abaixo, vem depois dos modificadores de acesso e antes do tipo de retorno
  // por exemplo, se não tivermos nenhum tipo de retorno, teremos o void
  // o tipo do objeto que iremos receber, é o T que definimos como o tipo do método
  private static <T> void criarArrayComUmObjeto(T t){
    List<T> list = List.of(t);
    System.out.println(list);
  }

  // como também podemos criar um método para retornar a lista ao invés de usar o void para não retornar nada
  // veja que estamos passando o tipo <T> na lista que esperamos que seja retornado, então o T significa o tipo
  // da lista que queremos que seja retornado
  private static <T> List<T> criarArrayComUmObjeto1(T t){
    return List.of(t);
  }

  // digamos que agora eu quero receber apenas objetos que seja um Comparable
  private static <T extends Comparable<T>> List<T> criarArrayComUmObjeto2(T t){
    return List.of(t);
  }
}
