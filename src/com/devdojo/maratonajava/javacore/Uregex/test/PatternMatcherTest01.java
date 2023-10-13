package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
  public static void main(String[] args) {
    String regex = "aba";
    // String texto = "abaaba";
    String texto2 = "abababa";
    // classe para trabalhar com regex no java, Pattern que é a padrão e a matcher que encontra aquele padrão
    Pattern pattern = Pattern.compile(regex);
    // no texto2, está sendo buscada a palavra aba, quando executarmos o match, irá mostrar apenas dois indices
    // 0 e 4, pois na variavel texto2 "abababa" ela só percorre a variavel completamente apenas 1 vez
    // então irá percorrer até dar match com a variavel regex
    // estamos verificando a variavel texto2 "abababa", ficaria dessa forma:
    //  012  -> indices
    // "aba" -> match com a variavel regex, então temos o match apartir do indice 0
    // percorre novamente e:
    //  3  -> indice
    // "b" -> não da match, então pula
    //  456  -> indices
    // "aba" -> match com a variavel regex "aba", então temos o match apartir do indice 4
    Matcher matcher = pattern.matcher(texto2);
    System.out.println("texto: "+ texto2);
    System.out.println("indice: 0123456789");
    System.out.println("regex: "+regex);
    System.out.println("Posições encontradas");

    // find() verifica a string de entrada em busca da próxima correspondência que atende à expressão regular
    while(matcher.find()) {
      // método start busca o indice do match
      System.out.print(matcher.start()+" ");
    }
  }
}
