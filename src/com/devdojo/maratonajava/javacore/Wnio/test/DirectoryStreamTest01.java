package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
  public static void main(String[] args) {
    // "." pega o diretorio atual
    Path dir = Paths.get(".");
    // basicamente, o DirectoryStream irá pegar cada diretório/arquivo que temos e associar ao nosso path
    // Files.newDirectoryStream pede um caminho inicial que estamos passando que é o dir
    try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
      for (Path path : stream) {
        // pega todos os arquivos, incluindo os arquivos ocultos
        System.out.println(path.getFileName());
      }
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}
