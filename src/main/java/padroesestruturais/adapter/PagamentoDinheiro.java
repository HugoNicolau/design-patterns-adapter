package padroesestruturais.adapter;

public class PagamentoDinheiro implements MeioPagamento {

    @Override
    public String pagar(float valor) {
        return "Dinheiro: pagamento recebido";
    }
}
