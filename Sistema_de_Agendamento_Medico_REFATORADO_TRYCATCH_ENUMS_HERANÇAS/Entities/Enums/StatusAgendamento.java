package Sistema_de_Agendamento_Medico.Entities.Enums;

public enum StatusAgendamento {
    SUCESSO("\nConsulta agendada com sucesso!"),
    ERRO_INDICE_INVALIDO("Não foi possível agendar: Horário selecionado é inválido."),
    ERRO_INDISPONIVEL("Não foi possível agendar: Horário não está mais disponível.");

    private final String mensagem;
    //Construtor para inserir uma mensagem
    StatusAgendamento(String mensagem) {
        this.mensagem = mensagem;
    }
    //Metodo usado para colocar a mensagem auxliar
    public String getMensagem() {
        return mensagem;
    }
}