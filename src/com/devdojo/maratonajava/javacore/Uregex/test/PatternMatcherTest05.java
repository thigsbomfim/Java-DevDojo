package com.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
  public static void main(String[] args) {
    // site para praticar: https://regexr.com/

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
    // () -> agrupamentos é usado para quantificar as ocorrencias
    // | -> exemplo: o(v|c)o -> encontra no texto o que tiver "v" ou "c" -> ovo | oco
    // $ -> representa o fim da linha
    // . -> caracter coringa -> vamos supor que estamos buscando a expressão 1.3, ele vai achar 123, 133 ou 1@3, 1A3
    // ^ -> é usado para dar uma match, para encontrar exatamente aquilo que eu quero no começo da linha, exemplo:
    // se utilizarmos "^\w+", tudo que for letras numeros ou underline, o mais "+" significa, até ele encontrar
    // algo que não faça parte do "\w", por exemplo, um espaço em branco, ele vai retornar o começo daquela linha
    // exemplo:
    // "^" eu quero o começo da linha
    // quero que o começo da linha seja uma ou varias letras "\w+", ele para até encontrar uma expressão que não
    // satisfaz, exemplo: "abcdef gh" esse texto, irá parar no "f", pois logo depois vem o caracter em branco
    // [^abc] -> também podemos usar o acento na frente de um range, essa expressão diz que queremos tudo do texto
    // que não for "a" minusculo, "b" minusculo e "c" minusculo


    // para poder utilizar um caracter específico que no regex é um delimitador, como o ponto "."
    // é preciso colocar outra contrabarra pois ela é um caracter de escape, ficaria "\\." assim, estamos buscando
    // o caracter ponto "." apenas

    // estamos criando um agrupamento "()";
    // inserindo um range "[]";
    // dentro desse range, estamos verificando se contém os caracteres de "a" à "z" ou "A" à "Z" ou numeros de 0 à 9;
    // ou se contém pontos "." ou underline "_" ou traços "-";
    // depois inserimos um arroba "@";
    // no fim, usamos "+" para buscar uma ou mais ocorrencias;
    // criamos outro agrupamento "()" onde usamos também um range "[]";
    // buscando desse range, se contém os caracteres de "a" à "z" ou "A" à "Z";
    // no fim, usamos "+" para buscar uma ou mais ocorrencias;
    // criamos outro agrupamento "()" e dentro desse agrupamento estamos buscando todas as ocorrencias que contém
    // ponto "." em seguida usamos outro agrupamento desse agrupamento onde utilizamos também um range "[]";
    // buscando desse range, se contém os caracteres de "a" à "z" ou "A" à "Z";
    // no fim, usamos "+" para buscar uma ou mais ocorrencias de dentro desse agrupamento;
    // no fim, usamos "+" para buscar uma ou mais ocorrencias fora do agrupamento;
    // expressão simplificada: ([])+@([])+(\\.([])+)+

    String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
    String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail ";

    // fazer validação para verificar se a string é valida
    System.out.println("Email válido");
    System.out.println("#@!zoro@mail.br".matches(regex));

    // encontrando o padrão de separação de textos/emails, exemplo, os emails estão sendo separados através da virgula
    // no codigo abaixo, estamos utilizando o Arrays, pegando o método toString para visualizar o array
    // usando o texto.split para separar o texto com o argumento de virgula ","
    // [luffy@hotmail.com,  123jotaro@gmail.com,  #@!zoro@mail.br,  teste@gmail.com.br,  sakura@mail ]
    System.out.println(Arrays.toString(texto.split(",")));
    // para remover o espaço em branco da posição 1 do array
    System.out.println(texto.split(",")[1].trim());

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
  }
}
