package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
  public static void main(String[] args) {
    String texto = "Levi,Eren,Mikasa,true,200";
    // por padrão, a scanner recebe varias opções no construtor, mas nesse caso, queremos uma String
    // a scanner tem um delimitador padrão, que é um espaço em branco " "
    // queremos usar outro delimitador, podemos usar o método useDelimiter() que recebe o delimitador que queremos
    Scanner scanner = new Scanner(texto);
    scanner.useDelimiter(",");
    // enquanto existir um próximo, exemplo, "Levi,Eren", existe um proximo depois do delimitador que é o Eren,
    // enquanto existir um proximo hasNext();
    while(scanner.hasNext()) {
      // eu quero que você pegue o proximo next();
//      System.out.println(scanner.next());

      // para pegar os valores de acordo com o tipo dele
      if(scanner.hasNextInt()) {
        int i = scanner.nextInt();
        System.out.println("Int "+i);
      } else if(scanner.hasNextBoolean()) {
        boolean b = scanner.nextBoolean();
        System.out.println("Boolean "+b);
      } else {
        System.out.println(scanner.next());
      }

    }

  }
}
