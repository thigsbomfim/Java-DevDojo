package com.devdojo.maratonajava.javacore.Oexception.exception.test;

import com.devdojo.maratonajava.javacore.Oexception.exception.dominio.LoginInvalidoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
  public static void main(String[] args) {
    try {
      logar();
    } catch (LoginInvalidoException e) {
      e.printStackTrace();
    }
  }

  private static void logar() throws LoginInvalidoException{
    String usernameDB = "Goku";
    String senhaDB = "ssj";
    Scanner teclado = new Scanner(System.in);
    System.out.println("Usuário");
    String usernameDigitado = teclado.nextLine();
    System.out.println("Senha");
    String senhaDigitada = teclado.nextLine();
    if(!usernameDB.equals(usernameDigitado) || senhaDB.equals(senhaDigitada)) {
      throw new LoginInvalidoException("Usuario ou senha inválidos");
    }

    System.out.println("Usuário logado com sucesso");
  }
}
