package com.devdojo.maratonajava.javacore.Xserializacao.dominio;

import java.io.*;
/*
uma recapitulada: para serializar um objeto que não pode ser serializado, no caso a Turma,
temos que praticamente escrever todos os atributos daquele objeto, nos métodos writeObject
e readObject, primeiro escrevemos todos os atributos no writeObject, se tivessemos 15
atributos em turma, teriamos que escrever os 15 e na hora de ler os atributos readObject
novamente, iriamos ler os 15 atributos na mesma ordem que nós escrevemos no writeObject
e assim, montamos um objeto, e quando terminamos de fazer a leitura do objeto serializado
nós temos meio que o mesmo estado que tinhamos quando tinhamos salvado
 */


// para transformar o objeto em serializavel basta implementar a interface
public class Aluno implements Serializable {
  @Serial
  private static final long serialVersionUID = 4293373494354367521L;
  private Long id;
  private String nome;
  // quando queremos que um campo seja totalmente ignorado na serialização, temos que colocar a palavra transient
  // significa que esse atributo não deve ser serializado
  // mas ao fazer isso e executar o codigo, irá mostrar um problema que nós temos uma versão incompatível, por causa
  // do serialVersionUID
  // todas as vezes que nós serializamos, o java precisa manter como se fosse um ID, para saber se posso deserializar
  // nesse caso, como nós não definimos um id, o java gerou pra gente
  // o java entende o transient como se fosse uma mudança que ele pode não entender como deserializar um objeto, por
  // isso que tem um serialVersionUID
  // ao serializar sem o transient e com o atributo serialVersionUID definido, o password é retornado na serialização
  // ao deserializar com o transient, o password não é retornado e contém o valor de null
  private transient String password;

  // outra coisa que devemos tomar cuidado, é que atributos estáticos não pertencem ao objeto, pertencem a classe,
  // ou seja, eles não são serializados, exemplo:
  // quando deserializamos, o atributo abaixo também é incluido, mesmo se ele não tiver sido serializado
  // pois ele faz parte da classe e não do objeto instânciado
  private static final String NOME_ESCOLA = "DevDojo Viradão no Jiraya";

  // Agora que temos outra classe, sem instânciar, se formos serializar e deserializar, irá funcionar normalmente, não
  // ocorre nenhum problema na hora de serializar, ele simplesmente ignorou, colocou como null o valor
  // caso a gente queira que o nossa classe seja serializado, mesmo se não tivermos total controle da classe
  // podemos fazer o seguinte: digamos que não temos total controle da classe Turma e que não podemos implementar
  // o Serializable na criação da classe Turma, devemos passar o modificador transient nela para ser ignorada ao
  // serializar
  private transient Turma turma;

  // agora precisamos agora escrever dois métodos, para conseguirmos serializar a turma
  // o primeiro que vai serializar esse objeto, e o segundo como vai ser para ele ler esse objeto
  // é tipo uma sobrescrita sem ser sobrescrita, tem que seguir exatamente essa sintaxe
  // o java vai se encarregar de chamar esse writeObject, porem não temos um Override, e sim um Serial
  // porque o Serializable não tem nenhum método na sua classe para ser sobrescrito
  // primeiro método:
  @Serial
  private void writeObject(ObjectOutputStream oos){
    try {
      // primeiramente devemos salvar da forma padrão, ou seja:
      oos.defaultWriteObject();
      // em seguida, precisamos salvar tudo aquilo que não faz parte do nosso defaultWriteObject, ou seja, nesse caso
      // seria a turma, é algo que é transient, nosso caso aqui é que nós queremos ter a turma quando dermos novamente
      // a serialização, ou seja, só temos um atributo, no caso a turma, então eu preciso falar, agora você "oos"
      // escreve "oos.write" você não pode salvar o objeto turma, pois o objeto não é serializavel mas os atributos,
      // nós podemos pegar e escrever aqui dentro, então como eu quero escrever uma String, pq se fosse um writeBoolean
      // teriamos que escrever um por um os atributos, mas como só temos uma String, podemos escrever:
      // a ordem é importante, pq a ordem que eu estiver escrevendo "oos.defaultWriteObject();"
      // vai ser a ordem que eu quero ler "oos.writeUTF(turma.getNome());"
      oos.writeUTF(turma.getNome());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Serial
  private void readObject(ObjectInputStream ois){
    try {
      // aqui é ao contrario, primeiramente devemos ler:
      ois.defaultReadObject();
      // agora que temos o objeto, lemos o extra:
      // então esse cara aqui, eu sei que é a turma
      // então podemos pegar aqui por exemplo, e associar a uma string
      // agora podemos ver que ele serializou o nosso aluno, e agora nós temos a nossa turma, não por que a turma foi
      // serializada, mas sim porque nós serializamos a String
      String nomeTurma = ois.readUTF();
      turma = new Turma(nomeTurma);

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Turma getTurma() {
    return turma;
  }

  public void setTurma(Turma turma) {
    this.turma = turma;
  }




  public Aluno(Long id, String nome, String password) {
    System.out.println("Dentro do construtor");
    this.id = id;
    this.nome = nome;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Aluno{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", password='" + password + '\'' +
            ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
            ", Turma='" + turma + '\'' +
            '}';
  }

  public Long getId() {
    return id;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
