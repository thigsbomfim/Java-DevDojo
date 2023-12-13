package com.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.List;

//  Métodos criados com wildcards do tipo "super" são mais usados quando você deseja adicionar elementos a uma lista,
//  enquanto wildcards do tipo "extends" são mais usados quando você deseja ler elementos da lista.

public class WildcardTest03 {

  public static void main(String[] args) {
    List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
    List<Gato> gatos = List.of(new Gato(), new Gato());

    // usando para visualização
    printConsulta(cachorros);
    printConsulta(gatos);
  }


  // como podemos melhorar esse printConsulta, fazer algo mais genérico para aceitar que a coleção, que passe no teste:
  // "é um animal", e deixar funcionando, diferente do WildcardTest02.
  // o Wildcard é bem simples, ele é um ponto de interrogação "?", esse é o wildcard.
  // aqui por exemplo, eu quero aceitar dentro desse método, qualquer tipo de lista que seja um animal, que estenda um
  // animal "Gato", "Cachorro".
  // qualquer tipo de lista que seja estendida de um animal: "List<? extends Animal>
  // agora dois pontos importantes,
  // primeiro: quando nós fizermos isso, estamos assinando um contrato, o contrato diz que não podemos adicionar
  // elementos nessa lista, imagina um seguinte, estamos passando abaixo, qualquer coisa que seja um animal, digamos
  // que a gente passe um animal, que pode ser cachorro, gato, dessa forma:
  // Animal a = new Cachorro();
  // Animal a = new Gato();
  // do ponto de vista da herança e polimorfismo, isso é valido, podemos passar ambas as classes.
  // o problema é, o que acontece se passarmos uma lista de cachorro? exemplo:
  // Cachorro c = new Cachorro(); // dessa forma pode ser criado
  // Cachorro c1 = new Animal(); // não podemos fazer isso, pois cachorro é uma classe específica
  // Cachorro c2 = new Gato(); // da mesma forma que também não poderiamos criar assim
  // então por causa desse problema, que podemos aceitar qualquer coisa que seja filha de animal, que estenda animal,
  // que podemos passar coleções que são irmãs, que nunca vão passar no teste de polimorfismo, não podemos adicionar.
  // é como se estivessemos criando uma classe temporaria que se chamaria animais, e que iria estender Animal, onde
  // perdemos a possibilidade de adicionar elementos nessa lista do objeto animais, ou seja, tudo que passarmos,
  // será apenas para leitura.
  // segundo ponto importante:
  // independente se o paramêtro abaixo é uma interface ou uma classe abstrata, a palavra sempre será extends, nunca
  // podemos utilizar implements no lugar de extends, independente se for classe abstrata ou interface.
  // dessa forma que está abaixo, podemos utilizar normalmente para visualização.

  private static void printConsulta(List<? extends Animal> animais) {
    for (Animal animal : animais) {
      animal.consulta();
    }
    // podemos adicionar um cachorro, por que exatamente o que fizemos com arrays, é como se tivessemos um animal,
    // criando uma referência com o objeto do tipo cachorro, dessa forma:
//    Animal a = new Cachorro();
//    animais.add(new Cachorro());
  }

  // e se quisermos adicionar elementos na lista? o que podemos fazer?
  // a gente pode fazer da seguinte forma:
  // eu quero receber nessa lista, qualquer tipo de objeto que seja um animal ou um super de animal.
  // qual a diferença? acima, no método printConsulta, estamos dizendo que podemos receber animais ou qualquer um que
  // seja filho de animal.
  // e abaixo estamos dizendo que podemos receber animal ou qualquer um que seja pai, então por exemplo, vamos dizer
  // que o paramêtro receba cachorro ao invés de animal:
  // printConsultaAnimal(List<? super Cachorro> cachorros)
  // o que pode vir nessa lista? com o objeto? pode vir uma lista de cachorros, pode vir uma lista de Animais, ou pode
  // vir uma lista de objects, ficaria mais ou menos assim:
  // printConsultaAnimal: Object << Animal << Cachorro
  // printConsulta: Cachorro >> ?
  // mas ai, usando o super, não saberiamos o que realmente é, quando estamos indo para baixo, usando extends,
  // é facil saber, mas e quando é para cima? usando o super? o que conseguimos receber com uma variavle de referencia?
  // temos que subir até bater no topo e o topo é o Object, então não conseguimos utilizar nada que não seja Object aqui
  // quando utilizarmos o super dessa forma, a opção que temos é usar o object
  // for(Object o : animais){
        // teriamos que fazer daquela forma que aprendemos anteriormente para saber se realmente é um cachorro
  //    if(o instanceof Cachorro) {

  //    }
  // }
  // mas então, por que podemos adicionar?
  // então estamos falando, obrigatoriamente, tudo que estamos passando precisa ser um Animal ou um super de Animal
  // se vai ser um Animal, podemos ver que se utilizarmos esse método: printConsultaAnimal(cachorros), não poderá ser
  // passado mais as listas de cachorros e nem gatos, pois eles são subclasses de Animal, e só aceitamos superclasses
  // e com isso, temos algumas garantias, e quais são essas garantias?
  // a garantia é que os objetos que vamos passar dentro dessa lista, sempre vão ser do tipo Animal, então como temos
  // o tipo Animal, podemos passar:
  // Animal animal = new Cachorro();
  // Animal animal1 = new Gato();
  // e podemos colocar dentro da lista animais
  // animais.add(animal);
  // animais.add(animal1);
  // então por que podemos adicionar no método abaixo e no método de cima não? por que se passarmos uma lista de
  // cachorros no método printConsulta, eu não posso adicionar gatos e vice e versa e na classe printConsultaAnimal, eu
  // posso adicionar qualquer uma das subclasses por que eu tenho garantia de polimorfismo, ele passa no teste "é um", e
  // como eu não sei o que vai vir, eu posso ter problema com os irmãos caso nos basearmos nos filhos e não nos pais
  private static void printConsultaAnimal(List<? super Animal> animais) {
     Animal animal = new Cachorro();
     Animal animal1 = new Gato();
     animais.add(animal);
     animais.add(animal1);
  }
}


