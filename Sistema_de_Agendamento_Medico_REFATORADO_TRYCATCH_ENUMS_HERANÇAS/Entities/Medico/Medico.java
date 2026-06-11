package Sistema_de_Agendamento_Medico.Entities.Medico;

import Sistema_de_Agendamento_Medico.Entities.Paciente.Paciente;

public class Medico extends Paciente {
    private String nomeMedico;
    private String especialidadeMedico;
    private String [] horarioMedico;
    private boolean [] disponibilidadeMedico;

    public Medico (String nomeMedico, String especialidadeMedico, String [] horarioMedico, boolean[] disponibilidadeMedico) {
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.horarioMedico = horarioMedico;
        this.disponibilidadeMedico = disponibilidadeMedico;
    }

    public Medico(String cpfPaciente, String nomePaciente, String nomeMedico, String especialidadeMedico, String[] horarioMedico, boolean[] disponibilidadeMedico) {
        super(cpfPaciente, nomePaciente);
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.horarioMedico = horarioMedico;
        this.disponibilidadeMedico = disponibilidadeMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public String exibicaoHorario () {
        String dadosMedicos =
                "Nome do medico: " + nomeMedico +
                        "\nEspecialidade: " + especialidadeMedico +
                        "\nHorários disponiveis: \n";


        String horariosDisponiveis = "";

        for (int i = 0; i < horarioMedico.length; i ++){
            if (disponibilidadeMedico[i]){
                horariosDisponiveis += String.format(i+1+"- "+horarioMedico[i]+"\n");
            }
        }
        if (horariosDisponiveis.equals("")){
            horariosDisponiveis = "Não há horarios";
        }

        return  dadosMedicos + horariosDisponiveis;
    }

    public String agendamentoHorario (int index) {
        if (index >= 0 && index < disponibilidadeMedico.length && disponibilidadeMedico[index]){
            disponibilidadeMedico[index] = false;
            return String.format(
                    "\nConsulta agendada " +
                    "\nNome do Profissional: " + nomeMedico +
                    "\nEspecialidade:" + especialidadeMedico +
                    "\nHorário: " + horarioMedico[index]);
        }else {
            return "Não foi possivel agendar consulta";
        }
    }
}
