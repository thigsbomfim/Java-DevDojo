package com.devdojo.maratonajava.javacore.Dconstrutores.dominio;

public class Anime {
  private String nome;
  private String tipo;
  private int episodios;
  private String genero;
  private String estudio;

  // construtores não podem ser passado o void
  public Anime(String nome, String tipo, int episodios, String genero) {
    // this() chama o proprio construtor dentro da mesma classe
    // só é possivel passar o this() dentro de um construtor, não é possível passar em um método
    // o this() precisa obrigatoriamente ser a primeira linha executada no construtor
    this();
    this.nome = nome;
    this.tipo = tipo;
    this.episodios = episodios;
    this.genero = genero;
  }
  // Sobrecarga Construtor adicionando mais um argumento
  public Anime(String nome, String tipo, int episodios, String genero, String estudio) {
    this(nome, tipo, episodios, genero);
    this.estudio = estudio;
  }
  // Sobrecarga Construtor sem argumentos
  public Anime(){
    System.out.println("Dentro do construtor sem argumentos");
  }


  public void imprime(){
    System.out.println("Nome: " + this.nome);
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Episodios: " + this.episodios);
    System.out.println("Genero: " + this.genero);
    System.out.println("Estudio: " + this.estudio);
  }

  public String getNome() {
    return nome;
  }

  public String getTipo() {
    return tipo;
  }

  public int getEpisodios() {
    return episodios;
  }

  public String getGenero() {
    return genero;
  }
}
