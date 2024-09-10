public class Veiculo {
    // Atributos privados da classe
    private String modelo;
    private String placa;
    private String problema;
    private double valorDoServico;

    // Construtor que recebe o modelo e a placa do veículo, inicializando os outros atributos com valores padrão
    public Veiculo(String modelo, String placa) {
        this(modelo, placa, "", 0.0); // Chamando o construtor principal
    }

    // Construtor principal que permite inicializar todos os atributos da classe
    public Veiculo(String modelo, String placa, String problema, double valorDoServico) {
        this.modelo = modelo;
        this.placa = (placa != null) ? placa : ""; // Verifica se a placa não é nula antes de atribuir
        this.problema = problema;
        this.valorDoServico = valorDoServico;
    }

    // Método getter para o atributo modelo
    public String getModelo() {
        return modelo;
    }

    // Método getter para o atributo placa
    public String getPlaca() {
        return placa;
    }

    // Método getter para o atributo problema
    public String getProblema() {
        return problema;
    }

    // Método getter para o atributo valorDoServico
    public double getValorDoServico() {
        return valorDoServico;
    }

    // Método setter para o atributo modelo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método setter para o atributo placa
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método setter para o atributo problema
    public void setProblema(String problema) {
        this.problema = problema;
    }

    // Método setter para o atributo valorDoServico
    public void setValorDoServico(double valorDoServico) {
        this.valorDoServico = valorDoServico;
    }

    // Método que retorna uma representação em String do objeto
    @Override
    public String toString() {
        return "Veiculo[modelo=" + modelo + ", placa=" + placa + ", problema=" + problema + ", valorDoServico=" + valorDoServico + "]";
    }
}
