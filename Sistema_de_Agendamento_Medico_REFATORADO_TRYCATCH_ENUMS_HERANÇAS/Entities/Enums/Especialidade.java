package Sistema_de_Agendamento_Medico.Entities.Enums;

public enum Especialidade {
    CARDIOLOGIA,
    ORTOPEDIA,
    DERMATOLOGIA;

    // Método auxiliar para validar se o texto digitado bate com algum Enum (ignorando maiúsculas/minúsculas)
    public static boolean existe(String nome) {
        for (Especialidade e : values()) {
            if (e.name().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
}