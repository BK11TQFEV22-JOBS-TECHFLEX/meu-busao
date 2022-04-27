package controleFrota.Impl;

import controleFrota.Pessoa;

public class Passageiro extends Pessoa {

    private String _codigoCliente;

    public Passageiro(String nome, String cpf, String codigoCliente) {
        super(nome, cpf);
        _codigoCliente = codigoCliente;
    }    

    public String getCodigoCliente() {
        return _codigoCliente;
    }

    @Override
    public String getTipo() {
        return "Passageiro";
    }
}
