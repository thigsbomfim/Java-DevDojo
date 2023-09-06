package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais03 {
  public static void main(String[] args) {
    // Salario
    double salarioAnual = 32151.48;

    // Calculando imposto sobre o salario da Holanda
    double primeiraFaixaHolanda = 9.70 / 100;
    double segundaFaixaHolanda = 37.35 / 100;
    double terceiraFaixaHolanda = 49.58 / 100;

    double valorImpostoHolanda;

    // Calculando imposto sobre o salario do Brasil
    double primeiraFaixaBrasil = 0.0 / 100;
    double segundaFaixaBrasil = 7.5 / 100;
    double terceiraFaixaBrasil = 15.00 / 100;
    double quartaFaixaBrasil = 22.5 / 100;
    double quintaFaixaBrasil = 27.5 / 100;

    double valorImpostoBrasil;


    // Holanda
    if(salarioAnual <= 34712) {
      valorImpostoHolanda = salarioAnual * primeiraFaixaHolanda;
    } else if(salarioAnual >= 34713 && salarioAnual <= 68587) {
      valorImpostoHolanda = salarioAnual * segundaFaixaHolanda;
    } else {
      valorImpostoHolanda = salarioAnual * terceiraFaixaHolanda;
    }

    // Brasil
    if(salarioAnual <= 21453.24) {
      valorImpostoBrasil = salarioAnual * primeiraFaixaBrasil;
    } else if(salarioAnual > 21453.24 && salarioAnual <= 32151.48) {
      valorImpostoBrasil = salarioAnual * segundaFaixaBrasil;
    } else if(salarioAnual > 32151.48 && salarioAnual <= 42869.16) {
      valorImpostoBrasil = salarioAnual * terceiraFaixaBrasil;
    } else if(salarioAnual > 42869.16 && salarioAnual <= 53565.72) {
      valorImpostoBrasil = salarioAnual * quartaFaixaBrasil;
    } else {
      valorImpostoBrasil = salarioAnual * quintaFaixaBrasil;
    }

    System.out.println("Salário anual na Holanda sem imposto: €"+salarioAnual);
    System.out.println("Salário anual na Holanda com imposto: €"+(salarioAnual - valorImpostoHolanda));
    System.out.println("Valor do imposto anual na Holanda: €"+valorImpostoHolanda);
    System.out.println(" ");
    System.out.println("Salário anual no Brasil sem imposto: R$"+salarioAnual);
    System.out.println("Salário anual no Brasil com imposto: R$"+(salarioAnual - valorImpostoBrasil));
    System.out.println("Valor do imposto anual no Brasil: R$"+valorImpostoBrasil);
  }
}
