package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Cliente", description = "API REST para cadastro e controle de clientes")
@Order(1)
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Este endpoint é responsável por listar os clientes cadastrados.")
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        return ResponseEntity.ok().body(this.clienteService.listarTodos());
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Este endpoint é responsável por consultar um cliente pelo CPF.")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable String cpf) {
        ClienteDTO clienteDTO = this.clienteService.buscarCliente(cpf);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    @Operation(summary = "Este endpoint é responsável por salvar as informções do cliente.")
    public ResponseEntity<ClienteDTO> salvarCliente(@Validated @RequestBody ClienteInsertDTO clienteInsertDTO) {
        ClienteDTO clienteCriado = clienteService.salvarCliente(clienteInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Este endpoint é responsável por excluir as informações do cliente.")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Este endpoint é responsável por atualizar as informações do cliente.")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

}
