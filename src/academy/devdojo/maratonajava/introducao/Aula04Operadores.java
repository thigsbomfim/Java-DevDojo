package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
  public static void main(String[] args) {
    int numero01 = 10;
    int numero02 = 20;
    double resultado = numero01 / (double) numero02;
    System.out.println("Valor : "+resultado);

    // %
    int resto = 21 % 2; // 1
    System.out.println(resto);

    // < > <= >= == !=
    boolean isDezMaiorQueVinte = 10 > 20;
    boolean isDezMenorQueVinte = 10 < 20;
    boolean isDezIgualVinte = 10 == 20;
    boolean isDezIgualDez = 10 == 10;
    boolean isDezDiferenteDez = 10 != 10.0;
    System.out.println("isDezMaiorQueVinte "+isDezMaiorQueVinte);
    System.out.println("isDezMenorQueVinte "+isDezMenorQueVinte);
    System.out.println("isDezIgualVinte "+isDezIgualVinte);
    System.out.println("isDezIgualDez "+isDezIgualDez);
    System.out.println("isDezDiferenteDez "+isDezDiferenteDez);


    // && (AND) || (OR) !
    int idade = 29;
    float salario = 3500F;
    boolean isDentroDaLeiMaiorQueTrinta = idade > 30 && salario >= 4612;
    boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;

    System.out.println("isDentroDaLeiMaiorQueTrinta "+isDentroDaLeiMaiorQueTrinta);
    System.out.println("isDentroDaLeiMaiorQueTrinta "+isDentroDaLeiMenorQueTrinta);


    double valorTotalContaCorrente = 200;
    double valorTotalContaPoupanca = 10000;
    float valorPlaystation = 5000F;
    boolean isPlaystationCincoCompravel = valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;
    System.out.println("isPlaystationCincoCompravel "+isPlaystationCincoCompravel);


    // = += -= *= /= %=
    double bonus = 1800;
    bonus += 1000;
    bonus -= 1000;
    System.out.println(bonus);

    int contador = 0;
    contador++;
    contador++;
    contador--;

  }
}
