import java.util.InputMismatchException;
import java.util.Scanner;

import controleFrota.Impl.Carro;
import controleFrota.Impl.Motorista;
import controleFrota.Impl.Passageiro;

public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Motorista[] _motoristas = new Motorista[TAMANHO_INICIAL_LISTAS];
    private static int _numeroMotoristas = 0;

    public static void main(String[] args) throws Exception {
        int opcao = 0;
        do {
            imprimirMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 9);


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

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1: {
                cadastrarMotorista();
                break;
            }
            default: {
                System.out.println("Ainda não implementado!");
                break;
            }
        }
    }

    private static void adicionarMotoristaNaLista(Motorista motorista) {
        if (_numeroMotoristas == _motoristas.length) {
            Motorista[] novaLista = new Motorista[_motoristas.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _motoristas.length; i++) {
                novaLista[i] = _motoristas[i];
            }

            // Substituo a lista antiga pela nova.
            _motoristas = novaLista;
        }

        // Adiciono o motorista a lista.
        _motoristas[_numeroMotoristas] = motorista;
        _numeroMotoristas++;
    }

    private static void cadastrarMotorista() throws InputMismatchException {
        System.out.println("Cadastro de motoristas");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Matricula: ");
        int matricula = Integer.parseInt(scanner.nextLine());
        System.out.println("CNH: ");
        String cnh = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        Motorista motorista = new Motorista(nome, matricula, cnh, cpf);
        adicionarMotoristaNaLista(motorista);
    }

    private static void imprimirMenu() {
        System.out.println("Cadastro de carros!");
        System.out.println("1 - Cadastrar motorista");
        System.out.println("2 - Cadastrar carro");
        System.out.println("3 - Cadastrar passageiro");
        System.out.println("4 - Acelerar carro");
        System.out.println("5 - Acelerar carro até um limite");
        System.out.println("9 - Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 5) || opcao == 9;
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}
