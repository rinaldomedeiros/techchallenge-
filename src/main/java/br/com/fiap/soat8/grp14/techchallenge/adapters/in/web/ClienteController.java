package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import java.util.List;

import org.springframework.core.annotation.Order;
import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Cliente", description = "API REST para cadastro e controle de clientes")
@Order(1)
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteService) {
        this.clienteServicePort = clienteService;
    }
    
    @GetMapping
    @Operation(summary = "Este endpoint é responsável por listar os clientes cadastrados.")
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        return ResponseEntity.ok().body(this.clienteServicePort.listarTodos());
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Este endpoint é responsável por consultar um cliente pelo CPF.")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable String cpf) {
        ClienteDTO clienteDTO = this.clienteServicePort.buscarCliente(cpf);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    @Operation(summary = "Este endpoint é responsável por salvar as informções do cliente.")
    public ResponseEntity<ClienteDTO> salvarCliente(@Validated @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteServicePort.salvarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Este endpoint é responsável por excluir as informações do cliente.")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        clienteServicePort.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Este endpoint é responsável por atualizar as informações do cliente.")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteServicePort.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

}
