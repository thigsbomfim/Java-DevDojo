package com.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

import java.util.Arrays;

public class Funcionario {
  private String nome;
  private int idade;
  private double[] salarios;
  private double media;

  public void imprime() {
    System.out.println("O nome do seu funcionário é: " + this.nome);
    System.out.println("A idade do seu funcionário é: " + this.idade);
    if(salarios == null) return;
    for(double salario : salarios){
      System.out.print(salario + " ");
    }
    this.imprimeMediaSalarial();
  }


  public void imprimeMediaSalarial(){
    if(salarios == null) return;
    for(double salario: salarios){
      media+=salario;
    }
    media /= salarios.length;
    System.out.println("\nMédia salarial é: " + media);
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

  public double[] getSalarios() {
    return salarios;
  }

  public void setSalarios(double... salarios) {
    this.salarios = salarios;
  }

  public double getMedia() {
    return media;
  }
}
