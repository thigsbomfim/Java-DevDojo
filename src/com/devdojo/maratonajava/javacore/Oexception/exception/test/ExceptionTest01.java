package com.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
  public static void main(String[] args) {
    criarNovoArquivo();
  }

  private static void criarNovoArquivo(){
    File file = new File("arquivo\\teste.txt");

    // o java força para fazer uma tratativa
    try{
      boolean isCriado = file.createNewFile();
      System.out.println("Arquivo criado: "+isCriado);

      // capturar a exceção genérica nem sempre é apropriado (Exception)
      // nesse caso em especifico, queremos capturar a exceção específica (IOException
      // Unchecked
    }catch(IOException e){
      // não é apropriado deixar esse bloco em branco
      // evitar colocar regras de negócios no catch
      // printStackTrace lê todas as exceções, se esse código tiver uma exceção, ele irá buscar no método main,
      // se no método main não tiver uma tratativa, ele irá descer para a tratativa createNewFile, e ass sucessivamente
      // até algum objeto ter uma tratativa
      e.printStackTrace();
    }
  }
}
