package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
  public static void main(String[] args) {
    Smartphone s1 = new Smartphone("1ABC1", "IPhone");
    Smartphone s2 = new Smartphone("22222", "Pixel");
    Smartphone s3 = new Smartphone("33333", "Samsung");

    // criando uma lista a partir do objeto smartphone
    List<Smartphone> smartphones = new ArrayList<>(6);
    smartphones.add(s1);
    smartphones.add(s2);
    // agora se quisermos adicionar o s3 dentro da lista em um indice específico
    smartphones.add(0,s3);

    // digamos que queremos limpar esse array, mas não queremos perder a variavel de referencia "smartphones"
    // esse .clear deleta/limpa tudo dessa lista
//    smartphones.clear();

    // aqui estamos chamando o objeto do tipo passado no generics para referenciar o valor que queremos pegar
    for (Smartphone smartphone : smartphones) {
      System.out.println(smartphone);
    }

    // esse é o smartphone4 que está sendo inserido pelas pessoas, e nós temos a lista acima, queremos saber
    // primeiramente se esse smartphone existe naquela lista
    Smartphone s4 = new Smartphone("22222", "Pixel");
    // seria a mesma coisa que s4.equals(s2), sendo que estamos observando dentro do smartphones
    // contains serve para observar se contém valores iguais dentro da lista, para não criar duplicatas
    // ele retorna true ou false
    System.out.println(smartphones.contains(s4));
    if(smartphones.contains(s4)) System.out.println("Este smartphone já contém dentro da lista");

    // também temos outro método, que é o indexOf, ele vai trazer o indice do objeto em que estou passando
    // aqui estou passando um objeto que ja contém dentro da lista
    // se o equals onde o indexOf acessa, não encontrar um objeto igual a esse que estamos passando, irá retornar -1
    int indexSmartphone4 = smartphones.indexOf(s4); // ele está representando o smartphone s2, mesmo fora da lista
    if (indexSmartphone4 != -1) {
      System.out.println(indexSmartphone4);
      // se não existir o objeto dentro da lista ou a referencia dele, irá retornar uma exceção ao tentar usar o get
      System.out.println(smartphones.get(indexSmartphone4));
    } else {
      System.out.println("Objeto não existe");
    }


  }
}
