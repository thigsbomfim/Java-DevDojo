package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
  public static void main(String[] args) {
    File file = new File("file.txt");
    try (FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr)){

      String linha;
      while((linha=br.readLine()) != null) {
        System.out.println(linha);
      }
      // le linha por linha
      // em questões de performance, é melhor ler uma linha inteira do que ler caracter por caracter usando read()
      // retorna null quando chega no final da linha
//      br.readLine();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
