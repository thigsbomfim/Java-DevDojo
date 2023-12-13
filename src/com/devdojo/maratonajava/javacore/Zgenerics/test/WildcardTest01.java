package com.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal {
  public abstract void consulta();
}

class Cachorro extends Animal {
  public void consulta(){
    System.out.println("Consultando doguinho");
  }
}

class Gato extends Animal {
  public void consulta(){
    System.out.println("Consultando gato");
  }
}


public class WildcardTest01{


  public static void main(String[] args) {
    // basicamente, temos dois arrays de cachorros e gatos, ambos com dois objetos de cada
    Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
    Gato[] gatos = {new Gato(), new Gato()};

    // agora vamos chamar o método printConsulta e chamar ambos os animais
    printConsulta(cachorros);
    printConsulta(gatos);

    // podemos ver que funcionou normalmente, por que o java sabe, principalmente com arrays em tempo de execução, qual
    // é o tipo de objeto que estamos trabalhando, então quando criamos um array de cachorro, ele sabe que é um array
    // de cachorro, e quando criamos um array de animal ele sabe que é de animal, ele sabe dentro do array o que nós
    // temos em tempo de execução.
    // Como assim sabe que nós temos?
    // imagina que dentro do método printConsulta nós temos um array de animais, ai não sabemos o que está vindo,
    // a gente sabe que é um array de animais, a gente pode fazer o seguinte dentro do método printConsulta,
    // o array de animais na posição 1, que é um array de cachorros, como podemos ver, o código não tem nenhum erro
    // de compilação, o codigo compila normalmente, mas o que acontece quando tentamos executar?
    // animals[1] = new Gato();
    // é gerada uma exceção ArrayStoreException, pois o java sabe que o array que estamos passando na primeira iteração,
    // nós temos um array de cachorro, e estamos tentando colocar um gato no array de cachorro, teremos uma exceção,
    // porém, se fosse um array de animais mesmo, poderiamos colocar o gato lá dentro.
    // exemplo de array de animais:
    Animal[] animais = {new Gato(), new Cachorro()};
    printConsulta(animais);
    // dessa forma funciona, pois estamos fazendo o uso do polimorfismo, pois é como se estivessemos fazendo dessa
    // forma:
//    Animal animal = new Gato();
    // funciona muito bem quando estamos trabalhando com arrays, mas quando tentamos realizar isso com listas, as coisas
    // começam a ficar um pouquinho complicadas
  }

  // vamos imaginar que temos um método que vamos receber todos os tipos de animais, mas esse método se comporta de
  // formas diferente se estamos trabalhando com arrays ou com listas
  private static void printConsulta(Animal[] animais) {
    for (Animal animal : animais) {
      animal.consulta();
    }
//    animais[1] = new Gato();
  }
}


