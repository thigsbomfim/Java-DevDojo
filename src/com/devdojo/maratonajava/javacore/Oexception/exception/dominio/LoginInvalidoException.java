package com.devdojo.maratonajava.javacore.Oexception.exception.dominio;

// queremos criar uma exceção do tipo que vá fazer a pessoa obrigatoriamente criar um tratamento ou não?
// Checked ou Unchecked?
// Exception ou RuntimeException?
public class LoginInvalidoException extends Exception{
  public LoginInvalidoException() {
    super("Login inválido");
  }

  public LoginInvalidoException(String message) {
    super(message);
  }
}
