package com.devdojo.maratonajava.javacore.Eblocosinicializacao.dominio;

public class Anime {
  // Ordem de seguimento de uma classe
  // 1 - Alocado espaço em memória do objeto
  // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passado
  // 3 - Bloco de inicialização é executado
  // 4 - Construtor é executado
  private String nome;
  private int[] episodios;


  // A diferença entre um bloco de inicialização e um construtor é:
  // Um bloco de inicialização é executado independente se um construtor estiver chamado
  // É o mais recomendado, caso tenha que fazer a criação ou inicialização ou lançar uma exceção

  // bloco de inicialização
  {
    episodios = new int[100];
    for (int i = 0; i < episodios.length; i++) {
      episodios[i] = i+1;
    }
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
