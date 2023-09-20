package candidatura;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
  public static void main(String[] args) {

    String[] candidatos = {"FELIPE" , "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

    for (String candidato : candidatos) {
      entrandoEmContato(candidato); 
    }
  }

  public static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuaTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuaTentando = !atendeu;

      if (continuaTentando) {
        tentativasRealizadas++;
      } else {
        System.out.println("CONTATO REALIZADO COM SUCESSO"); 
      }
    } while (continuaTentando && tentativasRealizadas < 3);

    if (atendeu) {
      System.out.println("CONSEGUIMOS CONTATO COM O " + candidato + " NA " + tentativasRealizadas + " TENTATIVA(S)");
    } else {
      System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }
  }

  public static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  public static void imprimirSelecionados() {
    String[] candidatos = {"FELIPE" , "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

    System.out.println("Imprimindo a lista de candidatos: ");

    for (int i = 0; i < candidatos.length; i++) {
      System.out.println("Candidato nº: " + candidatos[i]);
    }
  }

  public static void selecaoCandidatos() {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.0;

    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
      String candidato = candidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatoAtual++;
    }
  }

  public static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  public static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;

    if (salarioBase > salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO");
    } else if (salarioBase == salarioPretendido) {
      System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
    }
    else {
      System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
  }
}
