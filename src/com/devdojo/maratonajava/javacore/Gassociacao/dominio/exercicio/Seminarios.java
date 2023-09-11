package com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio;
public class Seminarios {
  private String titulo;
  private Estudantes[] estudantes;
  private Professores professor;
  private Local local;

  public void imprime() {
    System.out.println();
    System.out.println("------Seminario------");
    System.out.println("Titulo: "+this.titulo);
    System.out.println("Local: "+local.getEndereco());
    if(professor != null) System.out.println("Professor: "+professor.getNome());
    System.out.print("Estudante: ");
    if(estudantes == null || estudantes.length == 0) System.out.println("Não existe alunos");
    else for (Estudantes estudante : estudantes) System.out.print(estudante.getNome() + ", ");
    System.out.println();
  }

  public Seminarios(String titulo, Local local) {
      this.titulo = titulo;
      this.local = local;
  }

  public Seminarios(String titulo, Estudantes[] estudantes, Professores professor, Local local) {
    this.titulo = titulo;
    this.estudantes = estudantes;
    this.professor = professor;
    this.local = local;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Estudantes[] getEstudantes() {
    return estudantes;
  }

  public void setEstudantes(Estudantes[] estudantes) {
    this.estudantes = estudantes;
  }

  public Professores getProfessor() {
    return professor;
  }

  public void setProfessor(Professores professor) {
    this.professor = professor;
  }

  public Local getLocal() {
    return local;
  }

  public void setLocal(Local local) {
    this.local = local;
  }
}
