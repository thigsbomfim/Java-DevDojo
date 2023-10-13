package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
  public static void main(String[] args) {
    File fileDiretorio = new File("pasta");

    try {
      // método mkdir cria um novo diretorio
      boolean isDiretorioCriado = fileDiretorio.mkdir();
      System.out.println("pasta criada? "+isDiretorioCriado);

      // estamos passando a referencia do diretório como primeiro argumento
      // e no segundo argumento inserimos o nome do arquivo
      File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");

      // método createNewFile para criar um arquivo
      boolean isFileCreated = fileArquivoDiretorio.createNewFile();
      System.out.println("arquivo.txt foi criado? "+isFileCreated);

      // renomeando esse arquivo
      // estou criando um novo objeto, esse objeto será um objeto de destino, estou dizendo para renomear
      // objeto fileArquivoDiretorio, ou seja, o arquivo.txt do fileDiretorio, para o arquivo_renomeado criado abaixo
      File fileRenamed = new File(fileDiretorio, "arquivo_renomeado.txt");
      boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
      System.out.println("arquivo.txt renomeado? "+isRenamed);


      // para renomear diretorio, é da mesma forma que renomeamos um arquivo
      File diretorioRenamed = new File("pasta2");
      boolean isDiretorioRenamed = fileDiretorio.renameTo(diretorioRenamed);
      System.out.println("pasta renomeada? "+isDiretorioRenamed);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
