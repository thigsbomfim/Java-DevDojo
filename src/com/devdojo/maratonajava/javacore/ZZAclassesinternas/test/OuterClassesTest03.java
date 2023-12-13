package com.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// classe top level, nivel mais alto
public class OuterClassesTest03 {
  // classes estáticas aninhadas, basicamente é bem parecida com classes internas, mas o que teremos de diferente
  // é o modificador static, e quando utilizamos esse static, é como se estivessemos uma classe uma outra classe de alto
  // nivel, como se essa classe estivesse fora, igual a OuterClassesTest03 e só estamos fazendo dessa forma, dentro da
  // OuterClassesTest03, por mais uma questão de empacotamento.
  // através da static class abaixo, não podemos acessar nenhum atributo que não seja estático da classe mais externa,
  // da classe OuterClassesTest03, exemplo, digamos nós temos um atributo name:
  private String name = "William";
  // esse atributo name, não poderá ser acessado de dentro da classe interna static class

  static class Nested {
    // também poderiamos criar atributos dentro dela:
    private String lastName = "Suane";

    void print() {
      // não podemos acessar o name, pois ele não é estático e estamos dentro de uma classe interna estatica.
//      System.out.println(name);
      // então como podemos fazer para acessar o name?

      // teriamos que criar um "new OuterClassesTest03().name" e chamar o atributo name, dessa forma:
      System.out.println(new OuterClassesTest03().name + " " + this.lastName);
    }
  }

  public static void main(String[] args) {
    // para podermos acessar a classe interna estática, podemos acessar dessa forma:
    Nested nested = new Nested();
    nested.print();
  }
}
