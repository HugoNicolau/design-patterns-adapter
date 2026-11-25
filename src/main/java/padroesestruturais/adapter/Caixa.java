package padroesestruturais.adapter;

// Cliente: só conhece MeioPagamento, não sabe que o cartão usa outra interface.
public class Caixa {

    public String receber(MeioPagamento meioPagamento, float valor) {
        return meioPagamento.pagar(valor);
    }
}
