package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTestJavaOrClass extends SimpleFileVisitor<Path> {
  // aqui estamos chamando o FileSystems que contém o método getDefault e getPathMatcher, o getPathMatcher quer dizer
  // que se em qualquer diretório, com o nome do arquivo qualquer mas que contenha Test e com uma numeração qualquer
  // e que contenha as extensões java ou class, para mostrar apenas elas
  private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*Test*.{java,class}");

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    // aqui estamos verificando se o arquivo, contém a extensão java ou class, passando uma condição
    // chamando o método matches e passando como argumento o file/path
    if (matcher.matches(file)) {
      // e imprimindo se uma parte do nome e a extensão for a mesma
      System.out.println(file.getFileName());
    }
    // aqui estamos continuando para verificar em todos os diretórios
    return FileVisitResult.CONTINUE;
  }

}

public class PathMatcherTest02 {
  // exercicio
  public static void main(String[] args) throws IOException {
    // aqui estamos pegando o path atual
    Path path = Paths.get(".");
    // aqui estamos chamando o método walkFileTree e passando como argumento o path e a classe que extendeu a
    // SimpleFileVisitor
    Files.walkFileTree(path, new FindAllTestJavaOrClass());

  }


}
