package com.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
  // Strings no java são imutáveis
  public static void main(String[] args) {
    /*
      Heap -> é uma área de memória em um programa de computador onde os objetos vivem e são alocados.
      Imagine o heap como uma grande área de armazenamento onde todos os objetos são colocados.

      String constant pool -> Uma piscina constante de strings
       ____________________________
      |           (Heap)           |
      |                            |
      |        __________________  |
      |    |--|----->William<----|-|--------------nome
      |    |  |           |      | |
      |    |  |           |______|_|______________nome2
      |    |  |                  | |
      |    |  |     " Suane"     | |
      |    |  |         |________|_|_______________Sem referência ou pode ser reatribuida
      |    |  |                  | |
      |    |  |  "William Suane" | |
      |    |  |         |________|_|_______________Sem referência ou pode ser atribuida
      |    |  |__________________| |
      |    |       String pool     |
      |    |                       |
      |    |   ___________         |
      |    |--|--William<-|--------|---------------nome3 - Objeto criado em memória Heap que referencia a String
      |       |           |        |                          dentro do String pool
      |       |___________|        |
      |____________________________|

    RESUMINDO: Não é possivel alterar um valor dentro do pool de strings
    */

    String nome = "William";
    String nome2 = "William";

    // Para comparar a referencia de um objeto guardado em memória como no exemplo acima, basta usar "=="
    System.out.println(nome == nome2); // true

    // Não podemos mudar o valor de uma String ja existente, a não ser que faça uma nova associação, não podemos trocar
    // o valor que existe
    // nesse caso, estamos criando uma nova referência no String pool, porém não é possível ser chamada
    nome.concat(" Suane");
    System.out.println(nome); // console: William -> pois a String é imutável

    // para conseguir ser chamada, basta passar um nome de variavel para essa referencia ou modificar a propria variavel
    nome = nome.concat(" Suane"); // nome += " Suane"
    System.out.println(nome); // console: William Suane -> pois a variavel está sendo reatribuída
    System.out.println(nome == nome2); // console: false -> pois nome agora está sendo apontada para outra referência


    // vamos pegar o exemplo acima e aplica-lo com objetos
    // quando criamos uma string dessa forma, estamos colocando a string dentro do Heap, e não dentro do String pool
    // 1- Criando uma variavel de referência
    // 2- Objeto do tipo string
    // 3- Uma string no pool de string
    String nome3 = new String("William");
    System.out.println(nome2 == nome3); // console: false -> nome3 referência ao objeto String instânciado diretamente

    /*
     * Quando você chama intern() em uma string, o Java verifica se essa string já está no String Constant Pool.
     * Se estiver, a referência para a string existente no pool é retornada.
     * Caso contrário, a string atual é adicionada ao pool e a referência para ela é retornada.
    */
    System.out.println(nome2 == nome3.intern()); // true
  }
}
