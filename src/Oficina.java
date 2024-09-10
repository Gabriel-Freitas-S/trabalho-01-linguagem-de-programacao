import java.util.Scanner;

// Classe principal do sistema da Oficina
public class Oficina {

    // Cria uma instância estática de VetVeiculo que gerenciará os veículos da oficina
    private static final VetVeiculo vetVeiculos = new VetVeiculo();

    // Método principal que inicia o programa e exibe o menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para leitura das entradas do usuário

        // Loop infinito que só será interrompido quando o usuário selecionar sair (opção 5)
        while (true) {
            // Exibe o menu de opções para o usuário
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar um novo veículo à oficina.");
            System.out.println("2. Pesquisar um veículo pela placa e mostrar na tela as suas informações.");
            System.out.println("3. Remover um veículo da oficina pela placa.");
            System.out.println("4. Listar todos os veículos (somente o modelo e a placa) que estão no sistema da oficina.");
            System.out.println("5. Sair do programa.");
            System.out.print("Escolha uma opção: ");

            // Lê a opção escolhida pelo usuário
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha para evitar problemas de leitura

            // Switch para execução da ação baseada na opção escolhida
            switch (opcao) {
                case 1:
                    adicionarVeiculo(scanner); // Chama o método para adicionar um veículo
                    break;
                case 2:
                    pesquisarVeiculo(scanner); // Chama o método para pesquisar um veículo
                    break;
                case 3:
                    removerVeiculo(scanner); // Chama o método para remover um veículo
                    break;
                case 4:
                    listarVeiculos(); // Chama o método para listar todos os veículos
                    break;
                case 5:
                    System.out.println("Saindo do programa..."); // Mensagem de saída
                    scanner.close(); // Fecha o scanner
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem de opção inválida
            }
        }
    }

    // Método para adicionar um novo veículo à oficina
    private static void adicionarVeiculo(Scanner scanner) {
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine(); // Lê o modelo do veículo
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine(); // Lê a placa do veículo

        // Cria uma nova instância do veículo com o modelo e placa lidos
        Veiculo veiculo = new Veiculo(modelo, placa);

        // Tenta inserir o veículo no vetor de veículos
        boolean inserido = vetVeiculos.insereVeiculo(veiculo);
        if (!inserido) {
            System.out.println("Veículo com esta placa já existe."); // Mensagem de erro se o veículo já existe
        } else {
            System.out.println("Veículo adicionado com sucesso."); // Mensagem de sucesso
        }
    }

    // Método para pesquisar um veículo pela placa e mostrar suas informações
    private static void pesquisarVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine(); // Lê a placa do veículo

        // Procura o veículo no vetor de veículos
        int posicao = vetVeiculos.pesquisaVeiculo(placa);
        if (posicao != -1) {
            // Se o veículo for encontrado, obtém o veículo através da posição retornada
            Veiculo veiculoEncontrado = vetVeiculos.getPos(posicao);
            if (veiculoEncontrado != null) {
                // Exibe as informações do veículo encontrado
                System.out.println("Modelo: " + veiculoEncontrado.getModelo());
                System.out.println("Placa: " + veiculoEncontrado.getPlaca());
                System.out.println("Problema: " + veiculoEncontrado.getProblema());
                System.out.println("Valor do Serviço: " + veiculoEncontrado.getValorDoServico());
            }
        } else {
            System.out.println("Veículo não encontrado."); // Mensagem se o veículo não for encontrado
        }
    }

    // Método para remover um veículo da oficina pela placa
    private static void removerVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo a ser removido: ");
        String placa = scanner.nextLine(); // Lê a placa do veículo

        // Tenta remover o veículo do vetor de veículos
        boolean removido = vetVeiculos.removeVeiculo(placa);
        if (removido) {
            System.out.println("Veículo removido com sucesso."); // Mensagem de sucesso se o veículo for removido
        } else {
            System.out.println("Veículo não encontrado."); // Mensagem se o veículo não for encontrado
        }
    }

    // Método para listar todos os veículos no sistema da oficina
    private static void listarVeiculos() {
        System.out.println("Veículos cadastrados:");

        // Loop para exibir todos os veículos do vetor de veículos
        for (int i = 0; i < vetVeiculos.getQuantidadePreenchida(); i++) {
            Veiculo v = vetVeiculos.getPos(i);
            if (v != null) {
                System.out.println("Modelo: " + v.getModelo() + ", Placa: " + v.getPlaca());
            }
        }
    }
}
