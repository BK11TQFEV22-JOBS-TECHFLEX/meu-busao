package controleFrota.Impl;

import controleFrota.Acelerador;
import controleFrota.Autenticavel;
import controleFrota.Pessoa;

public class Motorista extends Pessoa implements Acelerador, Autenticavel {
    private int _matricula;
    private String _cnh;
    private Carro _veiculo;

    public Motorista(String nome, int matricula, String cnh, String cpf) {
        super(nome, cpf);
        _matricula = matricula;
        _cnh = cnh;
    }

    public int getMatricula() {
        return _matricula;
    }

    public String getCnh() {
        return _cnh;
    }

    public Carro getVeiculo() {
        return _veiculo;
    }

    public void setVeiculo(Carro carro) {
        _veiculo = carro;
    }

    @Override
    public String toString() {
        return super.toString() + ":[matricula=" + _matricula + ", cnh=" + _cnh + ", carro=" + _veiculo + "]";
    }

    @Override
    public String getTipo() {
        return "Motorista";
    }

    @Override
    public void acelerar() throws NullPointerException {
        if (_veiculo == null) {
            throw new NullPointerException("Motorista não possui carro!");
        }
                
        _veiculo.acelerar();
    }

    @Override
    public void acelerar(int limite) throws NullPointerException {
        if (_veiculo == null) {
            throw new NullPointerException("Motorista não possui carro!");
        }

        _veiculo.acelerar(limite);
    }

    @Override
    public String obterCredenciais() {
        return String.valueOf(_matricula);
    }
}
