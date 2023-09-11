package com.devdojo.maratonajava.javacore.Gassociacao.test.exercicio;

import com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio.Estudantes;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio.Local;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio.Professores;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.exercicio.Seminarios;

public class SeminariosTest01 {
  public static void main(String[] args) {
    // locais
    Local local1 = new Local("Aldeia da folha");
    Local local2 = new Local("Aldeia da areia");

    // alunos
    Estudantes aluno1 = new Estudantes("Naruto", 12);
    Estudantes aluno2 = new Estudantes("Sasuke", 13);
    Estudantes aluno3 = new Estudantes("Sakura", 11);

    // professores
    Professores prof1 = new Professores("Kakashi", "Chidori");
    Professores prof2 = new Professores("Jiraya", "Rasengan");

    // seminários
    Seminarios seminario1 = new Seminarios("Exame chunnin", local1);
    Seminarios seminario2 = new Seminarios("Exame gennin", local2);



    // criando um array de seminarios para professores
    Seminarios[] seminariosDoProfessor1 = {seminario2, seminario1};
    Seminarios[] seminariosDoProfessor2 = {seminario2};

    // criando um array de estudantes para seminarios
    Estudantes[] alunosKakashi = {aluno2, aluno3};
    Estudantes[] alunosJiraya = {aluno1};

    // adicionando seminarios na classe Professores
    prof1.setSeminarios(seminariosDoProfessor1);
    prof2.setSeminarios(seminariosDoProfessor2);

    // adicionando seminarios na classe Estudantes
    aluno1.setSeminario(seminario2);
    aluno2.setSeminario(seminario1);
    aluno3.setSeminario(seminario1);

    // Adicionando professor em um seminário
    seminario1.setProfessor(prof1);
    seminario2.setProfessor(prof2);

    // adicionando estudantes em um seminario
    seminario1.setEstudantes(alunosKakashi);
    seminario2.setEstudantes(alunosJiraya);



    // imprime classe Seminarios
    seminario1.imprime();
    seminario2.imprime();

    // imprime classe Estudantes
    aluno1.imprime();
    aluno2.imprime();
    aluno3.imprime();

    // imprime classe Professores
    prof1.imprime();
    prof2.imprime();
  }
}
