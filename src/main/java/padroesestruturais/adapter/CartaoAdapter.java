package padroesestruturais.adapter;

// Adapter de objeto: implementa MeioPagamento e traduz cada chamada para o GatewayCartao.
public class CartaoAdapter implements MeioPagamento {

    private GatewayCartao gateway;

    public CartaoAdapter(GatewayCartao gateway) {
        this.gateway = gateway;
    }

    @Override
    public String pagar(float valor) {
        int valorEmCentavos = Math.round(valor * 100);
        if (this.gateway.cobrar(valorEmCentavos)) {
            return "Cartão: cobrança de " + valorEmCentavos + " centavos aprovada";
        }
        else {
            return "Cartão: cobrança recusada";
        }
    }
}
