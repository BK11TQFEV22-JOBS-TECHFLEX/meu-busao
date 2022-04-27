package controleFrota.Impl;

import controleFrota.Pessoa;

public class Motorista extends Pessoa {
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

    public void acelerar() {
        if (_veiculo == null) {
            throw new NullPointerException("Motorista não possui carro!");
        }
                
        _veiculo.acelerar();
    }

    public void acelerar(int limite) {
        if (_veiculo == null) {
            throw new NullPointerException("Motorista não possui carro!");
        }

        _veiculo.acelerar(limite);
    }
}
