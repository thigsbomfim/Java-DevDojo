package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    now = now.plusDays(20); // usando o plusDays, ele adiciona os dias
    now = now.withDayOfMonth(20); // usando o with, ele altera o dia de hoje para o dia que estamos passando
    now = now.withMonth(1); // usando o with, ele altera o mes de hoje para o mes que estamos passando
    // with serve para modificar a data em um dia/mes/ano especifico
    now = now.with(ChronoField.DAY_OF_MONTH, 20); // chronofield substitui o dia do mes pelo segundo argumento
    System.out.println(now);
    System.out.println(now.getDayOfWeek());

    // nextOrSame() -> retorna a mesma data que está sendo passada por argumento
    // DayOfWeek -> serve de argumento para o método nextOrSame
    // nextOrSame(DayOfWeek.MONDAY) -> retorna a mesma data como dia especifico que está sendo passado
    now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se usarmos o TemporalAdjusters.next() e passar como argumento um dia da semana, irá retornar o dia que virá na
    // próxima semana, exemplo:
    now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se quisermos saber também que dia da semana anterior foi segunda feira
    now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se quisermos saber o primeiro dia do mês
    now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se quisermos saber o ultimo dia do mês
    now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se quisermos saber o primeiro dia do próximo ano
    now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());

    // se quisermos saber o primeiro dia do próximo mês
    now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
    System.out.println(now);
    // saber o dia da semana
    System.out.println(now.getDayOfWeek());





  }
}
