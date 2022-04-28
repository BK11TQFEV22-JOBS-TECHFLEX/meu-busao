import java.util.ArrayList;

import controleFrota.Impl.Carro;
import controleFrota.Impl.Motorista;
import controleFrota.Impl.Passageiro;

public class App {
    public static void main(String[] args) throws Exception {
        Passageiro passageiro = new Passageiro("João", "123.456.789-00", "12345");
        System.out.println(passageiro);

        Motorista seuJuarez = new Motorista("Juarez", 1234567, "A1B2C3D4", "123.456.789-00");
        Carro fusca = new Carro("BKF1234", 7755443, seuJuarez);

        System.out.println("PASSAGEIRO: Motorista, acelera o carro até 100Km/h!");
        System.out.println("MOTORISTA: Ok! Vamos lá!");
        fusca.getMotorista().acelerar(100);

        System.out.printf("Velocidade do carro: %d Km/h\n", fusca.getVelocidadeAtual());
        System.out.printf("Habilitação do motorista %s: %s", seuJuarez.getNome(), seuJuarez.getCnh());
    }
}
