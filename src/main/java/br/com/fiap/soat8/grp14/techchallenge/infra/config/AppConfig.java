package br.com.fiap.soat8.grp14.techchallenge.infra.config;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.CheckoutPort;
import br.com.fiap.soat8.grp14.techchallenge.infra.http.FakeCheckoutAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CheckoutPort checkoutPort() {
        return new FakeCheckoutAdapter();
    }

    // @Bean
    // public PedidoServiceImpl pedidoServicePort(CheckoutPort checkoutPort) {
    //     return new PedidoServiceImpl(checkoutPort);
    // }
}
