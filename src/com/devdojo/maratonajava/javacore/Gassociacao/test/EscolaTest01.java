package com.devdojo.maratonajava.javacore.Gassociacao.test;

import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Escola;
import com.devdojo.maratonajava.javacore.Gassociacao.dominio.Professor;

public class EscolaTest01 {
  public static void main(String[] args) {
    // Associação unidirecional muitos para um
    Professor professor1 = new Professor("Jiraya Sensei");
    Professor professor2 = new Professor("Kakashi Sensei");
    Escola escola = new Escola("Konoha");
    Professor[] professores = {professor1, professor2};
    escola.setProfessores(professores);

    escola.imprime();
  }
}
