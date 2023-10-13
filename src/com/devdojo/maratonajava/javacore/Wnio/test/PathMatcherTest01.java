package com.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
  public static void main(String[] args) {
    Path path1 = Paths.get("pasta/subpasta/file.bkp");
    Path path2 = Paths.get("pasta/subpasta/file.txt");
    Path path3 = Paths.get("pasta/subpasta/file.java");

    // passando somente um asterisco, ele desconsidera os diretorios, ou seja, se quiser considerar os diretórios
    matches(path1, "glob:*.bkp");
    // considerando diretórios
    matches(path1, "glob:**.bkp");
    // podemos utilizar assim também, que irá ignorar tudo que tiver para trás, incluindo diretórios
    matches(path1, "glob:**/*.bkp");

    // se quisermos agora pegar tudo que tenha .bkp, tudo que tenha .txt, e tudo que tenha .java
    // não pode colocar espaço entre as extensões do arquivo, exemplo {bkp, txt, java}, ele irá dar false se fizer isso
    // existe uma extensão bkp ou txt ou java nesse path1
    matches(path1, "glob:**/*.{bkp,txt,java}");

    // existe uma extensão bkp ou txt ou java nesse path2
    matches(path2, "glob:**/*.{bkp,txt,java}");

    // existe uma extensão bkp ou txt ou java nesse path3
    matches(path3, "glob:**/*.{bkp,txt,java}");

    // podemos também verificar se os arquivos tem 3 letras na extensão
    // eu não me importo com o diretório, não me importo com o nome, mas eu quero que tenha 3 letras a extensão
    matches(path3, "glob:**/*.???"); // false

    // agora, estamos dizendo que queremos que o nome seja file, e termine com 3 letras a extensão
    matches(path3, "glob:**/file.????"); // false

  }

  private static void matches(Path path, String glob) {
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
    System.out.println(glob + ": " + matcher.matches(path));
  }
}
