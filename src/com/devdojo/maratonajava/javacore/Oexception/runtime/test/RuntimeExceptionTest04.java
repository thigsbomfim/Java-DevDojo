package com.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
  public static void main(String[] args) {
    try {
      // nesse caso, RuntimeException não é uma exceção que está sendo tratada no catch
      // para resolver, colocariamos outro bloco catch no final capturando o RuntimeException
      // cairia no mais genérico que é o pai de todos, a exceção RuntimeException
      // Temos algumas regras, a primeira é que nós não podemos colocar um tipo mais genérico a frente dos outros catchs
      // por que quando temos o RuntimeException, temos o tipo mais genérico, todas os catchs abaixo, são filhas da
      // RuntimeException
      // Exceções mais genéricas, sempre tem que vir no final, por que se vier em primeiro, a referencia vai para ela
      // e não para a que queremos capturar
      throw new RuntimeException();

    // tendo varios tratamentos de catch, irá buscar sempre a exceção que satisfaz a exceção que nosso codigo deu,
    // quando não tivermos o catch correto com a exceção que está acontecendo no nosso codigo, o sistema irá cair
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Dentro do ArrayIndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException e){
      System.out.println("Dentro do IndexOutOfBoundsException");
    } catch (IllegalArgumentException e){
      System.out.println("Dentro do IllegalArgumentException");
    } catch (ArithmeticException e) {
      System.out.println("Dentro do ArithmeticException");
    } catch (RuntimeException e) {
      System.out.println("Dentro do RuntimeException");
    }

    try {
      throw new ArrayIndexOutOfBoundsException();

    // maneira simples de fazer multiplas capturas de exceções em algums catchs que não são da mesma linha de herança
    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e){
      System.out.println("Dentro do ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException");
    } catch (RuntimeException e) {
      System.out.println("Dentro do RuntimeException");
    }

    // sintaxe para pegar dois as duas exceções em apenas um catch, foi feita para melhorar a legibilidade do codigo
    // mas lembrando que não podemos fazer isso quando temos classes de exceções da mesma linha de herança, ou é pai
    // ou é filho

    /*
    try {
      talvezLanceException();
    } catch (SQLException | FileNotFoundException | IOException e) {

    }
    ERRO DE COMPILAÇÃO, POIS IOException faz parte da mesma linha de herança do SQLException
    */

    try {
      talvezLanceException();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  private static void talvezLanceException() throws SQLException, IOException {

  }
}
