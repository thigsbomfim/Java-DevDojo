package com.devdojo.maratonajava.javacore.Fmodificadoresestaticos.dominio;

public class Anime {
  // Bloco de inicialização estático

  // Ordem de seguimento de uma classe
  // 0 - Bloco de inicialização estático é executado apenas uma vez quando a JVM carregar a classe
  // 1 - Alocado espaço em memória do objeto
  // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passado
  // 3 - Bloco de inicialização é executado
  // 4 - Construtor é executado
  private String nome;
  private static int[] episodios;


  // A diferença entre um bloco de inicialização e um construtor é:
  // Um bloco de inicialização é executado independente se um construtor estiver sendo chamado
  // É o mais recomendado, caso tenha que fazer a criação ou inicialização ou lançar uma exceção

  // bloco de inicialização estático é criado sempre quando uma classe é executada
  // a classe não precisa ser instânciada para o bloco funcionar, ele funciona assim que a classe é chamada
  // executa apenas uma vez quando é executado independente de quantas instâncias tiver
  static {
    System.out.println("Dentro do bloco de inicizalização");
    episodios = new int[100];
    for (int i = 0; i < episodios.length; i++) {
      episodios[i] = i+1;
    }
  }

  static {
    System.out.println("Dentro do bloco de inicizalização 2");
  }

  static {
    System.out.println("Dentro do bloco de inicizalização 3");
  }

  // bloco de inicialização não estático é criado sempre quando um objeto é instânciado
  {
    System.out.println("Dentro do bloco de inicizalização não estático");
  }

  public Anime(String nome){
      this.nome = nome;
  }

  public Anime() {

    for(int episodio : episodios){
      System.out.print(episodio + " ");
    }
    System.out.println();
  }

  public String getNome() {
    return nome;
  }

  public int[] getEpisodios() {
    return episodios;
  }
}
