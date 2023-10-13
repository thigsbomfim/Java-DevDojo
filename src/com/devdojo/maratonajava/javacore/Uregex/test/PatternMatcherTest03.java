package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
  public static void main(String[] args) {
    // "\d" -> d minusculo, retorna todos os digitos numéricos
    // "\D" -> D maiúsculo, retorna tudo que não for digito numérico, incluindo caracteres especiais
    // "\s" -> s minúsculo, retorna todos os espaços em branco, espaços em branco q são representados por: \t \r \n \f
    // "\S" -> S maiúsculo, retorna todos os caracteres, excluindo os espaços em branco
    // "\w" -> w minúsculo, retorna tudo todas as letras a-z ou A-Z, todos os digitos numéricos e tb underline "_"
    // "\W" -> W maiúsculo, retorna tudo que não for letras, digitos numéricos e underline "_"
    // [] -> representa o range, procura o caracter que é passado dentro dele
    // [abc] -> irá retornar todas as letras que são iguais a "abc" e seus indices
    // [a-c] -> irá retornar caracteres de "a" até "c"

    // para poder utilizar a contrabarra, é preciso colocar outra contrabarra pois ela é um caracter de escape
//    String regex = "[a-fA-F]";
    // estamos buscando, tudo que for 0 seguido de um range que está verificando se após o 0 contém algum
    // x minusculo ou maiusculo [xX]
    // depois mais um range verificando se depois do [xX] contém numeros de 0 à 9 e letras de a-f ou A-F
    String regex = "0[xX][0-9a-fA-F]";
    // String texto = "abaaba";
    String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";

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

    // para reconhecer numeros hexadecimais em java, é preciso colocar o 0x ou 0X na frente do numero hexadecimal
    int numeroHex = 0x59F86A;
    String teste = "[0xa-fA-F]";
    System.out.println(teste);
    System.out.println(numeroHex);
  }
}
