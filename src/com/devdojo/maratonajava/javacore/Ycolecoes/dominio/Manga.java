package com.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

// Nesta classe, estamos implementando o método Comparable para criar nossa própria ordenação.
// No generics, passamos o tipo que desejamos ordenar.
public class Manga implements Comparable<Manga> {
  private Long id;
  private String nome;
  private double preco;
  private int quantidade;

  public Manga(Long id, String nome, double preco) {
    // Aqui, estamos usando a verificação de nulidade com o método Objects.requireNonNull.
    // Isso gera uma exceção de NullPointerException se o valor for nulo, junto com a mensagem especificada.
    Objects.requireNonNull(id, "ID não pode ser nulo");
    Objects.requireNonNull(nome, "Nome não pode ser nulo");
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Manga(Long id, String nome, double preco, int quantidade) {
    this(id,nome,preco);
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return "Manga{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", preco=" + preco +
            ", quantidade=" + quantidade +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Manga manga = (Manga) o;
    return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }

  public Long getId() {
    return id;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  // Sobrescrevendo o método da interface Comparable.
  @Override
  public int compareTo(Manga outroManga) {
    /*
       Aqui temos dois objetos, onde "this" faz referência à variável instanciada,
       e o objeto "outroManga" faz referência ao objeto passado como argumento.

       As regras para sobrescrever, no caso de valores numéricos, são as seguintes:
       1° -> Deve retornar um número negativo se "this" for menor que "outroManga";
       2º -> Deve retornar 0 se "this" for igual a "outroManga";
       3° -> Deve retornar um número positivo se "this" for maior que "outroManga".
    */

    // Para ordenar alfabeticamente pelo nome, podemos usar a função compareTo diretamente no atributo nome.
    return this.nome.compareTo(outroManga.getNome());

    // No caso de ordenar por ID, como o atributo é do tipo Wrapper (Long), podemos usar o compareTo do Long.
    // return this.id.compareTo(outroManga.getId());

    // Se quisermos ordenar por preço (um tipo primitivo), podemos usar o Double.compare para fazer a comparação.
    // return Double.compare(this.preco, outroManga.getPreco());
  }
}
