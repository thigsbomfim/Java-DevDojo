package com.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classes internas, são classe uma dentro da outra
// e quando são úteis?
// Sem trabalhar com interfaces gráficas, é um pouco dificil de ver utilidade de classes internas
// Imagina que temos um chat, geralmente temos a tela e temos os botões, ou seja, temos a interface gráfica e temos
// as ações que podem ser feitas dentro do chat.
// Do ponto de vista da coesão, temos que ter uma classe que toma conta da parte da interface gráfica, e uma parte
// que toma das ações que está acontencendo, clicando no botao de enviar a mensagem e ter que enviar a mensagem,
// para editar a mensagem e assim por diante, ou seja, são objetos diferentes mas que estão tecnicamente, estão
// fortemente acoplados, ou seja, não faz sentido o botão enviar, a ação desse botao enviar estar fora da interface
// gráfica
// então, para esses casos bem específicos, foi criado o uso de interfaces gráficas.

public class OuterClassesTest01 {
  // é um atributo que pertence a classe OuterClassesTest01
  private String name = "Monkey D. Luffy";

  // agora queremos ter uma classe interna, para isso, criamos uma outra classe
  // como podemos ver, temos uma classe dentro de outra classe, essa classe abaixo, é como se fosse um método
  // mas bem mais poderoso, por que podemos declarar atributos, e ele essa classe irá ter acesso a todos os objetos da
  // classe mais externa "OuterClassesTest01"

  class Inner {
    public void printOuterClassAttribute() {
      // temos que se atentar com umas coisas, principalmente o this
      // se chamarmos o this aqui, ele vai se referir a classe interna, que no caso é a Inner, pois estamos rodando
      // o this dentro de uma classe interna
      System.out.println(this);
      System.out.println(OuterClassesTest01.this);
      // como podemos referenciar o this da classe externa?


      System.out.println(name);
    }
  }

  // para criar um objeto
  // o main faz parte da OuterClass
  public static void main(String[] args) {

    // para criar um objeto da classe interna "Inner", precisamos de um objeto da classe externa "OuterClassesTest01",
    // ele está fortemente linkado com a classe externa.
    // existe alguns momentos da nossa vida que iremos desenvolver duas classes aonde somente, digamos que temos classe
    // "A" e classe "B", iremos desenvolver classes aonde somente a classe B vai acessar os atributos de A, não tem
    // nenhum motivo para classe B existir fora da classe A, mas são casos bem específicos que vemos quando estamos
    // codificando

    OuterClassesTest01 outerClass = new OuterClassesTest01();
    // do objeto da classe de fora(externa), eu quero criar um objeto da classe de dentro (interna)
    // aqui estamos referenciando uma classe Interna e instânciando um objeto a partir da classe externa
    OuterClassesTest01.Inner inner1 = outerClass.new Inner();

    // outra forma que temos de criar um objeto da innerClass (classe interna), podemos fazer desta forma:
    // funciona da mesma forma
    Inner inner2 = new OuterClassesTest01().new Inner();

    inner1.printOuterClassAttribute();
    inner2.printOuterClassAttribute();
  }
}
