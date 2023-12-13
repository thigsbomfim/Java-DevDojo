package com.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
  private String name = "Midorya";
  // Classes locais são classes que não estão diretamente dentro da classe mas está dentro de um método ou de um bloco
  // de inicialização estático

  // classes locais é quando temos uma classe dentro de um método
  // por exemplo:
  void print(final String param){
    // estamos dentro de um método normal, chamado print
    // ele faz parte da classe OuterClassesTest02
    // porem, podemos criar classes locais dentro do método
    // é dificil encontrar exemplos de utilização de classes desta forma, mas vamos ver como funciona
    // temos algumas regras quanto aos modifcadores de acesso, como estamos dentro do método, as regras se aplicam
    // temos duas opções:
    // ou abstract
    // ou final
    // abstract class LocalClass
    // final class LocalClass

    // agora digamos que tenhamos atributos dentro do método
    // quando temos um atributo no método, também podemos utiliza-lo na nossa classe
    // só que tem um pequeno detalhe, esse atributo que estamos utilizando, ele tem que ser:
    // ou final
    // ou efetivamente final
    // quando criamos uma variavel dentro de um método e não alteramos, o java considera ela como efetivamente final
    // se quisermos ser bem explicito, podemos adicionar o final diretamente
    final String lastName = "Izuku";
//    lastName = ""; // quando fazemos isso, ocorre um problema na chamada da variavel, pois estamos fazendo uma
//    alteração
    // que não é final, e sim efetivamente final

    // diferente de nome, nome não influência, pois está do lado de fora do método
    // um método tem um tempo de vida muito menor do que o tempo de vida da classe, por exemplo, quando esse objeto está
    // vivo, significa que esse atributo nome está vivo, e só podemos executar o método print, somente enquanto a classe
    // estiver viva
//    name = "";

    class LocalClass {
      // ainda temos acesso aos atributos da classe externa
      public void printLocal(){
        System.out.println(name+" "+lastName);

        // a mesma coisa sobre a explicação dos atributos do método, vale para parâmetro, podemos usar parâmetro aqui
        // dentro, contanto que seja efetivamente final
//        param = ""; // temos um problema, que está dizendo que o parâmetro precisa ser efetivamente final
      }


    }



    // para conseguirmos ter acesso a essa classe antes do método terminar
    // essa é a unica forma que temos de utilizar as classes locais, precisa-se instânciar essa classe diretamente no
    // método
//    LocalClass localClass = new LocalClass();
//    localClass.printLocal();
  }

  // também é possivel criar um método dentro do bloco de inicialização
//  {
//    class Test {
//
//    }
//  }

  public static void main(String[] args) {
    // para essa gambiarra toda, precisa ser utilizada de alguma forma, como fazemos para utilizar?
    OuterClassesTest02 outer = new OuterClassesTest02();
    // agora que temos uma classe local, não temos acesso a essa classe, uma vez que esse método termina.
    // sempre que criarmos uma classe local, precisamos inicializar essa classe diretamente no método, se não, não
    // teremos acesso a essa classe, apartir do momento que esse método termina
    outer.print("a");
  }
}
