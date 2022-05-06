import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controleFrota.Acelerador;
import controleFrota.Impl.Autenticador;
import controleFrota.Impl.Carro;
import controleFrota.Impl.Motorista;
import controleFrota.Impl.Excecoes.MotoristaNaoEncontradoException;

public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Motorista[] _motoristas = new Motorista[TAMANHO_INICIAL_LISTAS];
    private static int _numeroMotoristas = 0;
    private static Carro[] _carros = new Carro[TAMANHO_INICIAL_LISTAS];
    private static int _numeroCarros = 0;

    public static void main(String[] args) throws Exception {
        // TODO: Criar menu para autenticar um motorista ou um carro.

        Motorista mot = new Motorista("José", 123, "12345", "12345678901");
        Carro car = new Carro("ABC1234", 1234578, mot);

        Autenticador autenticador = new Autenticador();
        boolean motoristaAutenticado = autenticador.autenticar(mot);
        System.out.println(motoristaAutenticado);

        boolean carroAutenticado = autenticador.autenticar(car);
        System.out.println(carroAutenticado);

        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarMotorista();
                break;
            }
            case 2: {
                cadastrarCarro();
                break;
            }
            case 4: {
                ArrayList<Acelerador> aceleradores = new ArrayList<Acelerador>();
                for (int i = 0; i < _numeroMotoristas; i++) {
                    if (_motoristas[i] != null) {
                        aceleradores.add(_motoristas[i]);
                    }
                }

                for (int i = 0; i < _numeroCarros; i++) {
                    if (_carros[i] != null) {
                        aceleradores.add(_carros[i]);
                    }
                }

                for (Acelerador acelerador : aceleradores) {
                    acelerador.acelerar();
                    System.out.println("Acelerando como: " + acelerador);
                }

                break;
            }
            case 7: {
                listarMotoristas();
                break;
            }
            case 8: {
                listarCarros();
                break;
            }
            case 9: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            default: {
                System.out.println("Ainda não implementado!");
                break;
            }
        }

        return true;
    }

    private static void listarMotoristas() {
        System.out.println("Lista de motoristas cadastrados:");
        for (int i = 0; i < _numeroMotoristas; i++) {
            System.out.println(_motoristas[i]);
        }
    }

    private static void listarCarros() {
        System.out.println("Lista de carros cadastrados:");
        for (int i = 0; i < _numeroCarros; i++) {
            System.out.println(_carros[i]);
        }
    }

    private static void cadastrarCarro() throws MotoristaNaoEncontradoException {
        System.out.println("Cadastro de carros");
        System.out.println("Digite a placa do carro:");
        String placa = scanner.nextLine();
        System.out.println("Digite o chassi do carro:");
        int chassi = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o CPF do motorista:");
        String cpf = scanner.nextLine();
        Motorista motorista = buscarMotorista(cpf);

        Carro carro = new Carro(placa, chassi, motorista);
        adicionarCarroNaLista(carro);
    }

    private static void adicionarCarroNaLista(Carro carro) {
        if (_numeroCarros == _carros.length) {
            Carro[] novaLista = new Carro[_carros.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _carros.length; i++) {
                novaLista[i] = _carros[i];
            }

            // Substituo a lista antiga pela nova.
            _carros = novaLista;
        }

        // Adiciono o carro a lista.
        _carros[_numeroCarros] = carro;
        _numeroCarros++;        
    }

    private static Motorista buscarMotorista(String cpf) throws MotoristaNaoEncontradoException {
        for (Motorista motorista: _motoristas) {
            if (motorista != null && motorista.getCpf().equals(cpf)) {
                return motorista;
            }
        }

        throw new MotoristaNaoEncontradoException(cpf);
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
        System.out.println("4 - Acelerar");
        System.out.println("5 - Acelerar até um limite");
        System.out.println("6 - Frear carro");
        System.out.println("7 - Listar motoristas");
        System.out.println("8 - Listar carros");
        System.out.println("9 - Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 9);
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
