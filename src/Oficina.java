import javax.swing.JOptionPane;

// Classe principal Oficina
public class Oficina {
    // Instância estática de VetVeiculo que será usada para armazenar os veículos.
    private static final VetVeiculo vetVeiculos = new VetVeiculo();

    // Método principal que inicia o programa
    public static void main(String[] args) {
        while (true) {
            // Opções do menu que serão exibidas ao usuário
            String[] options = { "Adicionar", "Pesquisar", "Remover", "Listar", "Sair" };
            // Exibe a caixa de diálogo com as opções do menu e armazena a escolha do usuário
            int opcao = JOptionPane.showOptionDialog(null, "Menu:", "Oficina",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            // Verifica a opção escolhida pelo usuário e chama o método correspondente
            switch (opcao) {
                case 0:
                    adicionarVeiculo();
                    break;
                case 1:
                    pesquisarVeiculo();
                    break;
                case 2:
                    removerVeiculo();
                    break;
                case 3:
                    listarVeiculos();
                    break;
                case 4:
                    // Mensagem de saída do programa e finaliza o loop
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
                default:
                    // Mensagem para opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        }
    }

    // Método para adicionar um veículo
    private static void adicionarVeiculo() {
        // Solicita ao usuário o modelo do veículo
        String modelo = InOut.leString("Digite o modelo do veículo:");
        // Solicita ao usuário a placa do veículo
        String placa = InOut.leString("Digite a placa do veículo:");
        // Solicita ao usuário o problema do veículo
        String problema = InOut.leString("Digite o problema do veículo:");
        // Solicita ao usuário o valor do serviço
        double valorDoServico = InOut.leDouble("Digite o valor do serviço:");
        // Cria uma nova instância de Veiculo com os dados fornecidos
        Veiculo veiculo = new Veiculo(modelo, placa, problema, valorDoServico);
        // Tenta inserir o veículo no VetVeiculo e verifica se já existe
        boolean inserido = vetVeiculos.insereVeiculo(veiculo);
        // Exibe mensagem ao usuário informando se o veículo foi adicionado ou se já existia um veículo com a mesma placa
        if (!inserido) {
            JOptionPane.showMessageDialog(null, "Veículo com esta placa já existe.");
        } else {
            JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso.");
        }
    }

    // Método para pesquisar um veículo
    private static void pesquisarVeiculo() {
        // Solicita ao usuário a placa do veículo a ser pesquisado
        String placa = InOut.leString("Digite a placa do veículo:");
        // Pesquisa o veículo pelo número da placa
        int posicao = vetVeiculos.pesquisaVeiculo(placa);
        // Verifica se o veículo foi encontrado
        if (posicao != -1) {
            // Obtém o veículo na posição encontrada
            Veiculo veiculoEncontrado = vetVeiculos.getPos(posicao);
            // Se o veículo foi encontrado, exibe as informações dele
            if (veiculoEncontrado != null) {
                JOptionPane.showMessageDialog(null,
                        "Modelo: " + veiculoEncontrado.getModelo() + "\n" +
                                "Placa: " + veiculoEncontrado.getPlaca() + "\n" +
                                "Problema: " + veiculoEncontrado.getProblema() + "\n" +
                                "Valor do Serviço: " + veiculoEncontrado.getValorDoServico());
            }
        } else {
            // Exibe mensagem informando que o veículo não foi encontrado
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
        }
    }

    // Método para remover um veículo
    private static void removerVeiculo() {
        // Solicita ao usuário a placa do veículo a ser removido
        String placa = InOut.leString("Digite a placa do veículo a ser removido:");
        // Tenta remover o veículo pelo número da placa
        boolean removido = vetVeiculos.removeVeiculo(placa);
        // Exibe mensagem ao usuário informando se o veículo foi removido ou não encontrado
        if (removido) {
            JOptionPane.showMessageDialog(null, "Veículo removido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
        }
    }

    // Método para listar todos os veículos
    private static void listarVeiculos() {
        // StringBuilder para armazenar a lista de veículos
        StringBuilder lista = new StringBuilder("Veículos cadastrados:\n");
        // Percorre todos os veículos cadastrados
        for (int i = 0; i < vetVeiculos.getQuantidadePreenchida(); i++) {
            Veiculo v = vetVeiculos.getPos(i);
            // Se o veículo não for nulo, adiciona suas informações à lista
            if (v != null) {
                lista.append("Modelo: ").append(v.getModelo()).append(", Placa: ").append(v.getPlaca()).append("\n");
            }
        }
        // Exibe a lista de veículos cadastrados
        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
