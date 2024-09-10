import java.util.ArrayList;

public class VetVeiculo {
    // Atributos:
    // A classe possui um atributo do tipo ArrayList que armazenará objetos do tipo 'Veiculo'.
    private ArrayList<Veiculo> veiculos; // ArrayList de Veiculo

    // Construtor vazio:
    // Este é o construtor da classe que inicializa o ArrayList. Portanto, quando um objeto da classe VetVeiculo
    // for criado, ele já terá um ArrayList pronto para uso.
    public VetVeiculo() {
        this.veiculos = new ArrayList<>(); // Inicializa o ArrayList de Veiculo
    }

    // Método para inserir Veiculo:
    // Recebe um objeto do tipo Veiculo como parâmetro e tenta adicioná-lo ao ArrayList.
    // Verifica se já existe um veículo com a mesma placa antes de adicionar.
    // Retorna 'true' se o veículo foi adicionado com sucesso, caso contrário, retorna 'false'.
    public boolean insereVeiculo(Veiculo veiculo) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                return false; // Veículo com esta placa já existe.
            }
        }
        veiculos.add(veiculo); // Adiciona o veículo ao ArrayList
        return true; // Veículo adicionado com sucesso.
    }

    // Método para pesquisar Veiculo pela placa:
    // Recebe uma String contendo a placa do veículo a ser procurado.
    // Percorre a lista de veículos e verifica se existe um veículo com a mesma placa.
    // Retorna a posição do veículo na lista se encontrado, ou -1 se não for encontrado.
    public int pesquisaVeiculo(String placa) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(placa)) {
                return i; // Retorna a posição do veículo na lista
            }
        }
        return -1; // Veículo não encontrado
    }

    // Método getPos:
    // Recebe um inteiro representando a posição.
    // Retorna o veículo na posição correspondente do ArrayList.
    // Se a posição for inválida (menor que 0 ou maior que o tamanho da lista), retorna null.
    public Veiculo getPos(int posicao) {
        if (posicao >= 0 && posicao < veiculos.size()) {
            return veiculos.get(posicao); // Retorna o veículo na posição especificada
        }
        return null; // Posição inválida
    }

    // Método para remover Veiculo pela placa:
    // Recebe uma String contendo a placa do veículo a ser removido.
    // Percorre a lista de veículos e verifica se existe um veículo com a mesma placa.
    // Se encontrado, remove o veículo da lista e retorna true. Caso contrário, retorna false.
    public boolean removeVeiculo(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                veiculos.remove(v); // Remove o veículo encontrado
                return true; // Veículo removido com sucesso
            }
        }
        return false; // Veículo não encontrado
    }

    // Método getQuantidadePreenchida:
    // Retorna a quantidade de veículos cadastrados no ArrayList.
    public int getQuantidadePreenchida() {
        return veiculos.size(); // Retorna o número de veículos na lista
    }
}
