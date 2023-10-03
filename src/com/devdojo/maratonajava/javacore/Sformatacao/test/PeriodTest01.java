package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
  public static void main(String[] args) {
    // diferente do Duration, o Period aceita somente LocalDate e não aceita LocalDateTime
    LocalDate now = LocalDate.now();
    LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(7);
    Period p1 = Period.between(now, nowAfterTwoYears);
    Period p2 = Period.ofDays(10); // Dias
    Period p3 = Period.ofWeeks(58); // Semanas
    Period p4 = Period.ofMonths(3); // Meses
    Period p5 = Period.ofYears(3); // Anos

    System.out.println(p1); // P2Y7D
    System.out.println(p2); // P10D
    System.out.println(p3); // P406D
    System.out.println(p4); // P3M
    System.out.println(p5); // P3Y

    // dessa forma não é possível executar o código, pois irá retornar 1
    System.out.println(Period.between(now, now.plusDays(p3.getDays())).getMonths());

    // vai pegar de agora, até a quantidade agora+406 dias da variavel p3
    // e o construtor do until é sobrecarrecado
    // o segundo argumento do until é um TemporalUnit
    // until é usado para calcular a diferença entre as datas
    System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));
  }
}
