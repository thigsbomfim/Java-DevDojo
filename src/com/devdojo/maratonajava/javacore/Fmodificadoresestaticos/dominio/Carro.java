package com.devdojo.maratonajava.javacore.Fmodificadoresestaticos.dominio;

public class Carro {
  // o this, se refere sempre a instância do objeto e não a classe Carro em si
  // dentro do bloco de métodos e atributos estáticos, a palavra this que referencia ao objeto, não existe!
  // métodos estáticos não podem acessar variáveis de instância como o exemplo da variavel nome abaixo.
  // quando usamos o static, temos a possibilidade de não existir um objeto em memória, por isso não podemos acessar

  // mas o contrário funciona, se quisermos atribuir ou referenciar um método/atributo estático dentro de outro método
  // um exemplo, no método imprime, podemos buscar o valor de Carro.velocidadeLimite, pois faz parte da classe em si

  // É RECOMENDADO USAR MÉTODOS/ATRIBUTOS ESTÁTICOS QUANDO O MÉTODO ATRIBUTO NÃO ACESSA AS VARIÁVEIS DE INSTÂNCIA
  // QUANDO NÃO ACESSAM OS ATRIBUTOS NÃO ESTÁTICOS E MÉTODOS NÃO ESTÁTICOS

  private String nome;
  private double velocidadeMaxima;

  // ao usar o modificar estático, o atributo passa a fazer referencia a classe em si e não na instância do objeto
  // qualquer coisa que fizermos nesse atributo em qualquer objeto, será alterado na própria classe Carro
  // ex.: estou instanciando no pacote test o valor de 180 neste atributo, todas as instâncias terão esse valor
  private static double velocidadeLimite = 250;

  public Carro(String nome, double velocidadeMaxima) {
    this.nome = nome;
    this.velocidadeMaxima = velocidadeMaxima;
  }

  public void imprime(){
    System.out.println("----------------");
    System.out.println("Nome: " + this.nome);
    System.out.println("Velocidade máxima: " + this.velocidadeMaxima);
    System.out.println("Velocidade limite: " + Carro.velocidadeLimite);
  }

  public static void setVelocidadeLimite(double velocidadeLimite) {
    Carro.velocidadeLimite = velocidadeLimite;
  }

  public static double getVelocidadeLimite() {
    return velocidadeLimite;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getVelocidadeMaxima() {
    return velocidadeMaxima;
  }

  public void setVelocidadeMaxima(double velocidadeMaxima) {
    this.velocidadeMaxima = velocidadeMaxima;
  }

}
