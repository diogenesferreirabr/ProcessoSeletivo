package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

        static void entrandoEmContato(String candidato ){
            int tentativasRealizdas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;
            do {
                atendeu= atender();
                continuarTentando = !atendeu;
                if (continuarTentando)
                    tentativasRealizdas++;
                else
                    System.out.println("Contato realizado com sucesso");
                //elas precisarão sofrer alterações pra nao virar loop
            }while (continuarTentando && tentativasRealizdas <3);
            if (atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizdas + " TENTATIVA");
            else
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " +  tentativasRealizdas + " REALIZADA");

        }

        // metodo auxiliar
        static boolean atender (){
            return new Random().nextInt(3)==1;
        }



    static  void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato nº " + (indice+1) + " e " + candidatos[indice]);

        }

        System.out.println("Forma abreviada de interação for each");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);

        }
    }

    static  void selecaoCandidatos (){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual=0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato(a) " + candidato + " solicitou este valor de salario " + salarioPretendido);
            if ( salarioBase >= salarioPretendido){
                System.out.println("o candidato(a) " + candidato + " foi selecionadopara a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato (double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");

        }else if (salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
        else {
            System.out.println("AGUARDANDO RESULTADOS DOS DEMAIS CANDIDATOS");
        }
    }
}
