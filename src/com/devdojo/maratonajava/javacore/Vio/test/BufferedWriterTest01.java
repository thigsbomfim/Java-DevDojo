package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
  public static void main(String[] args) {
    File file = new File("file.txt");
    // Um BufferedWriter recebe um FileWriter no seu construtor e um size(tamanho)
    // BufferedWriter encapsula o FileWriter, foi criada para ter a melhor performance que utiliza dados em memoria
    // aqui estamos o try resources para fechar automaticamente quando acabar de executar o código
    try (FileWriter fw = new FileWriter(file,true );
         BufferedWriter bw = new BufferedWriter(fw, 2048)) {

      bw.write("O DevDojo é o melhor curso do Brasilllllll");
      // newLine() serve para pular linha baseado no sistema operacional, nem todos utilizam o \n para quebrar linhas
      bw.newLine();
      // usando BufferedWriter também é necessario usar o flush, como no FileWriter
      bw.flush();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
}
