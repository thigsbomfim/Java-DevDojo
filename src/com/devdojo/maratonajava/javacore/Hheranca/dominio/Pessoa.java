package com.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Pessoa {
  /*
    protege a variavel por herança e por pacote, só pode ser acessada quem estiver no mesmo pacote ou
    estiver herdando as variáveis
  */
  protected String nome;
  protected String cpf;
  protected Endereco endereco;

  /*
    Se você tem um construtor na classe mãe/pai/superclasse(Pessoa) e
    não existe nenhum outro construtor na subclasse(Funcionario), é preciso criar um construtor para essa subclasse
    que vai atender os requisitos para criar objeto da classe mãe/pai/superclasse

    o super precisa ser acrescentado na primeira linha do método/construtor
    não pode ter o super e o this no mesmo método/construtor, ou você tem um ou o outro
  */


  // Ordem de seguimento de uma classe com herança - ordem de inicialização de uma classe com herança

  // 0 - Bloco de inicialização estático da superclasse/pai é executado apenas uma vez quando a JVM carregar a superclasse
  // 1 - Bloco de inicialização estático da subclasse/filha é executado apenas uma vez quando a JVM carregar a subclasse
  // 2 - Alocado espaço em memória dos atributos da superclasse
  // 3 - Cada atributo de superclasse/pai é criado e inicializado com valores default ou o que for passado da superclasse
  // 4 - Bloco de inicialização não estático da superclasse é executado na ordem que aparece
  // 5 - Construtor da superclasse é executado
  // 6 - Alocado espaço em memória dos atributos da subclasse
  // 7 - Cada atributo de subclasse/filha é criado e inicializado com valores default ou o que for passado da subclasse
  // 8 - Bloco de inicialização não estático da subclasse é executado na ordem que aparece
  // 9 - Construtor da subclasse é executado

  static {
    System.out.println("Dentro do bloco de inicialização estático de Pessoa");
  }
  {
    System.out.println("Dentro do bloco de inicialização não estático de Pessoa 1");
  }
  {
    System.out.println("Dentro do bloco de inicialização não estático de Pessoa 2");
  }

  public Pessoa(String nome) {

    System.out.println("Dentro do construtor Pessoa");
    this.nome = nome;
  }

  public Pessoa(String nome, String cpf) {
    this(nome);
    this.cpf = cpf;
  }

  public void imprime() {
    System.out.println(this.nome);
    System.out.println(this.cpf);
    System.out.println(this.endereco.getRua() + " " + this.endereco.getCep());
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
