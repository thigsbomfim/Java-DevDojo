package com.devdojo.maratonajava.javacore.Csobrecargametodos.dominio;

public class Anime {
  private String nome;
  private String tipo;
  private int episodios;
  private String genero;

  // Sobrecarga de métodos
  public void init(String nome, String tipo, int episodios){
    this.nome = nome;
    this.tipo = tipo;
    this.episodios = episodios;
  }
  // Sobrecarga de métodos
  public void init(String nome, String tipo, int episodios, String genero){
    this.init(nome, tipo, episodios);
    this.genero = genero;
  }

  public void imprime(){
    System.out.println("Nome: " + this.nome);
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Episodios: " + this.episodios);
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
