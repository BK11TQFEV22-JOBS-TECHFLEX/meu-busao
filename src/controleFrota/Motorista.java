package controleFrota;

public class Motorista {
    private String _nome;
    private int _matricula;
    private String _cnh;
    private Carro _carro;

    public Motorista(String nome, int matricula, String cnh, Carro carro) {
        _nome = nome;
        _matricula = matricula;
        _cnh = cnh;
        _carro = carro;
    }

    public String getNome() {
        return _nome;
    }

    public int getMatricula() {
        return _matricula;
    }

    public String getCnh() {
        return _cnh;
    }

    public Carro getCarro() {
        return _carro;
    }

    @Override
    public String toString() {
        return "Motorista [nome=" + _nome + ", matricula=" + _matricula + ", cnh=" + _cnh + ", carro=" + _carro + "]";
    }

    public void acelerar() {
        _carro.acelerar();
    }

    public void acelerar(int limite) {
        _carro.acelerar(limite);
    }
}
