package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest01 {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("pasta/teste.txt");

    if(Files.notExists(path)) Files.createFile(path);

    // uma forma de transformar os arquivos em arquivos ocultos
    // eu quero fazer esse teste ser oculto
    // um pouco complicado de utilizar, devemos tomar cuidado ao usar, se tivermos adicionando valor no windows,
    // devemos seguir a forma exata de paramêtro
    // vamos falar o seguinte desse método:
    // o path, ou seja, o teste.txt, eu quero que seja "dos:hidden" e que o valor do oculto seja true
//    Files.setAttribute(path, "dos:hidden", true );

    //  Este atributo "readonly" torna um arquivo somente leitura
    //  Um arquivo somente leitura não pode ser modificado, renomeado ou excluído,
    //  a menos que você remova essa marcação de somente leitura
//    Files.setAttribute(path, "dos:readonly", true );
//    Files.setAttribute(path, "dos:hidden", false );
//    Files.setAttribute(path, "dos:readonly", false );
    
    
    
    // outra forma de transformar os arquivos em ocultos com DosFileAttribute
    // para verificar se é um arquivo/diretorio oculto ou um arquivo/diretorio de somente leitura
    DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
    System.out.println(dosFileAttributes.isHidden());
    System.out.println(dosFileAttributes.isReadOnly());
    DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
    // alterando para arquivos ocultos e de somente leitura
    fileAttributeView.setHidden(true);
    fileAttributeView.setReadOnly(true);

    // para verificar se é um arquivo/diretorio oculto ou um arquivo/diretorio de somente leitura
    System.out.println(fileAttributeView.readAttributes().isHidden());
    System.out.println(fileAttributeView.readAttributes().isReadOnly());


  }
}
