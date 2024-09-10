import java.util.ArrayList;

public class VetVeiculo {
    private final ArrayList<Veiculo> veiculos;

    public VetVeiculo() {
        this.veiculos = new ArrayList<>();
    }

    public VetVeiculo(int tamanho) {
        this.veiculos = new ArrayList<>(tamanho);
    }

    public int getQuantidadePreenchida() {
        return veiculos.size();
    }

    public Veiculo getPos(int pos) {
        if (pos >= 0 && pos < veiculos.size()) {
            return veiculos.get(pos);
        } else {
            return null;
        }
    }

    public int pesquisaVeiculo(String placa) {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            if (v != null && placa != null && placa.equals(v.getPlaca())) {
                return i;
            }
        }
        return -1;
    }

    public int insereVeiculo(Veiculo veiculo) {
        if (pesquisaVeiculo(veiculo.getPlaca()) != -1) {
            return -2;
        }
        veiculos.add(veiculo);
        return veiculos.size() - 1;
    }

    public boolean removeVeiculo(String placa) {
        int pos = pesquisaVeiculo(placa);
        if (pos == -1) {
            return false;
        }
        veiculos.remove(pos);
        return true;
    }
}