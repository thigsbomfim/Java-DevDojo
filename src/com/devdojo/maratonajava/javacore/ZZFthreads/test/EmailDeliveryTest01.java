package com.devdojo.maratonajava.javacore.ZZFthreads.test;

import com.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;
import com.devdojo.maratonajava.javacore.ZZFthreads.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
  public static void main(String[] args) {
    // Quando executarmos o código abaixo, o método run vai ser executado, que está na classe "EmailDeliveryService".
    // Ele vai verificar "Está aberto?" está, por que por padrão ele está aberto.
    // Ele vai pedir o retrieveEmail. Chegando no retrieveEmail, ele vai falar "Checando se tem email", o email vai ser
    // igual a zero, pois ainda não temos email.
    // Então ele está aberto ainda, ele imprimirá que não tem emails disponíveis e vai para a linha para fazer a thread
    // esperar.
    // Beleza, então a thread esperou, agora a segunda thread será executada, a thread "kakashi" fará o mesmo processo.

    // Agora temos duas threads esperando um email ser adicionado.
    // É agora que vem a parte que nós vamos entrar com um email "Entrei com um email", adicionamos um email utilizando
    // o addMemberEmail.
    // No momento que utilizarmos esse método, a thread que está sendo executada irá no método "addMemberEmail" e irá
    // dizer "Thread tal, adicionou email na lista" e depois vai modificar todas as threads que estão esperando.
    // Então quando dermos um notifyAll no método "addMemberEmail", as threads que estão esperando "this.emails.wait()"
    // no método "retrieveEmail", no bloco sincronizado, irão sair, ou seja, elas irão voltar para a assinatura do while
    // no método "retrieveEmail", uma delas irá continuar esperando e a outra vai continuar e verificar na assinatura do
    // while, "this.emails.size() é igual a zero?" "Opa, agora não é igual a zero", então ele não vai cair no while, ele
    // vai cair no "return this.emails.poll()". Quando ele cair no return, ele irá retornar para onde está sendo chamado
    // na variavel de referência email com o valor do método "retrieveEmail", da classe EmailDeliveryService dentro do
    // método "run", irá retornar o valor para o "retrieveEmail".
    // Ele vai verificar se o email é nulo. Se for nulo, vai continuar o laço e verificar tudo novamente no método "run"
    // da classe "EmailDeliveryService".
    // Se não, ele vai enviar o email e em seguida, vai dormir por 2 segundos, vai mandar a mensagem "enviou email com
    // sucesso para *****".

    // E ai, agora estamos dentro de outro while da classe "EmailDeliveryService" no método "run".
    // "Ainda está aberta a quantidade de emails?" está, "Beleza", ele vai voltar para o bloco try/catch do método "run"
    // vai chamar o "retrieveEmail", ai a thread vai cair denovo dentro do método "retrieveEmail", só que dessa vez
    // o email vai ser zero e vai dormir.


    // Quando execurtamos, podemos ver que a thread "main" é a primeira pois ela que está executando a telinha de input.
    // Ela adiciona um email na lista, ai como notificou todos, mas a thread que deu sorte de pegar foi o jiraya.
    // Ai o jiraya começou enviar o email para o destinatario.
    // Enviou com sucesso.
    // O jiraya vai voltar a checar "Opa, tem mais algum email?" não tem, "Po, vou ter que entrar em modo espera".

    // Se inserirmos um novo email, a main irá adicionar novamente, kakashi agora irá enviar email e o jiraya viu que
    // não tem email disponível na lista para ser enviado, kakashi enviou com sucesso e depois vê que não tem mais email
    // disponível na lista.

    Members members = new Members();
    // Esses serão os caras que irão entregar os emails, as threads.
    // Mas ainda não temos emails, precisamos criar.
    Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
    Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");

    jiraya.start();
    kakashi.start();

    // Estamos criando um while como true.
    while(true){
      // Ainda não estudamos Swing mas podemos fazer o seguinte, podemos usar o JOptionPane para mostrar um painel para
      // gente.
      // Utilizando o método showInputDialog para colocar uma mensagem, e não veremos swing nesse curso, somente aqui.
      String email = JOptionPane.showInputDialog("Entre com o seu email");
      // Se o email for nulo ou a pessoa não entrou com o email, significa que queremos parar o programa.
      if(email == null || email.isEmpty()){
        // Colocando o atributo "open" como fechado, para deixar as threads esperando.
        members.close();
        break;
      }

      // Se estiver email, queremos adicionar.
      members.addMemberEmail(email);
    }
  }
}
