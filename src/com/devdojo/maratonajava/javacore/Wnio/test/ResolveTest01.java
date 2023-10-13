package com.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
  public static void main(String[] args) {
    /*
    "home/thiago"
    isso é caminho relativo, pois quando não colocamos a 1° barra inicial estamos falando que antes disso,
    quem quer que seja nesse caso o sistema operacional ou o programa java tem que considerar como se o caminho
    anterior fosse a localização aonde esse path se encontra

    "/home/thiago"
    isso é um caminho absoluto
    se colocar uma barra atrás do home, estamos falando que ele tem que ir do root/raiz do sistema operacional
     */
    Path dir = Paths.get("home/thiago"); // caminho relativo
    // dentro do nosso root/raiz do projeto maratona-java não existe nenhum diretorio dev, precisamos resolver esse path
    Path arquivo = Paths.get("dev/arquivo.txt");
    // resolvendo
    Path resolve = dir.resolve(arquivo);
    System.out.println(resolve); // home\thiago\dev\arquivo.txt


    // outro exemplo
    // digamos que nos temos o seguinte path
    Path absoluto = Paths.get("/home/thiago");
    Path relativo = Paths.get("dev");
    // esse file também é relativo, para se tornar absoluto basta colocar a "/" na frente
    Path file = Paths.get("file.txt");

    System.out.println("1 "+absoluto.resolve(relativo));
    System.out.println("2 "+absoluto.resolve(file));
    // quando tentamos fazer uma resolução com um path ja absoluto, ele simplesmente retorna o absoluto "\home\thiago"
    // por que não tem nada para resolver
    System.out.println("3 "+relativo.resolve(absoluto));
    // no segundo caso, ele funcionou, ele resolveu, adicionou um file.txt no diretorio
    // não podemos adicionar de um relativo para absoluto
    System.out.println("4 "+relativo.resolve(file));

    // nesse exemplo, ele também não resolveu pq ele ja é um caminho absoluto
    System.out.println("5 "+file.resolve(absoluto));
    System.out.println("6 "+file.resolve(relativo));

  }
}
