package com.devdojo.maratonajava.javacore.Oexception.error.test;

// Error é algo que acontece na JVM e provavelmente não podemos recuperar em tempo de execução
// A solução desse problema abaixo, é arrumar o código
// ou melhorar a forma que esse codigo vai parar ou tirar a recursividade
public class StackOverflowTest01 {

  public static void main(String[] args) {
    // recursividade();
  }

  public static void recursividade(){
    recursividade();
  }
}
