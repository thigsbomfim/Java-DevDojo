package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
  public static void main(String[] args) throws IOException {
    // o que devemos lembrar dessa aula é, tudo que contém view, como: fileAttributeView, BasicFileAttributeView
    // é utilizado para fazer alteração no que eles disponibilizam e para pegar o objeto é através
    // do Files.getAttributeView
    // e o readAttributes vai retornar o que você passar como objeto, como:
    // BasicFileAttribute.class/DosFileAttribute.class/PosixFileAttribute.class

    Path path = Paths.get("pasta2/new.txt");


    // esse atributo está dizendo, quando essa classe Files lê ou executar esse método readAttributes, o objeto que
    // tem que ser retornado é um objeto que passa do teste de: é um BasicFileAttributes?
    BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
    FileTime creationTime = basicFileAttributes.creationTime();
    FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
    FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();

    System.out.println("creationTime "+creationTime);
    System.out.println("lastAccessTime "+lastAccessTime);
    System.out.println("lastModifiedTime "+lastModifiedTime);

    System.out.println("-------------------");

    // para pegar um objeto do BasicFileAttributes
    // esse BasicFileAttributeView nos da a possibildiade de fazer alteração
    BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
    // alterando o método lastAccessTime
    FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
    // aqui estamos alterando um dos 3 métodos
    fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);


    creationTime = fileAttributeView.readAttributes().creationTime();
    lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();
    lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();

    System.out.println("creationTime "+creationTime);
    System.out.println("lastAccessTime "+lastAccessTime);
    System.out.println("lastModifiedTime "+lastModifiedTime);
  }
}
