package academy.devdojo.maratonajava.introducao;
/*
Prática

Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:

Eu <nome>, morando no endereço <endereco>,
confirmo que recebi o salário de <salario>, na data <data>
*/
public class Aula03TiposPrimitivosExercicios {
  public static void main(String[] args) {
    String nome = "Thiago";
    String endereco = "Rua Hermes da Silva - 19";
    double salario = 5000D;
    String dataRecebimentoSalario = "2023-09-05";
    String relatorio = "Eu "+nome+", morando no endereço "+endereco+
            ", confirmo que recebi o salario de $"+salario+", na data "+dataRecebimentoSalario;
    System.out.println(relatorio);
  }
}
