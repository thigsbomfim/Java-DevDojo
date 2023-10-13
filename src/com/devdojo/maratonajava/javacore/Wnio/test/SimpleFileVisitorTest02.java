package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


// Lista tudo que temos no nosso diretorio
class ListAllFiles extends SimpleFileVisitor<Path> {
  // aqui estamos sobrescrevendo um método
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
      System.out.println(file.getFileName());
    // esse FileVisitResult.CONTINUE simplesmente continua o codigo ao encontrar um novo arquivo/diretorio
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    // é invocado, quando entra em um diretório, quando ele entrar nos diretórios, ele vai imprimir
    // antes de ele entrar, ele imprime, mas não é um comportamento garantido
    System.out.println("pre visit - " + dir.getFileName());
    // esse FileVisitResult.CONTINUE simplesmente continua o codigo ao encontrar um novo arquivo/diretorio
    return FileVisitResult.CONTINUE;
    // se colocarmos, FileVisitResult.SKIP_SUBTREE, ele irá dar um skip em tudo que tem dentro da pasta
    // se colocarmos, FileVisitResult.SKIP_SIBLINGS, tem o mesmo comportamento do SKIP_SUBTREE, quando estamos
    // trabalhando com diretórios
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    // se ele tentar ler um arquivo, que não tiver permissão de leitura por exemplo, qualquer tipo de problema quando
    // você for pegar aquele arquivo, ele irá lançar essa exceção, ai podemos usar o visitFileFailed para exibir
    // colocar um log, entrei no arquivo tal e no diretorio tal e falhou
    return super.visitFileFailed(file, exc);
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    // é basicamente ao contrario do preVisitDirectory
    // o postVisitDirectory é exibido quando você está saindo do arquivo/diretório
    System.out.println("post visit - " + dir.getFileName());
    // SKIP_SIBLINGS E SKIP_SUBTREE não funcionam no postVisitDirectory
    return FileVisitResult.CONTINUE;
  }
}

public class SimpleFileVisitorTest02 {
  public static void main(String[] args) throws IOException {
    Path root = Paths.get("pasta");

    // o que esse walkFileTree está dizendo é que ele precisa de um path para começar, e o FileVisitor, que define o
    // comportamento que você quer fazer quando está navegando por esses diretorios
    Files.walkFileTree(root, new ListAllFiles());
  }
}
