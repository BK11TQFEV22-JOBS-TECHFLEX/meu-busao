package controleFrota;

public class Carro {
    private String _placa;        
    private int _chassi;
    private int _velocidadeAtual;

    public Carro(String placa, int chassi) throws IllegalArgumentException {
        validarPlaca(placa);
        validarChassi(chassi);

        _placa = placa;
        _chassi = chassi;
        _velocidadeAtual = 0;
    }

    public Carro(int chassi) throws IllegalArgumentException {
        validarChassi(chassi);

        _chassi = chassi;
        _velocidadeAtual = 0;
    }

    public String getPlaca() {
        return _placa;
    }

    public int getChassi() {
        return _chassi;
    }

    public int getVelocidadeAtual() {
        return _velocidadeAtual;
    }

    void acelerar() {
        _velocidadeAtual++;
    }

    void acelerar(int limite) {  
        for (int i = _velocidadeAtual; i < limite; i++) {
            acelerar();
        }
    }

    public void frear() {
        _velocidadeAtual--;
    }

    @Override
    public String toString() {
        return "Carro [placa=" + _placa + ", chassi=" + _chassi + ", velocidadeAtual=" + _velocidadeAtual + "]";
    }

    private void validarPlaca(String placa) {
        if (placa.length() != 7 || !placa.matches("[A-Z]{3}\\d{4}")) {
            throw new IllegalArgumentException("Placa inválida");
        }
    }

    private void validarChassi(int chassi) throws IllegalArgumentException {
        if (chassi < 1000000 || chassi > 9999999) {
            throw new IllegalArgumentException("Chassi inválido");
        }
    }
}
