package com.devdojo.maratonajava.javacore.Zgenerics.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
  public static void main(String[] args) {
    // Antigamente até a versão 1.4 do java, as coisas funcionavam mais ou menos assim:
    List list = new ArrayList();

    // aqui você diz que o java vai guardar elementos mas qual tipo de elementos? ou seja, você pode colocar qualquer
    // tipo de elementos
    list.add("Midorya");
    list.add(123L);
    list.add(new Consumidor("Goku"));


    // pensando nisso, tem varias coisas que podem acontencer, quando vamos usar o for, qual é o objeto que colocamos
    // como referencia? só pode ser Object, por que ja que podemos aceitar qualquer tipo de objeto nessa lista, nós
    // precisamos usar o Object como variavel de referencia pois não sabemos o que tem la dentro
    for (Object o : list) {
      // ai né, podemos imprimir o objeto, pois o java tem o toString e ele vai simplesmente vai transformar todos em
      // string, o problema é quando precisamos manipular, exemplo, quero manipular essa string:
      // esse objeto é uma instância de uma String?
      if(o instanceof String) System.out.println(o);
      // mas ai ele também poderia ser um long
      if(o instanceof Long) System.out.println(o);
      // Ou se a instância é um Consumidor
      if(o instanceof Consumidor) {
        // mas como podemos ver, as coisas começam a ficar complicadas, imagina a quantidade de elementos que a gente
        // não precisa ficar criando se a gente levar em consideração que o sistema bem pequenininho tem 60/70 classes,
        // teriamos que ficar checando uma por uma? então isso aqui, é algo que infelizmente poderia acontecer até a
        // versão 1.4 do java, então o que aconteceu foi que a galera viu que existiam formas melhores.
        // Então eles precisavam de uma forma onde eles conseguiriam definir o tipo da lista mas o problema é que o java
        // é uma linguagem, durante todas as atualizações, eles tem que manter a compatibilidade com as versões
        // anteriores
        Consumidor c = (Consumidor) o;
        System.out.println(o);
      }
    }


    // O Generics, foi algo que foi adicionado em tempo de compilação, ou seja, quando colocamos o tipo dentro do "<>"
    // estamos forçando em tempo de compilação, ou seja, o compilador não vai deixar a gente executar o código.
    // no começo do generics, também era passado o tipo na declaração do objeto que está sendo instânciado "ArrayList"
    // onde o tipo não poderia ser diferente do tipo passado no generics da List
//      List<String> lista = new ArrayList<String>();
    List<String> lista = new ArrayList<>();
    // O java não vai deixar você executar esse código, por que nós estamos falando acima que ele só aceita String
    // na lista:
//      lista.add(123);

    // ai as coisas ficaram mais fáceis, agora posso utilizar o for e passar um tipo na variavel de referencia, pois
    // eu sei que o tipo vai ser sempre String
    for (String o : lista) {
      System.out.println(o);
    }

    // mas devemos tomar bastante cuidado, desta forma que nós estamos fazendo aqui, é alterado em tempo de compilação,
    // ou seja, é alterado antes de enviar para a JVM
//    List<String> list = new ArrayList<>();
    // quando o java manda o bytecode para a JVM, ele vai assim:
//    List list = new ArrayList();
    // então lá, dentro da JVM, não sabemos o que tem dentro dessa lista, por isso é feito esse checked em tempo de
    // compilação, dessa forma podemos manter compatibilidade com todos os sistemas existentes e continua atualizando a
    // linguagem
    // Esse conceito é chamado de Type erasure, por que ele realmente está apagando o tipo depois que o código é
    // compilado

    // aqui estamos passando a lista que é do tipo String, e um Consumidor que é do tipo Consumidor.
    // estamos adicionando na lista, um objeto do tipo Consumidor, sendo que a lista é de strings
    // Ao executar esse código, podemos ver que não acontece nada, o método funciona normalmente
    add(lista, new Consumidor("Midoriya"));
    // mas se criarmos um laço novamente, podemos ver que temos uma exceção ClassCastException, pois está como String,
    // e foi adicionado nessa lista, um Objeto do tipo Consumidor.
    for (String o : lista) {
      System.out.println(o);
    }

    // para conseguirmos observar, usamos o Object.
    // Isso acontece quando não usamos o generics, por isso o uso do Generics é muito importante
    for (Object o : lista) {
      System.out.println(o);
    }
  }

  // MÉTODO SEM GENERICS
  // mostrando algo bem estranho que pode acontecer
  public static void add(List lista, Consumidor consumidor){
    // digamos que estamos criando uma lista de consumidores
    lista.add(consumidor);
  }

  /*
    // MÉTODO COM GENERICS
    // aqui o método está sendo criado corretamente, ele vai fazer a validação dos tipos em tempo de compilação, ele não
    // deixa o código passar para JVM se não tomar cuidado e colocar o tipo corretamente
    public static void add(List<String> lista, Consumidor consumidor){
    // digamos que estamos criando uma lista de consumidores
      lista.add(consumidor);
    }
  */

}
