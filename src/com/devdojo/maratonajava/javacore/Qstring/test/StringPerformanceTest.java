package com.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest {
  public static void main(String[] args) {
    /*
    * QUANDO TRABALHAR COM String OU StringBuilder OU StringBuffer?
    * Quando estamos trabalhando com um sistema estamos fazendo um mapeamento das regras de negócio que tem no mundo
    * real, essas regras de negócios do mundo real, é o que vão me dizer se eu realmente preciso usar StringBuilder ou
    * StringBuffer ao invés de String.
    * Na maioria das vezes, iremos sempre trabalhar com Strings para fazer o mapeamento do mundo computacional, sempre
    * vai requerer Strings, exemplo: nos dominios que nós temos, Pessoa, Estudante, Funcionario e essas coisas, não
    * iremos colocar StringBuffer, iremos colocar String normal, é o que representa o mundo real no nosso mundo
    * computacional, o nome é uma String, não é uma StringBuffer nem uma StringBuilder, e quando trabalhamos com
    * StringBuilder e StringBuffer nós adicionamos mais um pouquinho de complexidade
    * */

    // o tempo atual do sistema em milisegundos
    long inicio = System.currentTimeMillis();
    concatString(30_000);
    long fim = System.currentTimeMillis();
    System.out.println("Tempo gasto para String " + (fim - inicio) + "ms");

    inicio = System.currentTimeMillis();
    concatStringBuilder(1_000_000);
    fim = System.currentTimeMillis();
    System.out.println("Tempo gasto para StringBuilder " + (fim - inicio) + "ms");

    // StringBuilder serve para
    inicio = System.currentTimeMillis();
    concatStringBuffer(1_000_000);
    fim = System.currentTimeMillis();
    System.out.println("Tempo gasto para StringBuffer " + (fim - inicio) + "ms");
  }

  private static void concatString(int tamanho){
    String texto = "";

    for(int i = 0; i<tamanho; i++){
      texto+=i;
    }
  }

  private static void concatStringBuilder(int tamanho){
    StringBuilder sb = new StringBuilder(tamanho);

    for(int i = 0; i<tamanho; i++){
      sb.append(i);
    }
  }

  private static void concatStringBuffer(int tamanho){
    StringBuffer sb = new StringBuffer(tamanho);

    for(int i = 0; i<tamanho; i++){
      sb.append(i);
    }
  }
}
