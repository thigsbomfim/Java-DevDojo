package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays03 {
  public static void main(String[] args) {
    // formas de inicializar um array
    int[] numeros = new int[5];
    int[] numeros2 = {1,2,3,4,5};
    int[] numeros3 = new int[]{1,2,3,4,5};

    for (int i = 0; i < numeros3.length; i++) {
      System.out.println("For clássico = "+numeros3[i]);
    }

    for(int num:numeros3){
      System.out.println("ForEach = "+num);
    }
  }
}
