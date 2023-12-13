package com.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import com.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Members;
import com.devdojo.maratonajava.javacore.ZZGconcorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
  public static void main(String[] args) {
    Members members = new Members();

    Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
    Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");

    jiraya.start();
    kakashi.start();

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
