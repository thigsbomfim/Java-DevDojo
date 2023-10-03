package com.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class DateTest01 {
  public static void main(String[] args) {
    Date date = new Date(1696190683003L); // long 100000 - trabalha com as datas em milisegundos
    date.setTime(date.getTime() + 3_600_000); // adiciona 1 hora no relógio
    System.out.println(date);
  }
}
