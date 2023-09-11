package com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio;

public class Estudantes {
  private String nome;
  private int idade;
  private Seminarios seminario;

  public void imprime() {
    System.out.println();
    System.out.println("------Estudante------");
    System.out.println("Nome: "+this.nome);
    System.out.println("Idade: "+this.idade);
    if(seminario == null) return;
    System.out.println("Seminario: "+seminario.getTitulo());
  }

  public Estudantes(){}
  public Estudantes(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }
  public Estudantes(String nome, int idade, Seminarios seminario) {
    this.nome = nome;
    this.idade = idade;
    this.seminario = seminario;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Seminarios getSeminario() {
    return seminario;
  }

  public void setSeminario(Seminarios seminario) {
    this.seminario = seminario;
  }
}
