package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTest01 {
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    DateFormat[] df = new DateFormat[7];

    // retorna o dia/mes/ano + horario -> 01/10/2023 18:32
    df[0] = DateFormat.getInstance();

    // retorna o dia, mes abreviado e ano -> 1 de out. de 2023
    df[1] = DateFormat.getDateInstance();

    // retorna o dia, mes abreviado e ano + o horario -> 1 de out. de 2023 18:32:04
    df[2] = DateFormat.getDateTimeInstance();

    // retorna o dia/mes/ano -> 01/10/2023
    df[3] = DateFormat.getDateInstance(DateFormat.SHORT);

    // retorna o dia, o mes abreviado e o ano -> 1 de out. de 2023
    df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);

    // retorna o dia, o mes e o ano -> 1 de outubro de 2023
    df[5] = DateFormat.getDateInstance(DateFormat.LONG);

    // retorna dia da semana, o dia, o mes e o ano -> domingo, 1 de outubro de 2023
    df[6] = DateFormat.getDateInstance(DateFormat.FULL);

    for(DateFormat dateFormat : df ){
      System.out.println(dateFormat.format(calendar.getTime()));
    }
  }
}
