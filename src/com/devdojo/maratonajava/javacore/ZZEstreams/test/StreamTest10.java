package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
  public static void main(String[] args) {
    // temos duas formas de gerar Streams infinitos através do Stream.iterate e do Stream.generate
    // a diferença é que o generate aceita um supplier e o iterate aceita um seed como primeiro argumento e como
    // segundo argumento um UnaryOperator.
    // com iterate precisamos dar um seed inicial = 1
    // o UnaryOperator é basicamente um método que retorna o que passamos como argumento
    // aqui estamos pegando apenas os numeros impares
    // podemos usar o método limit para limitar
    Stream.iterate(1, n -> n+2)
            .limit(10)
            .forEach(System.out::println);

    // vamos criar o exemplo de fibonacci
    // o seed, não necessariamente precisa ser um valor numérico
    // onde ficaria dessa forma separadamente:
    // (0,1) (1,1) (1,2) (2,3) (3,5) (5,8)
    Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0]+n[1]})
            .limit(10)
            .forEach(a -> System.out.print(Arrays.toString(a) + " "));

    System.out.println();
    // se quisermos pegar apenas os numeros da sequencia
    Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0]+n[1]})
            .limit(10)
            .map(a -> a[0])
            .forEach(n -> System.out.print(n + " "));

    System.out.println();
    // temos o generate também
    // a diferença é que ele não aceita um UnaryOperator
    // ele aceita um supplier
    // digamos que nós queiramos gerar 100 numeros aleatorios
    // para gerar numeros aleatorios com a classe ThreadLocalRandom
    ThreadLocalRandom random = ThreadLocalRandom.current();

    System.out.print("10 números aleatórios: ");
    // quero gerar um numero aleatório de 1 a 500, com o limite de 90 numeros
    Stream.generate(() -> random.nextInt(1, 500))
            .limit(10)
            .forEach(n -> System.out.print(n + " "));
  }
}
