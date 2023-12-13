package com.devdojo.maratonajava.javacore.ZZFthreads.dominio;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

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
 * EXPLICAÇÃO SOBRE O QUE É THREAD NO ARQUIVO ThreadTest01;
 * EXPLICAÇÃO DOS ESTADOS DA THREAD NO ARQUIVO ThreadTest02;
 * EXPLICAÇÃO DE PRIORIDADES E COMO COLOCAR UMA THREAD PARA DORMIR NO ARQUIVO ThreadTest03;
 * EXPLICAÇÃO SOBRE THREAD SAFE ESTÁ NO ARQUIVO ThreadSafeTest01;
 * EXPLICAÇÃO SOBRE DEADLOCK ESTÁ NO ARQUIVO DeadlockTest01;
 * EXPLICAÇÃO SOBRE wait, notify E notifyAll ESTÁ NO ARQUIVO Members DO PACOTE dominio;
 * EXPLICAÇÃO SOBRE yield E join ESTÁ NO ARQUIVO ThreadTest04;
 * ESSE ARQUIVO ESTÁ A EXPLICAÇÃO SOBRE wait, notify E notifyAll.
 * */

public class Members {
  // ArrayBlockingQueue é um array do tipo thread safe
  // Lembrando que queremos o email na ordem e estamos utilizando o Queue
  // Temos que passar a capacidade como primeiro argumento do ArrayBlockingQueue que define qual vai ser o limite.
  private final Queue<String> emails = new ArrayBlockingQueue<>(10);
  // Abaixo estamos criando o open por que não podemos só utilizar se a lista tem email ou não, se ela chegar como zero
  // a lógica while(0) vai simplesmente fechar as threads, esse open é como se fosse uma chave para abrir e fechar
  // a classe para receber ou não emails
  private boolean open = true;

  // Retorna se está aberto ou fechado.
  public boolean isOpen(){
    return open;
  }

  // Retorna o size, se nós temos algum email ainda esperando para ser enviado.
  // Lembrando, apesar da lista ser sincronizada, nós precisamos sincronizar a camada que está acima, nesse caso,
  // vamos sincronizar o objeto emails, significa que duas threads não podem acessar ao mesmo tempo esse objeto.
  // Então como temos o modificador final atribuido ao atributo emails, significa que se estivermos utilizando o único
  // objeto da classe Members, esse email sempre vai ser acessado por apenas uma thread.
  // Esse método retorna a quantidade de emails.
  public int pendingEmails(){
    synchronized (emails){
      return emails.size();
    }
  }

  // Método para adicionar emails
  public void addMemberEmail(String email){
    // Aqui também iremos sincronizar o objeto, para uma thread acessar por vez
    synchronized (this.emails){
      String threadName = Thread.currentThread().getName();
      System.out.println("'"+threadName + "'-> Adicionou email na lista class('Members')");
      // Estamos adicionando, mas lembra que falamos que teriamos outras threads esperando, precisamos notificar essas
      // threads.
      this.emails.add(email);

      // Criando a lógica de negócio a partir da explicação sobre o wait no método retrieveEmail abaixo.
      // Podemos observar que temos notify e notifyAll.
      // O notify irá avisar para apenas uma thread que foi criado um email, onde não podemos saber para qual thread irá
      // avisar.
      // O notifyAll irá avisar para todas as threads que foi criado um email.
      // Esse código abaixo diz "Tem email, vocês se virem para ver quem é que vai entrar no método sincronizado para
      // começar a trabalhar".
      this.emails.notifyAll();
    }
  }

  // Quem chamar esse método, vai checar se contém emails.
  public String retrieveEmail() throws InterruptedException {
    // Estamos pegando duas vezes os nomes das threads pois a thread que entrou dentro desse método pode não ser a mesma
    // que vai entrar dentro do bloco de synchronized abaixo.
    System.out.println("'"+Thread.currentThread().getName()+"'-> Verificando se há e-mails... class('Members')");
    // Chamando o synchronized com emails
    // O que estamos fazendo nesse synchronized é o seguinte, estamos verificando o tamanho da quantidade de emails
    // que contém na nossa lista de emails.
    // Se for igual a zero, primeiro iremos verificar se o atributo "open" está como false/fechado.
    // Se estiver iremos retornar nulo.
    // Se não estiver como false/fechado quer dizer que está como true/aberto, iremos então executar um print mostrando
    // que não contém emails disponíveis na lista. Em seguida, colocaremos a thread que está executando esse bloco
    // sincronizado em modo de espera usando wait.
    // Usamos o wait pela própria lista pois a lista é uma thread safe.
    synchronized (this.emails){
      // Aqui vem a lógica de negócios, por que se não tiver emails, eu não quero que esse método feche, que esse método
      // pare.
      // Se você não tiver emails, quero que as threads fiquem esperando
      while(this.emails.size() == 0){
        // Se o open não estiver aberto, eu quero que simplesmente que você retorne nulo.
        if(!open) return null;
        // Se não conter emails, o que eu quero que as threads façam? isso que veremos abaixo
        // podemos dizer que não contém email por que o tamanho do emails.size é zero e o atributo open não está aberto.
        System.out.println("'"+Thread.currentThread().getName()+
                "'-> Não tem email disponível na lista, entrando em modo de espera... class('Members')");
        // Como podemos dizer para essa thread entrar em modo de espera? É ai que precisamos falar "Thread que está
        // executando esse this.emails, você precisa ficar de boas".
        // Duas coisas que precisamos tomar cuidado:
        // Primeiro, quando chamamos esse wait, precisamos tratar essa exceção que ocorre InterruptedException, onde
        // estamos tratando na assinatura do método.
        // Segundo, só podemos chamar o wait se tivermos o lock do objeto, pois não podemos esperar se não tivermos o
        // lock do objeto, ou seja, nesse caso aqui, todas as vezes que formos chamar o wait, teremos que estar
        // obrigatoriamente dentro de um bloco de synchronized/bloco sincronizado.
        // E ai essa thread vai ficar esperando até ela ser notificada.
        // Lembrando que se estiver mais de uma thread, todas elas ficarão esperando.
        // Agora que nós colocamos para esperar, precisamos falar para a galera que está esperando, para acordar.
        // Iremos criar a lógica de negócio no método addMemberEmail acima.
        this.emails.wait();
      }
      // E caso o tamanho de emails não seja zero, retornaremos o primeiro elemento da lista e remover a lista com poll
      return this.emails.poll();
    }
  }

  // Agora precisamos fechar a lista, se nós quisermos.
  public void close(){
    // Fechando o atributo.
    open = false;
    // Quando usamos o notifyAll, também precisamos estar em um contexto sincronizado para conseguirmos fechar o
    // atributo "open".
    synchronized (this.emails) {
      System.out.println("'"+Thread.currentThread().getName()+
              "'-> Notificando todo mundo que não estamos mais pegando emails. class('Members')");
      this.emails.notifyAll();
    }
  }

}
