package academy.devdojo.maratonajava.introducao;

public class Aula02TiposPrimitivos {
  public static void main(String[] args) {
    // int, double, float, char, byte, short, long, boolean
    int idade = 10;
    long numeroGrande = 100000L;
    double salarioDouble = 2000.0D;
    float salarioFloat = 2500.0F;
    byte idadeByte = 127;
    short idadeShort = 32000;
    boolean verdadeiro = true;
    boolean falso = false;
    char caractere = 65; // A
    String nome = "Goku";

    System.out.println("A idade é: " + idade + " anos.");
    System.out.println(falso);
    System.out.println("Char: "+caractere);
    System.out.println(numeroGrande);
    System.out.println(nome);
    System.out.println("Oi meu nome é "+nome);
  }
}
