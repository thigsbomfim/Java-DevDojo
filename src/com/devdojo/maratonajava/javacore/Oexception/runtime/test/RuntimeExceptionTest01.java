package com.devdojo.maratonajava.javacore.Oexception.runtime.test;

// O que devemos lembrar é que exceções não são erros, aqui está a hierarquia dos erros:
/*
* Throwable
*   |    |
*   |    |__________
* Error            |
*              Exception
*               |     |
*               |     |
*        _______|     |___________________
*        |                               |_______________(Checked)
* RuntimeException(Unchecked)                                |
*        |                                              IOException
*        |                                              SQLException
* NullPointerException                                  MalformedURLException
* ArrayIndexOutOfBoundsException
* NumberFormatException
* ClassCastException
*        ...
* */

/*
 * Checked -> Exceções que são checadas, que são filhas da classe Exception diretamente, e essas exceções se não
 * forem tratadas, elas vão lançar um erro em tempo de compilação.
 * ex.: Quando você está trabalhando com arquivos, se você fizer uma coisa relacionada a arquivos, provavelmente
 * irão lançar o IOException, se você não fizer uma tratativa, o código não irá compilar

 * Quando temos uma checked excepetion, obrigatoriamente precisamos fazer um tratamento delas, se não fizermos
 * o código não irá compilar
*/

/*
 * Unchecked -> São exceções que são filhas ou a classe RuntimeException para baixo, ou seja,
 * as subclasses de RuntimeException
 * são exceções que quando são lançadas pelo programa, nós temos também a opção de lançar uma exceção, mas quando
 * é o programa que lança, quase sempre o problema somos nós, nós que desenvolvemos algo que tá errado ou que não
 * fizemos uma tratativa que deveria ter feito
 *
 * o que precisamos lembrar de RuntimeException é que elas são do tipo unchecked, não precisamos fazer um tratamento,
 * não é obrigatorio tratarmos ela, mas precisamos
 * */
public class RuntimeExceptionTest01 { // Geralmente é algum erro do programador
  public static void main(String[] args) {
    // Checked e Unchecked

    Object object = null;
    // RuntimeExceptin -> NullPointerException -> pois não existe nenhum objeto
    System.out.println(object.toString());

    int[] nums = {1, 2};
    // RuntimeException -> ArrayIndexOutOfBoundsException -> não existe essa posição do array
    System.out.println(nums[2]);

  }
}
