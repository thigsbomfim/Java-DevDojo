package com.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import com.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Members;

public class EmailDeliveryService implements Runnable{
  private Members members;
  public EmailDeliveryService(Members members) {
    this.members = members;
  }

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("'"+threadName+ "'-> Iniciando a entrega de e-mails... class('EmailDeliveryService')");

    while(members.isOpen() || members.pendingEmails() > 0){

      try {
        String email = members.retrieveEmail();
        if(email == null) continue;
        System.out.println("'"+threadName + "'-> Enviando o email para "+email+". class('EmailDeliveryService')");
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
