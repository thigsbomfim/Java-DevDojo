package com.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
  public static void main(String[] args) {
    abreConexao();
  }

  private static String abreConexao() {
    try {
      System.out.println("Abrindo arquivo");
      System.out.println("Escrevendo dados no arquivo");
      return "conexão aberta";
    } catch (Exception e) {
      e.printStackTrace();
    }
    // independente do que acontecer, o finally sempre será executado.
    // nesse caso abaixo, ele está sendo usado para fechar o recurso de criar arquivo que o SO ofereceu
    finally {
      System.out.println("Fechando o recurso liberado pelo SO");
    }
    return null;
  }

  private static void abreConexao2() {
    // usando try, podemos ter a opção de executar o try/catch ou try/finally, nunca podemos usar apenas try
    try {
      System.out.println("Abrindo arquivo");
      System.out.println("Escrevendo dados no arquivo");
    }
    // utilizariamos apenas try/finally quando não nos importamos e não podemos fazer nada com a exceção, mas ainda
    // gostariamos de tratar
    // try/finally não é tão utilizado no dia a dia
    finally {
      System.out.println("Fechando o recurso liberado pelo SO");
    }
  }

}
