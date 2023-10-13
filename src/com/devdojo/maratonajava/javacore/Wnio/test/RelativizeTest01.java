package com.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
  public static void main(String[] args) {
    Path dir = Paths.get("/home/thiago");// caminho absoluto
    // digamos que eu quero saber, dado o meu diretorio, como eu faço para chegar nessa classe
    // como eu faço para chegar onde esse olaMundo se encontra
    Path clazz = Paths.get("/home/thiago/devdojofoda/OlaMundo.java");
    // como eu chego no OlaMundo.java?
    Path pathToClazz = dir.relativize(clazz);
    // ele mostra p gente para qual pasta devemos navegar para chegar no arquivo
    // como eu ja estou dentro do caminho, é basicamente o mesmo caminho, basicamente é o mesmo diretorio
    // só precisamos ir mais p frente
    // basicamente é assim que funciona
    System.out.println(pathToClazz); // devdojofoda\OlaMundo.java

    // mas também podemos pensar nos casos que não são tão claros
    Path absoluto1 = Paths.get("/home/thiago");
    Path absoluto2 = Paths.get("/usr/local");
    Path absoluto3 = Paths.get("/home/thiago/devdojofoda/OlaMundo.java");
    Path relativo1 = Paths.get("temp");
    Path relativo2 = Paths.get("temp/temp.20231007");

    System.out.println("1 "+absoluto1.relativize(absoluto3)); // devdojofoda\OlaMundo.java

    // caminho inverso, ou seja, devemos voltar 2 diretorios para chegar no absoluto1 "/home/thiago"
    System.out.println("2 "+absoluto3.relativize(absoluto1)); // ..\..

    // digamos que tenho o absoluto1 e quero chegar no absoluto2
    // nesse caso, se voltarmos 2 a partir do absoluto1, vamos chegar na raiz, e da raiz do SO, podemos mudar
    // para o absoluto2
    // ele faz isso:
    // \absoluto1
    // ..\..\absoluto1
    // \absoluto2

    // /home/thiago
    // ..\..\home\thiago
    // \ usr\local
    System.out.println("3 "+absoluto1.relativize(absoluto2)); // ..\..\ usr\local

    // com relativos, esse resultado quer dizer, ja que você está dentro da pasta, basta pegar o nome do arquivo
    System.out.println("4 "+relativo1.relativize(relativo2)); // temp.20231007

    // uma coisa que devemos ter cuidado, é ao trabalhar com relativo e absoluto
    // digamos que estou no absoluto 1 e quero chegar no relativo1, o java não faz ideia de onde esse temp está
    // o java não consegue encontrar, ele fala, beleza, vamos voltar la para raiz, mas pra onde eu vou?
    // pois não tem informação
    // ele lança uma exceção, pq ele não sabe como chegar nesse temp, pq esse é um caminho relativo de onde esse
    // programa está sendo executado
    System.out.println("5 "+absoluto1.relativize(relativo1)); //  'other' is different type of Path






  }
}
