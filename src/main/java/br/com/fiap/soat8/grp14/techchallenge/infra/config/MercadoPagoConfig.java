package br.com.fiap.soat8.grp14.techchallenge.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mercadopago")
public class MercadoPagoConfig {

    private String apiUrl;
    private String apiUrlStatus;
    private String accessToken;
    private String idUsuario;
    private String idPosExterno;
    private String titulo;

}
