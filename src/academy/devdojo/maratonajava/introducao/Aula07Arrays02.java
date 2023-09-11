package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
  public static void main(String[] args) {
    // valor de inicialização padrão de um array de cada tipo
    // float e double é: 0.0
    // byte, short, int e long  é: 0
    // char é: '\u0000' que imprime um valor em branco: ' '
    // boolean é: false
    // String é: null
    String[] nomes = new String[4];
    nomes[0] = "Thiago";
    nomes[1] = "Bomfim";
    nomes[2] = "Cardozo";
    nomes[3] = "de";
    for (int i = 0; i < nomes.length; i++) {
      System.out.println(nomes[i]);
    }
    // ao reatribuir o array, ele é resetado e os espaços alocados antes passam a ser null
    nomes = new String[5];
    nomes[4] = "Oliveira";
    for (int i = 0; i < nomes.length; i++) {
      System.out.println(nomes[i]);
    }
  }
}
