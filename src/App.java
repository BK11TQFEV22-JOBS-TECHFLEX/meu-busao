import controleFrota.Carro;
import controleFrota.Motorista;

public class App {
    public static void main(String[] args) throws Exception {
        Motorista seuJuarez = new Motorista("Juarez", 1234567, "A1B2C3D4");
        Carro fusca = new Carro("BKF1234", 7755443, seuJuarez);

        System.out.println("PASSAGEIRO: Motorista, acelera o carro até 100Km/h!");
        System.out.println("MOTORISTA: Ok! Vamos lá!");
        fusca.getMotorista().acelerar(100);

        System.out.printf("Velocidade do carro: %d Km/h\n", fusca.getVelocidadeAtual());
    }
}
