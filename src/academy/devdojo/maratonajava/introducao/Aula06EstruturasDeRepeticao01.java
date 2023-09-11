package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01 {
  public static void main(String[] args) {
    int count = 12;
    while(count < 10) {
      ++count;
      System.out.println(count);
      System.out.println("Dentro do while");
    }
    System.out.println(" ");
    count = 0;
    do {
      System.out.println(count);
      System.out.println("Dentro do do-while");
      count++;
    } while (count < 10);

    for(int i=0; i < 10; i++) {
      System.out.println("For "+i);
    }
  }
}
