package com.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio;

public class Carro {
  private String nome;
  /*
    Ao usar o final, o Java só aceita iniciar quando você define um valor para o atributo e não pegando somente o valor
    padrão

    no java, existe uma convenção para constante, usar o nome da variavel em upperCase e separada por "_"
    Geralmente uma constante vem com o modificador static
  */
  // se não estivessemos atribuindo o valor dentro de um bloco de inicialização, esse atributo iria receber um erro
  public static final double VELOCIDADE_LIMITE;
  public final Comprador COMPRADOR = new Comprador();

  // Esse método nunca poderá ser sobrescrito, pois ele é uma constante, usa o final
  public final void imprime(){
    System.out.println(this.nome);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // aqui estamos atribuindo quando a classe é executada, então é permitido
  static {
    VELOCIDADE_LIMITE = 250;
  }

  // dessa forma também funciona, estamos criando uma variavel não estática e deixando sem valor
  // public final double VELOCIDADE_LIMITE;

  // aqui estamos atribuindo no bloco de inicialização não estático
  // {
  //   VELOCIDADE_LIMITE = 250;
  // }



}
