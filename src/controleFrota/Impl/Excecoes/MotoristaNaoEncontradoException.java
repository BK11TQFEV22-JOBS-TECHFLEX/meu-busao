package controleFrota.Impl.Excecoes;

public class MotoristaNaoEncontradoException extends Exception {
    public MotoristaNaoEncontradoException(String cpf) {
        super("Não foi possível encontrar o motorista com o CPF: " + cpf);
    }   
}
