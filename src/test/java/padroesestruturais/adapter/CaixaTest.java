package padroesestruturais.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaixaTest {

    @Test
    void deveReceberPagamentoEmDinheiro() {
        Caixa caixa = new Caixa();

        assertEquals("Dinheiro: pagamento recebido", caixa.receber(new PagamentoDinheiro(), 25.90f));
    }

    @Test
    void deveAprovarPagamentoNoCartao() {
        Caixa caixa = new Caixa();
        MeioPagamento cartao = new CartaoAdapter(new GatewayCartao(10000));

        assertEquals("Cartão: cobrança de 2590 centavos aprovada", caixa.receber(cartao, 25.90f));
    }

    @Test
    void deveRecusarPagamentoNoCartaoAcimaDoLimite() {
        Caixa caixa = new Caixa();
        MeioPagamento cartao = new CartaoAdapter(new GatewayCartao(2000));

        assertEquals("Cartão: cobrança recusada", caixa.receber(cartao, 25.90f));
    }

    @Test
    void deveConverterReaisParaCentavos() {
        GatewayCartao gateway = new GatewayCartao(10000);
        Caixa caixa = new Caixa();

        caixa.receber(new CartaoAdapter(gateway), 25.90f);

        assertEquals(2590, gateway.getUltimaCobrancaEmCentavos());
    }

    @Test
    void deveReceberDinheiroECartaoNoMesmoCaixa() {
        Caixa caixa = new Caixa();
        MeioPagamento dinheiro = new PagamentoDinheiro();
        MeioPagamento cartao = new CartaoAdapter(new GatewayCartao(10000));

        assertEquals("Dinheiro: pagamento recebido", caixa.receber(dinheiro, 10.0f));
        assertEquals("Cartão: cobrança de 1000 centavos aprovada", caixa.receber(cartao, 10.0f));
    }

}
