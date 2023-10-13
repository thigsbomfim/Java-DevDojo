package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
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
    // Quantificadores, são caracteres que darão poder em pegar determinada expressão baseada na quantidade
    // ? -> zero ou uma ocorrencia
    // * -> zero ou mais
    // + -> uma ou mais ocorrencias
    // {n,m} -> valor mais específico de ocorrencias -> de n até m ocorrências, ou de 5 a 10 ocorrencias
    // () -> agrupamentos é usado para quantificar as ocorrencias ([a-z])+ buscando de "a" à "z" uma ou mais vezes
    // | -> exemplo: o(v|c)o -> encontra no texto o que tiver "v" ou "c" -> ovo | oco
    // $ -> representa o fim da linha

    // para poder utilizar a contrabarra, é preciso colocar outra contrabarra pois ela é um caracter de escape
    /*
     acha no texto tudo que começa com 0
     seguido de um range que está verificando se após o 0 contém algum x minusculo ou maiusculo [xX];
     agrupando com ();
     depois buscando com um range verificando se depois do [xX] contém numeros de 0 à 9 e letras de a-f ou A-F;
     depois verificando uma ou mais vezes usando o quantificador "+";
     e agrupando novamente ();
     verificando se o caracter é seguido de um espaço em branco "\\s" ou o quantificador fim da linha "$"
     */

    String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
    String texto = "12 0x 0X 0xFFABC 0x10G 0x1";

    // classe para trabalhar com regex no java, Pattern que é a padrão e a matcher que encontra aquele padrão
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(texto);
    System.out.println("texto: "+ texto);
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
