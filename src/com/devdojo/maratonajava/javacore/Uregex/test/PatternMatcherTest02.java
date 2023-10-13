package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
  public static void main(String[] args) {
    // "\d" -> d minusculo, retorna todos os digitos numéricos
    // "\D" -> D maiúsculo, retorna tudo que não for digito numérico, incluindo caracteres especiais
    // "\s" -> s minúsculo, retorna todos os espaços em branco, espaços em branco q são representados por: \t \r \n \f
    // "\S" -> S maiúsculo, retorna todos os caracteres, excluindo os espaços em branco
    // "\w" -> w minúsculo, retorna tudo todas as letras a-z ou A-Z, todos os digitos numéricos e tb underline "_"
    // "\W" -> W maiúsculo, retorna tudo que não for letras, digitos numéricos e underline "_"
    // para poder utilizar a contrabarra, é preciso colocar outra contrabarra pois ela é um caracter de escape
    String regex = "\\W";
    // String texto = "abaaba";
    String texto2 = "@#hh_j2 12gvh21";

    // classe para trabalhar com regex no java, Pattern que é a padrão e a matcher que encontra aquele padrão
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(texto2);
    System.out.println("texto: "+ texto2);
    System.out.println("indice: 0123456789");
    System.out.println("regex: "+regex);
    System.out.println("Posições encontradas");

    // find() verifica a string de entrada em busca da próxima correspondência que atende à expressão regular
    while(matcher.find()) {
      // método start busca o indice do match
      // método group serve para mostrar o que foi encontrado
      System.out.print("indice: "+matcher.start()+" valor: "+matcher.group()+"\n");
    }
  }
}
