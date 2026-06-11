package Sistema_de_Agendamento_Medico.Entities.Enums;

public enum Avisos {
    CONFIRMADO ("Confirmado... um momento"),
    AGUARDE ("Aguarde um momento..."),
    ERRO ("Erro... tente novamente");

    private final String msgUsuario;

    Avisos (String msgUsuario){
        this.msgUsuario = msgUsuario;
    }

    public String getMsgUsuario() {
        return msgUsuario;
    }
}
