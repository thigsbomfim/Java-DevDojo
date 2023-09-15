package com.devdojo.maratonajava.javacore.Isobrescritametodotostring.dominio;

public class Anime {
  private String nome;

  // Override serve para ter certeza que estamos sobrescrevendo um método herdado

  // Duas regras para seguir quando estamos sobrescrevendo
  // 1 - Nome precisa ser exatamente o mesmo, a quantidade de parametros precisa ser exatamenta a mesma, se não tiver, continue sem ter
  // 2 - O tipo de retorno tem que ser exatamenta a classe ou alguma subclasse, isso se chama covariantes de retorno
  // 3 - O modificador de acesso nunca pode ser mais restritivo, ou seja, public é o modificador de acesso mais aberto que tem
  @Override
  public String toString() {
    return "Anime{" +
            "nome='" + nome + '\'' +
            '}';
  }

  public Anime(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
