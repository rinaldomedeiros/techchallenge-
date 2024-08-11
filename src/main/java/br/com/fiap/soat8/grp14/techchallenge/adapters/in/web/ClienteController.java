package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteServicePort;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteService) {
        this.clienteServicePort = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        return ResponseEntity.ok().body(this.clienteServicePort.listarTodos());
    }
    
    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable String cpf) {
        ClienteDTO clienteDTO = this.clienteServicePort.buscarCliente(cpf);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }	
        return ResponseEntity.ok(clienteDTO);
    }
    
    @PostMapping
    public ResponseEntity<ClienteDTO> salvarCliente(@Validated  @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteServicePort.salvarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        clienteServicePort.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
