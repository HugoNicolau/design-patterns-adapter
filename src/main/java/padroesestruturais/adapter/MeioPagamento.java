package padroesestruturais.adapter;

// Target: a interface que o sistema da lanchonete usa (valor em reais).
public interface MeioPagamento {
    String pagar(float valor);
}
