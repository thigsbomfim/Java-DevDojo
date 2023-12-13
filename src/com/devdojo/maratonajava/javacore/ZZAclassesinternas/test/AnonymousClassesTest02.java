 package com.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

 import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
 import com.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
 import com.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentavelService;

 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.List;

 public class AnonymousClassesTest02 {
  public static void main(String[] args) {
    // imagina que nós temos uma lista
    // usando o List.of(), não podemos alterar, não podemos adicionar.
    // criando dessa forma, agora a nossa lista é mais imutavel
    List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

    // caso quisermos dar um sort nessa lista, o objeto precisa ser um comparable, ou a lista precisa ter um comparator
    // mas não temos um comparable no Barco, e eu não quero criar uma classe fora dessa AnonymousClassesTest02
    // nesse caso, classes anonimas podem ser úteis
    // aqui estamos criando uma classe anonima dentro do argumento do sort
    // estamos instânciando uma classe, mas na vdd estamos criando uma classe anonima, que ela implementa esse
    // Comparator.
    // dessa forma, podemos criar uma classe específica para esse ponto no tempo, depois que esse código passa, nunca
    // mais poderemos usar essa classe anonima abaixo novamente
    // é útil em casos bem pontuais mesmo
    barcoList.sort(new Comparator<Barco>() {
      @Override
      public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
      }
    });

    // esse código acima é um pouco antigo, a forma mais nova de se usar é assim:
//    barcoList.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));

    System.out.println(barcoList);
  }
}
