package padroesestruturais.adapter;

// Adaptee: "biblioteca externa" da maquininha, com interface incompatível
// (valor em centavos e resposta booleana). Não pode ser alterada.
public class GatewayCartao {

    private int limiteEmCentavos;
    private int ultimaCobrancaEmCentavos;

    public GatewayCartao(int limiteEmCentavos) {
        this.limiteEmCentavos = limiteEmCentavos;
    }

    public boolean cobrar(int valorEmCentavos) {
        this.ultimaCobrancaEmCentavos = valorEmCentavos;
        return valorEmCentavos <= this.limiteEmCentavos;
    }

    public int getUltimaCobrancaEmCentavos() {
        return ultimaCobrancaEmCentavos;
    }
}
