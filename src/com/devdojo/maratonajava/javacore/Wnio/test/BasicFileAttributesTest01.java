package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
  public static void main(String[] args) throws IOException {
    // BasicFileAttributes foi criada para dar a possibilidade de utilizar polimorfismo baseado no sistema operacional

    // temos:
    // BasicFileAttributes
    // DosFileAttributes -> é basicamente uma implementação da BasicFileAttributes, é mais voltado para o windows
    // PosixFileAttributes -> é mais voltada para sistemas linux
    // uma coisa interessante dessas interfaces é que todos os métodos do são apenas para leitura

    // alterar atributo de um arquivo
    // alterar quando o arquivo foi modificado de uma forma antiga
    LocalDateTime date = LocalDateTime.now().minusDays(10);
    File file = new File("pasta2/novo.txt");
    boolean isCreated = file.createNewFile();
    // não podemos confiar muito nesse lastModified, não é tão confiavel
    boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());
    System.out.println(isCreated);
    System.out.println(isModified);

    // alterar quando o arquivo foi modificado de uma forma nova
    Path path = Paths.get("pasta2/novo_path.txt");
    Files.createFile(path);
    FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
    Path path1 = Files.setLastModifiedTime(path, fileTime);
    System.out.println(Files.isWritable(path)); // é gravado
    System.out.println(Files.isReadable(path)); // é lido
    System.out.println(Files.isExecutable(path)); // é executado
  }
}
