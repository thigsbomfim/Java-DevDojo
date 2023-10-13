package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathTest02 {
  public static void main(String[] args) throws IOException {
    // pega a pasta
    // aqui estamos pegando apenas de um diretório, que não contém subdiretórios
    Path pastaPath = Paths.get("pasta");
    // cria um diretório se não existir

    if(Files.notExists(pastaPath)) {
      Path pastaDirectory = Files.createDirectory(pastaPath);
    }

    // essa subpasta não existe e a subsubpasta também não
    Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
    // para criar, basta usar
    Path subPastaDirectory = Files.createDirectories(subPastaPath);

    // primeiro argumento é o caminho da subPastaPath e o segundo argumento é o nome do arquivo
    Path filePath = Paths.get(subPastaPath.toString(), "file.txt");

    // essa condição, vê se tem algum arquivo com esse nome
    if(Files.notExists(filePath)){
      // para criar um arquivo
      Path filePathCreated = Files.createFile(filePath);
    }


    // para renomear e criar para um novo arquivo
    Path source = filePath;
    // getParent retorna o caminho em que está localizado o filePath
    Path target = Paths.get(filePath.getParent().toString(), "file_renamed");
    // copia e renomeia o arquivo
    // o primeiro argumento é o path do arquivo, o segundo é o nome do novo arquivo que vai ser renomeado
    // podemos passar um terceiro argumento para pegar o conteúdo do arquivo file.txt

    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
  }
}
