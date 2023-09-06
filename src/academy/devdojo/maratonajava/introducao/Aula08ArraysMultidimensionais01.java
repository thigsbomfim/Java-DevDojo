package academy.devdojo.maratonajava.introducao;

public class Aula08ArraysMultidimensionais01 {
  public static void main(String[] args) {
    // 1,2,3,4,5 Meses
    // 31, 28, 31, 30 dias

    // um array normal de inteiros, que é somente um array com os indices [0,1,2]
    int[] dias = new int[3];

    // array multidimensional, que o primeiro array faz referencia a outros 3 arrays
    // ficaria assim na lógica: [array1, array2, array3] -> array1[0,0,0] array2[0,0,0] array3[0,0,0]
    int[][] dias01 = new int[3][3];
    dias01[0][0] = 31;
    dias01[0][1] = 28;
    dias01[0][2] = 31;

    dias01[1][0] = 31;
    dias01[1][1] = 28;
    dias01[1][2] = 31;

    dias01[2][0] = 31;
    dias01[2][1] = 28;
    dias01[2][2] = 31;

    for (int i = 0; i < dias01.length; i++) {
      for (int j = 0; j < dias01[i].length; j++) {
        System.out.println(dias01[i][j]);
      }
    }

    System.out.println("------------------------");

    for(int[] arrBase:dias01){
      for(int num: arrBase){
        System.out.println(num);
      }
    }
  }
}
