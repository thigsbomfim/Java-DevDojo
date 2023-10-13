package com.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
  private String serialNumber;
  private String marca;


  public Smartphone(String serialNumber, String marca) {
    this.serialNumber = serialNumber;
    this.marca = marca;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  // sobrescrevendo o método equals
  // algumas regras que precisa seguir para sobrescrever o equals
  // 1º -> precisa ser reflexivo -> x.equals(x) tem que ser true para tudo que for diferente de null
  // 2º -> precisa ser simétrico -> para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true
  // 3º -> precisa ter transitividade -> para x,y,z diferentes de null, se "x.equals(y) == true e,
  // "x.equals(z) == true" logo, "y.equals(z) == true"
  // 4º -> precisa ser consistente -> "x.equals(x)" sempre retorna true se x for diferente de null
  // 5º -> para x diferente de null, x.equals(null) tem que retornar false
  @Override
  // Sobrescrevendo o método equals para comparar smartphones com base no número de série.
  public boolean equals(Object obj) {
    // Verifica se o objeto passado como parâmetro é nulo, se for, os smartphones não são iguais.
    if(obj == null) return false;

    // Verifica se o objeto passado como parâmetro é o mesmo objeto, se for, os smartphones são iguais.
    if(this == obj) return true;

    // Verifica se o objeto passado como parâmetro pertence à mesma classe (Smartphone).
    if(this.getClass() != obj.getClass()) return false;

    // Realiza o cast do objeto passado como parâmetro para a classe Smartphone,
    // pois agora sabemos que ambos objetos são da mesma classe.
    Smartphone smartphone = (Smartphone) obj;

    // Compara os números de série dos smartphones. Se forem iguais, os smartphones são considerados iguais.
    // mas devemos tomar cuidado, como nós fizemos o equals comparando apenas o serialNumber, caso tenhamos uma situação
    // em que o serialNumber sejam iguais mas o atributo marca seja com nomes totalmente diferentes, irá retornar true
    // mesmo se a marca for diferente.
    // então nesse caso, precisa ser levado em consideração de acordo com a regra de negócio, como consideramos que dois
    // objetos são os mesmos?
    // quando todos os atributos são exatamente iguais?
    // ou, por exemplo, quando só o id deles são iguais?
    // se também precisarmos que a marca sejam iguais, também devemos acrescentar no nosso equals
    // então isso tem que ser levado em consideração
    // poderiamos passar na verificação do equals abaixo como nulo, mas o proprio equals ja faz a verificação
    return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
  }


  // regras para implementar o hashCode na sobrescrita do codigo
  // se tivermos x.equals(y) == true, y.hashCode() == x.hashCode()
  // se y.hashCode() == x.hashCode(), não necessariamente o equals de y.equals(x) tem que ser true
  // se x.equals(y) == false, o hashCode tem que diferente
  // y.hashCode() != x.hashCode x.equals(y) deverá ser false
  // o que devemos lembrar é: o hashCode é um numero que vai ser gerado, de preferência esse numero tem que unico, para
  // os objetos, se tiver um ou 2 repetidos não tem muito problema, mas quanto mais específico for para cada um dos obj
  // que temos, melhor, a performance vai ser mais alta
  // quando estamos emplementando o hashCode, ele tem que dar um match no equals
  @Override
  public int hashCode() {
    return this.serialNumber == null ? 0 : this.serialNumber.hashCode();
  }


  @Override
  public String toString() {
    return "Smartphone{" +
            "serialNumber='" + serialNumber + '\'' +
            ", marca='" + marca + '\'' +
            '}';
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
}
