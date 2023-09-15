package com.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {

  public static void main(String[] args) {
    // aqui estamos fazendo um tratamento de uma exceção, se não fizermos um tratamento de exceções, o código não
    // irá mais ser executado
    // esse try/catch abaixo está tratando, caso não tivessemos, a linha 15 não executaria.
    try {
      divisao(1, 0);
    }catch (RuntimeException e){
      e.printStackTrace();
    }
    // divisao(1, 0);
    System.out.println("Código finalizado");
  }

  // podemos colocar a exceção diretamente no método para avisar quem for usar o método que esse método pode capturar
  // uma exceção
  // existe a possibilidade de ter uma exceção do tipo unchecked, queira você tratar essa exceção ou não.
  // Se for uma exceção do tipo checked, teremos que tratar obrigatoriamente no proprio método ou
  // podemos passar o tratamento para quem está chamando o método, o limite é até o método main
  // podemos também criar uma documentação para esse método, ficaria assim:

  /**
   * @param a
   * @param b não pode ser zero
   * @return
   * @throws IllegalArgumentException
   * */
  private static int divisao(int a, int b) throws IllegalArgumentException{
    // usando um if, não precisamos criar um bloco de try/catch
    // usando o throw new estaremos lançando uma exceção, e geralmente será do tipo RuntimeException(unchecked)
    // também podem ser do tipo checked
    /*
      quando estamos trabalhando com throw new e for do tipo RuntimeException, não existe necessidade
      de colocar na assinatura do método um aviso para quem está chamando, falando que esse método está lançando uma
      exceção.
      Mas é obrigatório quando as exceções são do tipo checked, são filhas de Exception
    */
    if(b == 0) throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");

    return a/b;
  }
}
