package com.devdojo.maratonajava.javacore.Oexception.exception.test;

import com.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor1;
import com.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
  public static void main(String[] args) {
    lerArquivo();
  }

  public static void lerArquivo() {
    // esse try com recursos está se encarregando de tomar conta de fechar a conexão dessa variavel de referencia
    // Devemos seguir uma regra, só podemos colocar objetos/variaveis de referencia dentro do tryWithResources e
    // fazer o Reader implementar a interface Closeable e o Closeable é um AutoCloseable
    // quando estamos trabalhando com o TryWithResources, podemos retirar o bloco catch, mas teremos que implementar
    // o throws na criação do método
    // Eles são fechados na ordem inversa do que foram criados, ex.: serão fechados o Leitor2 e depois o Leitor1
    try (Leitor1 leitor1 = new Leitor1();
         Leitor2 leitor2 = new Leitor2()) {

    } catch (IOException e) {

    }
  }

  // maneira antiga de fazer um método para ler um arquivo
  public static void lerArquivo2() {
    // class Reader responsavel para trabalhar com leitura de arquivos
    Reader reader = null;

    try {
      reader = new BufferedReader(new FileReader("teste.txt"));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
