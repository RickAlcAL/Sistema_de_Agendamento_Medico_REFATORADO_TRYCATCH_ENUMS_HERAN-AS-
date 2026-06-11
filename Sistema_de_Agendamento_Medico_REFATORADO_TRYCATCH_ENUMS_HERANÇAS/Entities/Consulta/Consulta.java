package Sistema_de_Agendamento_Medico.Entities.Consulta;

import Sistema_de_Agendamento_Medico.Entities.Medico.Medico;
import Sistema_de_Agendamento_Medico.Entities.Paciente.Paciente;

public final class Consulta {
    Paciente[] pacientes = {
            new Paciente("42981530722", "Thiago"),
            new Paciente("10564278951", "Mariana"),
            new Paciente("83105426614", "Rodrigo"),
            new Paciente("25739160488", "Beatriz")
    };
    Medico[] medicos = {
            new Medico("Ana Beatriz Fontes", "Cardiologia", new String[]{"08:00", "09:30", "11:00"}, new boolean[]{true, false, true}),
            new Medico("Carlos Eduardo Moreira", "Ortopedia", new String[]{"08:00", "09:30", "11:00"}, new boolean[]{false, true, true}),
            new Medico("Gabriela Neves Toledo", "Dermatologia", new String[]{"08:00", "09:30", "11:00"}, new boolean[]{true, true, true})
    };

    private Paciente pacienteAtual;
    private Medico medicoAtual;

    public Medico getMedicoAtual() {
        return medicoAtual;
    }

    public Paciente getPacienteAtual() {
        return pacienteAtual;
    }

    public boolean verificadorCadastro (String cpf, String nome) {
        boolean temCadastro = false;
        for (Paciente paciente : pacientes){
            if (cpf.equals(paciente.getCpfPaciente()) && nome.equals(paciente.getNomePaciente())) {
                pacienteAtual= paciente;
                temCadastro= true;
                break;
            }
        }
        return temCadastro;
    }
    public boolean verificarEspecialidade(String especializacao) {
        boolean temEspecialidade= false;

        for (Medico medico : medicos) {
            if(especializacao.equals(medico.getEspecialidadeMedico())) {
                medicoAtual= medico;
                temEspecialidade= true;
                break;
            }
        }

        return temEspecialidade;

    }
}
