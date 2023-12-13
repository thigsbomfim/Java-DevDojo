package com.devdojo.maratonajava.javacore.ZZFthreads.service;

import com.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;

// Vai ser responsável por enviar os emails da classe Members.
public class EmailDeliveryService implements Runnable{
  private Members members;

  public EmailDeliveryService(Members members) {
    this.members = members;
  }

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("'"+threadName+ "'-> Iniciando a entrega de e-mails... class('EmailDeliveryService')");

    // Agora vem a lógica de negócio.
    // Ele só pode enviar email se estiver aberto ou se a lista de emails for maior que zero.
    // Porque criamos o pendingEmails? Porque não queriamos liberar o acesso, não queria criar um getter para esse
    // members.
    while(members.isOpen() || members.pendingEmails() > 0){
      // Vamos usar um Thread.sleep(2000) para simular como se estivessemos enviando via uma API, ele vai levar 2seg
      // para processar.
      try {
        // Precisamos pegar o email.
        // Chamamos o members.retrieveEmail, que fará o seguinte:
        // Quando executarmos pela primeira vez, ele irá no retrieveEmail e ai ele vai falar "Opa, checando se tem algum
        // email", entrou no bloco sincronizado, o email vai ser zero, o size vai ser zero. Ele vai ver que ainda está
        // aberto e vai falar "Opa, não tem email, vou esperar".
        // E ai quando ele espera, ele dá um release lock, ai a segunda vai entrar no mesmo bloco e "Opa, vai esperar
        // também", ou seja, teremos duas threads esperando.
        String email = members.retrieveEmail();
        // Esse é o caso onde ela esperaria, mas e se ela não esperar? Faremos um if.
        // Se o email for nulo, continue o laço, então ele vai fazer o seguinte:
        // Ele vai dar um continue, ai ele vai voltar na assinatura do while e vai verificar "Opa, membro está aberto?".
        // está, significa que ele vai chamar e vai continuar esperando.
        // A única razão para criar esse continue é que eu quero que ele volte para a assinatura de método, por que
        // quando ele entrar nesse retrieveEmail acima, ele vai continuar esperando lá que não vai ter nada.
        if(email == null) continue;

        // E ai se não for nulo, estaremos enviando o email.
        System.out.println("'"+threadName + "'-> Enviando o email para "+email+". class('EmailDeliveryService')");
        // E ai que vem os dois segundos de espera para enviar.
        Thread.sleep(2000);
        System.out.println("'"+threadName + "'-> Enviou email com sucesso para "+email+
                ". class('EmailDeliveryService')");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
    System.out.println("Todos os emails foram enviados com sucesso!");
  }
}
