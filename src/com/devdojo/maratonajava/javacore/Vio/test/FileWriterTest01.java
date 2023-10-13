package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// File
// FileWriter
// FileReader
// BufferedWriter
// BufferedReader
public class FileWriterTest01 {
  public static void main(String[] args) {
    File file = new File("file.txt");
    // para criar sempre um novo texto, no arquivo, ao invés de alterar o que ja está escrito, basta colocar
    // como segundo argumento do construtor, um boolean, true para adicionar sempre um novo texto ao invés de alterar
    try (FileWriter fw = new FileWriter(file,true )){
      // dessa forma, estamos adicionando um texto, e ao executar sempre o codigo novamente, ele modifica o texto
      fw.write("O DevDojo é o melhor curso do Brasilllllll\nContinuando a cantoria na próxima linha\n");
      // antes de fechar um arquivo, antes de terminar o método, chamamos o flush
      // que basicamente é: cospe tudo tudo que você tem dentro do seu Buffered, que depois quando o método acabar
      // o próprio java vai chamar o close do fileWriter
      fw.flush();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
}
