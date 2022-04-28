package controleFrota.Impl;

public class Carro {
    private String _letrasPlaca;    
    private int _numerosPlaca;    
    private int _chassi;
    private int _velocidadeAtual;
    private Motorista _motorista;

    public Carro(String placa, int chassi, Motorista motorista) throws IllegalArgumentException {
        this(chassi, motorista);
        validarPlaca(placa);
        _letrasPlaca = placa.substring(0, 3);
        _numerosPlaca = Integer.parseInt(placa.substring(3));
    }

    public Carro(int chassi, Motorista motorista) throws IllegalArgumentException {
        validarChassi(chassi);

        _chassi = chassi;
        _velocidadeAtual = 0;
        _motorista = motorista;
        _motorista.setVeiculo(this);
    }

    public String getPlaca() {
        return _letrasPlaca + _numerosPlaca;
    }

    public int getChassi() {
        return _chassi;
    }

    public int getVelocidadeAtual() {
        return _velocidadeAtual;
    }

    public Motorista getMotorista() {
        return _motorista;
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
        return "Carro [placa=" + getPlaca() + ", chassi=" + _chassi + ", velocidadeAtual=" + _velocidadeAtual + "]";
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
