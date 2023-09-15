package com.devdojo.maratonajava.javacore.Minterfaces.test;

import com.devdojo.maratonajava.javacore.Minterfaces.dominio.DataLoader;
import com.devdojo.maratonajava.javacore.Minterfaces.dominio.DatabaseLoader;
import com.devdojo.maratonajava.javacore.Minterfaces.dominio.FileLoader;

public class DataLoaderTest01 {
  public static void main(String[] args) {
    // não podemos instânciar objetos de interfaces
    // DataLoader dataLoader = new Dataloader(); // erro de compilação
    DatabaseLoader databaseLoader = new DatabaseLoader();
    FileLoader fileLoader = new FileLoader();
    databaseLoader.load();
    fileLoader.load();

    databaseLoader.remove();
    fileLoader.remove();

    databaseLoader.checkPermission();
    fileLoader.checkPermission();

    DataLoader.retrieveMaxDataSize();
    DatabaseLoader.retrieveMaxDataSize();
  }
}
