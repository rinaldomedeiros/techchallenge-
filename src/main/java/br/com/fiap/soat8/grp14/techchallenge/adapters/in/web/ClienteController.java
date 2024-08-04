package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private static final String LINHAS_POR_PAGINA = "15";

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = LINHAS_POR_PAGINA) Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value="direction", defaultValue = "ASC") String direction
    ) {
        return ResponseEntity.ok().body(this.clienteService.listarTodos(page, linesPerPage, orderBy, direction));
    }
}
