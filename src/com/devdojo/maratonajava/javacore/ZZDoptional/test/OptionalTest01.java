package com.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

/**
 * Optional é uma classe que foi introduzida na versão 8 do java, e o intuito dessa classe em termos simples, é tentar
 * evitar o nullPointerException, não é tentar evitar todos, mas o principal objetivo é ser estupidamente facil para
 * identificarmos o retorno de um método, pode ser opcional, pode não vir. Ao invés de retornar null, retorna um
 * Optional.
 * Não é uma boa ideia utilizar Optional em parâmetros, exemplo:
 * private static Optional<String> findName(Optional<String> name)
 * e também não é uma boa ideia utilizar como variavel/atributos de classe, exemplo:
 * public class Pessoa {
 *  Optional<String> name;
 * }
 * por que o optional não é uma classe que é serializavel
 */
public class OptionalTest01 {
  public static void main(String[] args) {
    // o problema é que muita das vezes, queremos utilizar essa sintaxe:
//    String name = findName("William");
    // aqui, teremos um nullPointerException, por que ele não conseguiu encontrar
//    System.out.println(name.toUpperCase());

    // para facilitar esse tipo de caso, o java criou o Optional
    // o Optional é um objeto que vai encapsular outros objetos
    // Criamos um optional dessa forma
    // Vemos que o Optional pede um tipo, que será o tipo que estamos trabalhando
    // vamos replicar o método findName
    // nós não podemos mudar a assinatura do método findName, mas queremos colocar o findName dentro do optional, para
    // tratar melhor o nullPointerException
    Optional<String> o1 = Optional.of("Aha uhu o DevDojo é foda.");
    // se imprimirmos esse o1, teremos um objeto Optional que está encapsulando o valor
    System.out.println(o1);

    // caso não passarmos valor no Optional.of(), teremos um nullPointerException, pois o método "of" quer que
    // retornamos um objeto não nulo
//    Optional<String> o2 = Optional.of(null);
//    System.out.println(o2);

    // se não soubermos se vai ser nulo ou não, temos o método "ofNullable"
    Optional<String> o3 = Optional.ofNullable(null);
    // e dessa forma, ele irá imprimir um optional vazio: "Optional.empty"
    System.out.println(o3);

    // e caso nós quisermos criar um optional vazio, temos o: "Optional.empty()";
    Optional<String> o4 = Optional.empty();
    System.out.println(o4); // Optional.empty

    System.out.println("---------------");

    // agora podemos utilizar o findName e criar usando o Optional
    // ele irá retornar um optional
    // retorno                             recebendo
    Optional<String> nameOptional = findName("William");
    // mas digamos que eu queira executar caso tenha alguma coisa, ai que vem a magica do optional.
    // caso não tenha o nome, ele pode retornar outra coisa utilizando o Else
    // caso não temos o nome, o que queremos fazer?
    String empty = nameOptional.orElse("EMPTY");
    // caso não exista, irá retornar empty, e caso exista, irá retornar o nome
    System.out.println(empty);

    // também temos outros, ifPresent, caso exista, faça algo
    // ele pede a interface funcional Consumer
    // podemos utilizar o Method Reference, mas o problema é que ele retorna void, ele não tem retorno
    // então não conseguimos colocar um "System.out.println()" no ifPresent, pois ele não retorna nada
//    nameOptional.ifPresent(String::toUpperCase);
    // para conseguir utilizar, precisamos usar a sintaxe lambda
    nameOptional.ifPresent(str -> System.out.println(str.toUpperCase()));
    System.out.println(nameOptional);

    // como podemos ver, o optional nos da opções para trabalhar de maneira mais funcional
  }

  // o que era feito antigamente, o método faz o seguinte, verifica em uma lista, se contém esse nome
  // se tiver, retorna esse elemento, se não, retorna null
//  private static String findName(String name) {
//    List<String> list = List.of("William", "DevDojo");
//    int i = list.indexOf(name);
//    if(i != -1) return list.get(i);
//    return null;
//  }

  // o ideal na visão da oracle, é utilizar o método dessa forma:
  // nós como desenvolvedores, quando batemos o olho e enchergamos esse retorno Optional<String> ele meio que ja nos
  // força a pensar no caso negativo.
  // O que eu faço se eu encontrar?
  // O que eu faço se eu não encontrar?
  private static Optional<String> findName(String name) {
    List<String> list = List.of("William", "DevDojo");
    int i = list.indexOf(name);
    if(i != -1) return Optional.of(list.get(i));
    return Optional.empty();
  }
}

