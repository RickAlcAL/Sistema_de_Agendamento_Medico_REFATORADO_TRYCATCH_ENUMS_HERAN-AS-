package Sistema_de_Agendamento_Medico.Applications.Menu;

import Sistema_de_Agendamento_Medico.Entities.Consulta.Consulta;
import Sistema_de_Agendamento_Medico.Entities.Enums.Avisos;
import Sistema_de_Agendamento_Medico.Entities.Medico.Medico;
import Sistema_de_Agendamento_Medico.Entities.Enums.OpcaoMenu;
import Sistema_de_Agendamento_Medico.Entities.Enums.Especialidade;
import Sistema_de_Agendamento_Medico.Entities.Enums.StatusAgendamento;

import java.util.Scanner;

public class Menu {
    //Instanciando o Scanner e OBjeto Consulta, para usar em qualquer metodo que eu possa querer
    Scanner sc = new Scanner(System.in);
    Consulta clinica = new Consulta();

    // Menu para iniciar login ou sair do sistema
    public void menuInicial() {
        OpcaoMenu opcaoSelecionada = null; // Uso do Enum OpcaoMenu

        do {
            try {
                System.out.println(
                        "========================================="+
                                "\n Digite a opção que deseja"+
                                "\n1- Marcar consulta"+
                                "\n2- Sair"+
                                "\n========================================="
                );
                char resp = sc.next().charAt(0);
                opcaoSelecionada = OpcaoMenu.deCodigo(resp); // Converte o char para o Enum

                // Switch baseado no Enum deixa o código limpo e legível
                switch (opcaoSelecionada) {
                    case MARCAR_CONSULTA:
                        login();
                        break;
                    case SAIR:
                        System.out.println("fechando o programa");
                        break;
                    default:
                        System.out.println("Digite uma resposta válida!");
                        break;
                }

            }catch (IllegalArgumentException e){
                System.out.println(Avisos.ERRO.getMsgUsuario());
            }
        } while (opcaoSelecionada != OpcaoMenu.SAIR);
    }

    // Menu que contem o processo completo de login
    public void login() {
        boolean continuarMenu = true;
        String nome,cpf = "";
        do {
            try {
                sc.nextLine();
                System.out.println("Digite seu CPF: ");
                try {
                    cpf = sc.nextLine();
                    if (cpf.isEmpty()){
                        System.out.println(Avisos.ERRO.getMsgUsuario());
                        System.out.println("CPF vazio");
                        continuarMenu = false;
                        continue;
                    }
                }catch (IllegalArgumentException e) {
                    System.out.println(Avisos.ERRO.getMsgUsuario());
                    continuarMenu = false;
                    continue;
                }

                System.out.println("Digite seu nome: ");
                try {
                    nome = sc.nextLine();
                    if (nome.isEmpty()){
                        System.out.println(Avisos.ERRO.getMsgUsuario());
                        System.out.println("Nome vazio");
                        continuarMenu = false;
                        continue;
                    }
                }catch (IllegalArgumentException e) {
                    System.out.println(Avisos.ERRO.getMsgUsuario());
                    continuarMenu = false;
                    continue;
                }
                if (!clinica.verificadorCadastro(cpf, nome)) {
                    System.out.println("Paciente não cadastrado!");
                    return;
                }
                menuMarcacao();
            }catch (IllegalArgumentException e){
                System.out.println(Avisos.ERRO.getMsgUsuario());
            }
        }while (continuarMenu);


    }

    // Menu que contem o processo completo para marcar consultas e exibir a consulta marcada
    public void menuMarcacao() {
        boolean confirmacao = true;
        do {
            try {
                System.out.println("Digite a especialidade do médico que deseja se consultar: ");
                String especialidadeDigitada = sc.nextLine();

                // Uso do Enum Especialidade para validar a entrada por texto de forma segura
                if (!Especialidade.existe(especialidadeDigitada) || !clinica.verificarEspecialidade(especialidadeDigitada)) {
                    System.out.println("Não possuímos médicos com esta especialidade, tente novamente!");
                    continue;
                }

                Medico medico = clinica.getMedicoAtual();
                System.out.println(
                        "=========================================\n"+
                                "Digite o número correspondente ao horário você desejaria marcar\n"+
                                medico.exibicaoHorario()
                );
                int horario = sc.nextInt();
                sc.nextLine();
                // Uso do Enum StatusAgendamento para dar feedback ao usuário
                String resultadoAgendamento = medico.agendamentoHorario(horario - 1);

                if (resultadoAgendamento.contains("Não foi possivel")) {
                    System.out.println(StatusAgendamento.ERRO_INDISPONIVEL.getMensagem());
                    confirmacao = false;
                } else {
                    System.out.println(StatusAgendamento.SUCESSO.getMensagem());
                    System.out.println(resultadoAgendamento); // Printa os dados da consulta que seu método já gerava
                    confirmacao = true;
                }
            }catch (IllegalArgumentException e){
                System.out.println(Avisos.ERRO.getMsgUsuario());
                sc.nextLine();
            }
        }while (confirmacao);

    }
}