package com.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Funcionario extends Pessoa {
  private double salario;


  // Criando um construtor que recebe o construtor da classe Pessoa e atribui o argumento nome que é obrigatório
  /*
  Se você tem um construtor na classe mãe/pai/superclasse(Pessoa) e
  não existe nenhum outro construtor na subclasse(Funcionario), é preciso criar um construtor para essa subclasse
  que vai atender os requisitos para criar objeto da classe mãe/pai/superclasse

  o super precisa ser acrescentado na primeira linha do método/construtor
  não pode ter o super e o this no mesmo método/construtor, ou você tem um ou o outro
   */
  public Funcionario(String nome) {
    super(nome);
    System.out.println("Dentro do construtor Funcionário");
  }



  static {
    System.out.println("Dentro do bloco de inicialização estático de Funcionario");
  }
  {
    System.out.println("Dentro do bloco de inicialização não estático de Funcionario 1");
  }
  {
    System.out.println("Dentro do bloco de inicialização não estático de Funcionario 2");
  }



  // sobrescrevendo um método da classe Pessoa
  // super serve para chamar métodos/atributos que foram extendidos para a classe Funcionario
  // usando o super, ele chama os atributos/métodos dessa classe Funcionario e não da classe Pessoa
  public void imprime(){
    super.imprime();
    System.out.println(this.salario);
  }

  public void relatorioPagamento(){
    System.out.println("Eu "+this.nome+" recebi o salario de "+this.salario);
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}
