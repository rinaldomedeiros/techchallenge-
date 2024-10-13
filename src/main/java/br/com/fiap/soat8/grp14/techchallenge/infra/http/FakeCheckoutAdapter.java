package br.com.fiap.soat8.grp14.techchallenge.infra.http;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.CheckoutPort;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import java.math.BigDecimal;

public class FakeCheckoutAdapter implements CheckoutPort {

    private final PaymentClient paymentClient;

    public FakeCheckoutAdapter() {
        MercadoPagoConfig.setAccessToken("YOUR_ACCESS_TOKEN");
        this.paymentClient = new PaymentClient();
    }

    @Override
    public void iniciarCheckout(Long pedidoId) {
        // Simular a criação de um pagamento
        PaymentCreateRequest createRequest = PaymentCreateRequest.builder()
            .transactionAmount(new BigDecimal(1000)) // Valor fictício
            .token("fake_card_token") // Token fictício
            .description("Descrição do Pedido " + pedidoId)
            .installments(1)
            .paymentMethodId("visa")
            .payer(PaymentPayerRequest.builder().email("dummy_email@example.com").build())
            .build();

        try {
            Payment payment = paymentClient.create(createRequest);
            System.out.println("Pagamento simulado criado com sucesso: " + payment);
        } catch (MPApiException ex) {
            System.out.printf("Erro no MercadoPago. Status: %s, Conteúdo: %s%n",
                ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }
    }
}
