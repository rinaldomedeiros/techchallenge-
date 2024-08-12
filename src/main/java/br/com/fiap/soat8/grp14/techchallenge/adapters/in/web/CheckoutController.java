package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.CheckoutServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutServicePort checkoutService;

    public CheckoutController(CheckoutServicePort checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/{pedidoId}")
    public ResponseEntity<Void> iniciarCheckout(@PathVariable Long pedidoId) {
        checkoutService.processarCheckout(pedidoId);
        return ResponseEntity.ok().build();
    }
}