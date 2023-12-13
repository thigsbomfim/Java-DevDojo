package com.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 3 métodos que temos dentro de todos os objetos, se formos dentro da classe Object, podemos observar
// que dentro dele contém 3 métodos que são chamados de:
// 1° método -> wait
// 2° método -> notify
// 3° método -> notifyAll
// Esses métodos, eles são utilizados para quando estamos trabalhando com multiplas threads.

// Por exemplo, digamos que nós tenhamos um programa que envie emails.
// Então temos um programa, uma thread que é responsável por adicionar emails em uma lista e temos outras threads que
// são responsáveis por pegar os emails dessa lista e enviar esses emails. Mas o problema é o seguinte, quando estamos
// adicionando emails nessa lista, precisamos que essas threads fiquem esperando caso não tenha email, por que se as
// threads não tiverem o que fazer, elas simplesmente vão finalizar e passar para o estado de dead e não temos mais como
// trabalhar com essas threads. Então precisamos que essa thread fique viva enquanto nós quisermos, nós mesmo devemos
// definir a lógica da forma que quisermos.

/**
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO PACOTE ZZFthreads;
 * EXPLICAÇÃO SOBRE LOCK E REENTRANTLOCK
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE A INTERFACE Condition DO PACOTE concurrent.
 * */

public class Members {
  private final Queue<String> emails = new ArrayBlockingQueue<>(10);
  // Utilizando o ReentrantLock ao invés do synchronized, o código fica um pouco mais verboso, pois como podemos ver
  // estamos em todos os métodos tendo que utilizar o try/finally.
  // Nesse caso aqui que estamos utilizando, o synchronized resolveria todos os problemas. Teriamos que fazer uns testes
  // de benchmark para ver se realmente tem algum impacto na performance, se não sempre devemos ir pelo código mais
  // limpo e legível.
  private final ReentrantLock lock = new ReentrantLock();
  // Quando estamos trabalhando com o ReentrantLock, para utilizar o wait e o notify e notifyAll, precisamos utilizar
  // uma classe chamada "Condition" que tem dentro do pacote "concurrent", ela vai ser responsável por trabalhar com as
  // condições do lock, condição de notificar, condição de esperar e assim por diante.
  // Para pegar um condition, nós pegamos uma condição do lock, então ficaria dessa forma, utilizando o método
  // "newCondition".
  // Ele retorna uma condição para aquela instância do lock, se tivessemos mais de um lock, você teria que provavelmente
  // pegar diferentes condições. Então essa condição suporta o wait, notify e notifyAll.
  // Vamos ver um exemplo no método "addMemberEmail"
  private final Condition condition = lock.newCondition();
  private boolean open = true;

  public boolean isOpen(){
    return open;
  }

  public int pendingEmails(){

    // Poderiamos utilizar o próprio reentrantLock ao invés do synchronized
//    synchronized (emails){
//      return emails.size();
//    }
    lock.lock();
    try{
      return emails.size();
    } finally {
      lock.unlock();
    }
  }

  public void addMemberEmail(String email){
    /*
    Ao invés de utilizar o synchronized como estamos fazendo nesse bloco de comentário, poderiamos usar o ReentrantLock
     synchronized (this.emails){
        String threadName = Thread.currentThread().getName();
        System.out.println("'"+threadName + "'-> Adicionou email na lista class('Members')");
        this.emails.add(email);
        this.emails.notifyAll();
     }

    */

    lock.lock();
    try{
      String threadName = Thread.currentThread().getName();
      System.out.println("'"+threadName + "'-> Adicionou email na lista class('Members')");
      this.emails.add(email);

      // Para usar o notify para todas as threads que estão esperando utilizando condition, é dessa forma, utilizando o
      // método "signal" que substitui o "notify" e o "signalAll" que substitui o "notifyAll":
      condition.signalAll();
    } finally {
      lock.unlock();
    }

  }

  public String retrieveEmail() throws InterruptedException {

    /*
    Ao invés de utilizar o synchronized, como estamos fazendo nesse bloco de comentário, poderiamos usar o ReentrantLock
    Como estamos fazendo abaixo desse bloco de comentário.

      synchronized(this.emails.){
        while(this.emails.size() == 0){
          if(!open) return null;
          System.out.println("'"+Thread.currentThread().getName()+
                  "'-> Não tem email disponível na lista, entrando em modo de espera... class('Members')");
          this.emails.wait();
         }
         return this.emails.poll();
      }
    */

    System.out.println("'"+Thread.currentThread().getName()+"'-> Verificando se há e-mails... class('Members')");
    lock.lock();
    try{
      while (this.emails.size() == 0){
        if(!open) return null;
        System.out.println("'"+Thread.currentThread().getName()+
                "'-> Não tem email disponível na lista, entrando em modo de espera... class('Members')");

        // Para dizer para uma thread esperar utilizando o condition, basta utilizar o método await, que é o wait do
        // "ReentrantLock".
        condition.await();
      }
      return this.emails.poll();
    } finally {
      lock.unlock();
    }
  }


  public void close(){
    open = false;

    /*
    Aqui estamos utilizando o synchronized, mas poderiamos usar o "ReentrantLock", como estamos usando abaixo do bloco
    de comentário.

      synchronized (this.emails) {
        System.out.println("'"+Thread.currentThread().getName()+
                "'-> Notificando todu mundo que não estamos mais pegando emails. class('Members')");
      }
    */
    lock.lock();
    try{
      System.out.println("'"+Thread.currentThread().getName()+
              "'-> Notificando todu mundo que não estamos mais pegando emails. class('Members')");
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

}
