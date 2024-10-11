package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.ItemPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.AtualizarStatusPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.CriarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final ListarPedidoUseCase listarPedidoUseCase;
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final AtualizarStatusPedidoUseCase atualizarStatusPedidoUseCase;

    private final ModelMapper mapper;

    public List<PedidoDTO> listarTodos() {
        return this.listarPedidoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }


    @Transactional
    public PedidoDTO salvarPedido(PedidoInsertDTO pedidoInsertDTO) {
        PedidoEntity pedidoEntity = mapper.map(pedidoInsertDTO, PedidoEntity.class);

        if (pedidoInsertDTO.getClienteId() != null) {
            ClienteEntity clienteEntity = new ClienteEntity();
            clienteEntity.setId(pedidoInsertDTO.getClienteId());
            pedidoEntity.setCliente(clienteEntity);
        }


        pedidoEntity.getItens().stream().forEach(item -> item.setProduto(new ProdutoEntity()));

        pedidoEntity.getItens().stream().forEach(item -> item.setProduto(new ProdutoEntity()));

        pedidoEntity.getItens().stream().forEach(item -> {
            pedidoInsertDTO.getItens().stream()
                    .filter(produtoDTO -> produtoDTO.getProdutoId() != null)
                    .forEach(produtoDTO -> item.getProduto().setId(produtoDTO.getProdutoId()));
        });


        // Executa o caso de uso para salvar o pedido
        Pedido pedidoSalvo = this.criarPedidoUseCase.execute(pedidoEntity);

        // Mapeia o Pedido de volta para PedidoDTO para retornar na resposta
        return mapper.map(pedidoSalvo, PedidoDTO.class);
    }

    @Transactional
    public PedidoDTO atualizarStatus(Integer numeroPedido, StatusPedido status) {

        Pedido pedidoAtualizado = atualizarStatusPedidoUseCase.executeCustom(numeroPedido, status);
        return mapper.map(pedidoAtualizado, PedidoDTO.class);
    }
}

