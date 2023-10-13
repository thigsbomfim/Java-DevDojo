package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


// Lista tudo que temos no nosso diretorio
class ListJavaFiles extends SimpleFileVisitor<Path> {
  // aqui estamos sobrescrevendo um método
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    // endsWith, pega a extensão do arquivo
    if(file.getFileName().toString().endsWith(".java")) {
      System.out.println(file.getFileName());
    }
    // esse FileVisitResult.CONTINUE simplesmente continua o codigo ao encontrar um novo arquivo/diretorio
    return FileVisitResult.CONTINUE;
  }
}

public class SimpleFileVisitorTest01 {
  public static void main(String[] args) throws IOException {
    Path root = Paths.get(".");

    // o que esse walkFileTree está dizendo é que ele precisa de um path para começar, e o FileVisitor, que define o
    // comportamento que você quer fazer quando está navegando por esses diretorios
    Files.walkFileTree(root, new ListJavaFiles());
  }
}
