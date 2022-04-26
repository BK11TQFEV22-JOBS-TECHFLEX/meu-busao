package controleFrota;

public class Motorista {
    private String _nome;
    private int _matricula;
    private String _cnh;
    private Carro _veiculo;

    public Motorista(String nome, int matricula, String cnh) {
        _nome = nome;
        _matricula = matricula;
        _cnh = cnh;
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

    public Carro getVeiculo() {
        return _veiculo;
    }

    public void setVeiculo(Carro carro) {
        _veiculo = carro;
    }

    @Override
    public String toString() {
        return "Motorista [nome=" + _nome + ", matricula=" + _matricula + ", cnh=" + _cnh + ", carro=" + _veiculo + "]";
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
