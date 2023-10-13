package com.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
  public static void main(String[] args) {
    // aqui temos um diretorio home outro diretorio thiago que está dentro do home e outro dev que está dentro do thiago
    // estamos querendo acessar o arquivo.txt que está dentro do diretorio home
    // para isso, precisamos normalizar nosso path
    String diretorioProjeto = "home/thiago/dev";
    String arquivoTxt = "../../arquivo.txt";
    Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
    // path sem estar normalizado
    System.out.println(path1); // home\thiago\dev\..\..\arquivo.txt
    // para mostrar o path normalizado
    // foi normalizado para mostrar onde o arquivo está localizado, mas não significa que o arquivo exista
    // ele só normaliza
    System.out.println(path1.normalize()); // home\arquivo.txt

    // outra forma que temos de acessar um diretorio
    // no primeiro "./", estamos dizendo que queremos acessar o diretorio do thiago o segundo "./" quer dizer que
    // estamos querendo acessar o diretorio dev
    // é a mesma coisa que se eu executar /home/thiago/dev/
    Path path2 = Paths.get("/home/./thiago/./dev/");
    System.out.println(path2); // \home\.\thiago\.\dev
    System.out.println(path2.normalize()); // \home\thiago\dev
  }
}
