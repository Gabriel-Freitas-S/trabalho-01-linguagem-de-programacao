import java.util.Scanner;

public class Oficina {
    private static final VetVeiculo vetVeiculos = new VetVeiculo();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar um novo veículo à oficina.");
            System.out.println("2. Pesquisar um veículo pela placa e mostrar na tela as suas informações.");
            System.out.println("3. Remover um veículo da oficina pela placa.");
            System.out.println("4. Listar todos os veículos (somente o modelo e a placa) que estão no sistema da oficina.");
            System.out.println("5. Sair do programa.");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumindo a nova linha
            switch (opcao) {
                case 1:
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(modelo, placa);
                    int resultado = vetVeiculos.insereVeiculo(veiculo);
                    if (resultado == -2) {
                        System.out.println("Veículo com esta placa já existe.");
                    } else {
                        System.out.println("Veículo adicionado com sucesso.");
                    }
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    int posicao = vetVeiculos.pesquisaVeiculo(placa);
                    if (posicao != -1) {
                        Veiculo veiculoEncontrado = vetVeiculos.getPos(posicao);
                        if (veiculoEncontrado != null) {
                            System.out.println("Modelo: " + veiculoEncontrado.getModelo());
                            System.out.println("Placa: " + veiculoEncontrado.getPlaca());
                        }
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo a ser removido: ");
                    placa = scanner.nextLine();
                    boolean removido = vetVeiculos.removeVeiculo(placa);
                    if (removido) {
                        System.out.println("Veículo removido com sucesso.");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Veículos cadastrados:");
                    for (int i = 0; i < vetVeiculos.getQuantidadePreenchida(); i++) {
                        Veiculo v = vetVeiculos.getPos(i);
                        if (v != null) {
                            System.out.println("Modelo: " + v.getModelo() + ", Placa: " + v.getPlaca());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}