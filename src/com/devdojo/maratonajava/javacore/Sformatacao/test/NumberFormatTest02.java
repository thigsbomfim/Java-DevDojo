package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
  // Formas de usar moedas em cada país

  public static void main(String[] args) {
    Locale localeBR = new Locale("pt", "BR");
    Locale localeJP = Locale.JAPAN;
    Locale localeIT = Locale.ITALY;

    NumberFormat[] nfa = new NumberFormat[4];
    nfa[0] = NumberFormat.getCurrencyInstance();
    nfa[1] = NumberFormat.getCurrencyInstance(localeJP);
    nfa[2] = NumberFormat.getCurrencyInstance(localeBR);
    nfa[3] = NumberFormat.getCurrencyInstance(localeIT);

    double valor = 1000.2130;
    for (NumberFormat numberFormat : nfa) {
      // para dizer quantos digitos tem nos numeros
      System.out.println(numberFormat.getMaximumFractionDigits()); // quase todos contém 2 digitos - 21, japao 0 digitos

      System.out.println(numberFormat.format(valor));
    }

    String valorString = "R$ 1.000,21";
    try {
      // para realizar o parse usando moedas, é necessario usar no valor do parse, a moeda do pais que quer realizar
      // o parse
      // acima, o valorString está na moeda do brasil, mas o parse abaixo está usando o formato do japao "nfa[1]"
      // irá ocorrer uma exceção do tipo "ParseException: Unparseable number"
      // resumindo: para realizar o parse, a moeda do valor do parse deve ser o mesmo do do parse que está sendo feito
      // é preciso usar o "nfa[0].parse" com o valorString "R$ 1.000,21"
      System.out.println(nfa[1].parse(valorString));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

  }
}
