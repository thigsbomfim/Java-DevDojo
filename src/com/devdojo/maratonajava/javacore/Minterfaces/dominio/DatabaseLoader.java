package com.devdojo.maratonajava.javacore.Minterfaces.dominio;

import com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.DataRemover;

// quando estamos trabalhando com interfaces, não usamos mais extends para herdar a classe e sim implements
// ao contrario de classes, que não podem extender mais de uma classe, ja com interface é diferente.
// as interfaces podem prover de multiplas interfaces, dessa forma abaixo
public class DatabaseLoader implements DataLoader, DataRemover {
  // private -> default -> protected -> public
  @Override
  public void load() {
    System.out.println("Carregando dados do banco de dados");
  }

  @Override
  public void remove() {
    System.out.println("Removendo dados do banco de dados");
  }

  @Override
  public void checkPermission() {
    System.out.println("Checando permissões no banco de dados");
  }

  public static void retrieveMaxDataSize(){
    System.out.println("Dentro do retrieveMaxDataSize na classe DatabaseLoader");
  }
}
