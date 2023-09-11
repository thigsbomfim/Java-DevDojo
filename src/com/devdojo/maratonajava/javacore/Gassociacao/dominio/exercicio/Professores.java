package com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio;

public class Professores {
  private String nome;
  private String especialidade;
  private Seminarios[] seminarios;

  public void imprime() {
    System.out.println();
    System.out.println("------Professores------");
    System.out.println("Nome: "+this.nome);
    System.out.println("Especialidade: "+this.especialidade);
    System.out.print("Seminarios: ");
    if(seminarios == null || seminarios.length == 0) System.out.println("Não existe seminários");
    else for(Seminarios seminario: seminarios) System.out.print(seminario.getTitulo() + ", ");
    System.out.println();
  }

  public Professores(String nome, String especialidade) {
    this.nome = nome;
    this.especialidade = especialidade;
  }

  public Professores(String nome, String especialidade, Seminarios[] seminario) {
    this.nome = nome;
    this.especialidade = especialidade;
    this.seminarios = seminario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  public Seminarios[] getSeminarios() {
    return seminarios;
  }

  public void setSeminarios(Seminarios[] seminarios) {
    this.seminarios = seminarios;
  }
}
