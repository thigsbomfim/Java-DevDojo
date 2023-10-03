package com.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
  public static void main(String[] args) {
    // não podemos instânciar um calendar dessa forma:
    // Calendar c = new Calendar(); // erro de compilação

    // para pegar uma instância do Calendar
    Calendar c = Calendar.getInstance();

    // getFirstDayOfWeek, pega o primeiro dia da semana, dependendo de cada país, esse if está pegando o domingo
    if(c.getFirstDayOfWeek() == Calendar.SUNDAY) {
      System.out.println("Domingão é o primeiro dia da semana");
    }

    // Pega o dia, mês, ano e dia da semana no mês
    System.out.println("Dia da semana: " + (c.get(Calendar.DAY_OF_WEEK)));
    System.out.println("Dia do mês: " + (c.get(Calendar.DAY_OF_MONTH)));
    System.out.println("Dia do ano: " + (c.get(Calendar.DAY_OF_YEAR)));
    System.out.println("Dia da semana no mês: " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

    // serve para adicionar meses, dias, anos, primeiro parametro é o atributo, e o segundo é o dia que vc quer add
    c.add(Calendar.DAY_OF_MONTH, 0);

    // dessa forma, estamos adicionando mais horas, que dependendo do horario que você está, irá mudar o dia
    c.add(Calendar.HOUR, 12); // ex.: Wed Oct 04 07:22:37 BRT 2023

    // para não mudar o dia ao adicionar um horario, basta usar o roll
    c.roll(Calendar.HOUR, 12);


    System.out.println(c);

    Date date = c.getTime(); // formata a data do calendario gregoriano usando o Objeto Date

    System.out.println(date);
  }
}
