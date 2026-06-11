package Sistema_de_Agendamento_Medico.Entities.Enums;

public enum OpcaoMenu {
    MARCAR_CONSULTA('1'),
    SAIR('2'),
    INVALIDA('0');

    private final char codigo;
    //Criando um construtor para fazer impressão
    OpcaoMenu(char codigo) {
        this.codigo = codigo;
    }
    //Adicionando um metodo para exibir a impressão
    public char getCodigo() {
        return codigo;
    }

    // Converte o caractere digitado pelo usuário no Enum correspondente
    public static OpcaoMenu deCodigo(char codigo) {
        for (OpcaoMenu opcao : values()) {
            if (opcao.getCodigo() == codigo) {
                return opcao;
            }
        }
        return INVALIDA;
    }
}