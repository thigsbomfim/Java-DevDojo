package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
  public static void main(String[] args) {
    File file = new File("file.txt");
    try (FileReader fr = new FileReader(file)){
      char[] in = new char[165];
      // fr.read() retorna um integer, esse integer, representa o primeiro caracter do nosso arquivo 79 na tabela ASCII
      // o read recebendo o array in, serve para ler a quantidade de caracteres que contém dentro do arquivo
      // pega 165 posições do arquivo
      int size = fr.read(in);
      System.out.println(size);
      for (char c : in) {
        System.out.print(c);
      }

      // estou criando uma variavel
      int i;
      // essa variavel recebe o valor ASCII, da letra que tem na primeira posição, se for diferente de -1, vai imprimir
      // e vai continuar lendo, vai ler posição por posição, e quando chega no final do arquivo e não tem mais nada,
      // ele retorna -1
      // enquanto i for diferente de -1, quero que itere de posição em posição
      while((i=fr.read()) != -1){
        System.out.print((char)i);
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
