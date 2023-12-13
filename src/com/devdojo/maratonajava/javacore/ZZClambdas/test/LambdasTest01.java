package com.devdojo.maratonajava.javacore.ZZClambdas.test;

// Lambdas, para elas funcionarem, elas precisam obrigatoriamente que a interface que estamos trabalhando, seja uma
// interface funcional.
// o que é uma interface funcional?
// uma interface funcional é onde temos apenas um método abstrato.
// na aula sobre ComportamentoPorParametroTest03, trabalhamos com o CarPredicate e o Predicate.
// Predicate faz parte do pacote java.util.function.
// Quando observarmos dentro da interface Predicate, temos apenas 1 método que é abstrato, o resto todos utilizam o
// default.
// então como essa interface abaixo, é uma interface funcional, não podemos criar outro método dentro dela a não ser
// que seja um método default.
@FunctionalInterface
interface ObjPredicate {

  // as lambdas são anonimas
  // são chamadas de funções, pq não estão atreladas a nenhuma classe
  // temos a lambda sendo executada diretamente dentro de um método
  // e o objetivo é fazer o código ser mais conciso, o fato da lambda reduzir a quantidade de código ja diz por si só
  // quanto ela é concisa.
  // O que devemos lembrar é que, qualquer interface funcional, nós podemos utilizar lambdas.
  // para utilizarmos lambdas, precisamos de uma interface funcional, uma interface funcional é uma interface onde temos
  // apenas 1 método abstrato, sem corpo. Podemos ter outros métodos, mas eles obrigatoriamente precisam ser default
  // o proprio da interface funcional diz como a lambda vai se comportar, esse é o contrato da lambda.
  // aqui estamos falando que tem que retornar um boolean, e que estamos recebendo um argumento que é um objeto
  boolean test(Object obj);
  // se tentarmos criar outro método, irá gerar um erro na annotations "FunctionalInterface" dizendo que não é uma
  // classe funcional
//  boolean test2(Object obj);

  // quando estavamos trabalhando com a lambda, tinhamos um lado que era:
  // tinhamos um parâmetro e nós tinhamos a expressão, o corpo daquela lambda, que poderia ou não retornar alguma coisa
//  (parametro) -> <expressão>
  // como nós temos aqui, o que chamamos de functional descriptor, que é basicamente o que diz como a lambda tem que
  // se comportar, toda a informação que precisamos está aqui, por exemplo:
  // parametro    expressão
  // (Car car) -> car.getColor().equals("green");
  // a expressão vai retornar um boolean
  // podemos abreviar as coisas, utilizando apenas car, não precisamos de parenteses
  // car -> car.getColor().equals("green");
}

public class LambdasTest01 {
}
