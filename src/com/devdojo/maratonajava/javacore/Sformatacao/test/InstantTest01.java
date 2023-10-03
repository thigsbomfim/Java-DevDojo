package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
  public static void main(String[] args) {
    // instant trabalha com os nanosegundos
    // ela representa um ponto instantâneo dentro de uma timeline
    // ele é imutavel, todas alterações que forem feitas irá gerar uma nova instância
    // esse objeto guarda os nanosegundos de 1970 até agora
    Instant now = Instant.now();

    // a diferença entre o LocalDateTime e o Instant, é que o Instant recebe um Z no final dos nanosegundos
    // o Z representa o zulu time, é o horario neutro do mundo, qualquer pessoa em qualquer lugar do mundo pode
    // pesquisar o horario que verão a mesma coisa/mesmo horario
    // ele é muito utilizado quando estamos trabalhando com aplicações que precisam de datas específica e precisamos
    // salvar essa data no banco de dados
    // geralmente, quando trabalhamos com aplicações que envolve datas, trabalhamos quase sempre com zulu time
    // porque é um horario neutro
    System.out.println(now); // 2023-10-02T18:04:40.709200700Z
    System.out.println(LocalDateTime.now()); // 2023-10-02T15:04:40.753111600

    // todos os horario desde 1970
    // retorna um long
    System.out.println(now.getEpochSecond());
    // retorna um inteiro
    System.out.println(now.getNano()); // representa um nanosegundo do segundo, ou seja, vai ter no maximo 999.999.999
    // em 1 segundo você vai ter quase 1bilhao de nano segundos

    // irá mostrar o inicio "1970" mais 3 segundos, primeiro argumento seconds, e segundo argumento nanosegundo
    System.out.println(Instant.ofEpochSecond(3,  0));
    System.out.println(Instant.ofEpochSecond(3,  1_000_000_000)); // 3seg+1bi de nanosegundos
    System.out.println(Instant.ofEpochSecond(3,  -1_000_000_000)); // 3seg -1bi de nanosegundos
  }
}
