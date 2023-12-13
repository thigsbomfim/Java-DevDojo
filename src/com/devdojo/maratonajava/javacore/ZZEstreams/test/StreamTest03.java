package com.devdojo.maratonajava.javacore.ZZEstreams.test;


import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
          List.of(
          new LightNovel("Tensei Shittara", 8.99),
          new LightNovel("Overlord", 3.99),
          new LightNovel("Violet Evergarden", 5.99),
          new LightNovel("No Game no life", 2.99),
          new LightNovel("Fullmetal Alchemist", 5.99),
          new LightNovel("Kumo desuga", 1.99),
          new LightNovel("Kumo desuga", 1.99),
          new LightNovel("Monogatari", 4.00)
          )
  );

  public static void main(String[] args) {
    // uma operação que podemos fazer, uma operação final é o forEach
    // stream é uma operação intermediaria pois está retornando outras streams
    Stream<LightNovel> stream = lightNovels.stream();
    // o forEach não tem retorno mas poderia fazer uma ação e ele é uma operação final
            // podemos utilizar tanto com lambdas quanto com method reference
//            .forEach(ln -> System.out.println(ln));
    stream.forEach(System.out::println);

    // lembrando, que a propria List, contém um método chamado forEach, que também recebe o mesmo consumer.
    // porém, devemos lembrar que do streams pro forEach, nós temos uma operação terminal,
    // e da coleção "List" para o forEach, não é uma operação terminal, por que não estamos dentro de um stream,
    // e isso quer dizer que o forEach é só um método dentro da interface Iterable.
//    lightNovels.forEach();
    // nesses casos é melhor utilizar o forEach da propria coleção, pois estamos criando um stream que basicamente
    // transforma nossos dados do espaço para o tempo e estamos imprimindo todos eles, ou seja, estamos desperdiçando
    // processamento, por que nós poderiamos estar utilizando diretamente o método forEach da coleção.

    // se o stream de uma variavel for fechado, não poderemos usar ele posteriormente. O stream acima está sendo fechado
    // com o forEach, então quer dizer que não poderemos utilizar ele para criar uma proxima variavel, teriamos que
    // chamar o lightNovels novamente para utilizarmos, dessa forma abaixo:

    // outra operação terminal que poderiamos fazer também é contar, digamos que queremos contar quantos elementos tem
    // dentro, digamos que queremos fazer uma operação para saber quantos lightNovels tem o preço menor que 4, usando
    // o método count
    long count = lightNovels.stream().filter(ln -> ln.getPrice() <= 4).count();
    System.out.println(count); // 5


    // agora queremos os elementos distintos, o método dinstinct é um método intermediario que retorna outro stream
    // lembrando sempre que nosso equals e hashCode devem estar corretamente sobrescritos para o funcionamento do
    // método dinstinct, na classe LightNovel estamos sobrescrevendo o hashCode e o equals usando o titulo
    long count2 = lightNovels.stream()
            .distinct()
            .filter(ln -> ln.getPrice() <= 4)
            .count();
    System.out.println(count2); // 4

  }
}
