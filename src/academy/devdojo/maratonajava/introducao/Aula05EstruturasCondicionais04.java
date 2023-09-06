package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais04 {
  public static void main(String[] args) {
    byte dia = 5;
    switch (dia) {
      default:
        System.out.println("Opção inválida");
        break;
      case 1:
        System.out.println("Dom");
        break;
      case 2:
        System.out.println("Seg");
        break;
      case 3:
        System.out.println("Ter");
        break;
      case 4:
        System.out.println("Qua");
        break;
      case 5:
        System.out.println("Qui");
        break;
      case 6:
        System.out.println("Sex");
        break;
      case 7:
        System.out.println("Sáb");
        break;
    }

    char sexo = 'M';
    switch (sexo) {
      default:
        System.out.println("Prefiro não responder");
        break;
      case 'M':
        System.out.println("Homem");
        break;
      case 'F':
        System.out.println("Mulher");
        break;
    }
  }
}
