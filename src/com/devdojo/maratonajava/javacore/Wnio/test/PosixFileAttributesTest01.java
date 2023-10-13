package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest01 {
  public static void main(String[] args) throws IOException {
    // Mais utilizado no linux
    Path path = Paths.get("/home/thiago/dev/file.txt");
    // se tentar executar no windows, ocorrerá uma exceção "UnsupportedOperationException", pois não é suportado
    PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
    // o dono pode escrever, o grupo só pode ler, o dono pode ler, e outros só podem ler
    System.out.println(posixFileAttributes.permissions()); // [OWNER_WRITE, GROUP_READ, OWNER_READ, OTHERS_READ]

    // para alterar as permissões
    PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
    // método para criar as permissões a partir de uma string
    Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("-rw-rw-rw-");
    fileAttributeView.setPermissions(posixFilePermissions);
    // ver as permissões que estão sendo alteradas
    // permissões: [OWNER_WRITE, GROUP_READ, GROUP_WRITE, OWNER_READ, OTHERS_READ, OTHERS_WRITE]
    // se digitarmos o comando ll no ubuntu, podemos observar as permissões
    System.out.println(fileAttributeView.readAttributes().permissions());

  }
}
