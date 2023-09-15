package com.devdojo.maratonajava.javacore.Minterfaces.dominio;

import com.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.DataRemover;

public class FileLoader implements DataLoader, DataRemover {

  @Override
  public void load() {
    System.out.println("Carregando dados de um arquivo");
  }

  @Override
  public void remove() {
    System.out.println("Deletando dados de um arquivo");
  }

  @Override
  public void checkPermission() {
    System.out.println("Checando permissões no arquivo");
  }
}
