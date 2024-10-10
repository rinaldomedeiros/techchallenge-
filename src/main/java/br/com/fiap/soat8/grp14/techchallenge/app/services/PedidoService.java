package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.ItemPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.CriarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ItemPedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoService {

    private final ListarPedidoUseCase listarPedidoUseCase;
    private final CriarPedidoUseCase criarPedidoUseCase;

    private final ModelMapper mapper;

    public List<PedidoDTO> listarTodos() {
        return this.listarPedidoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }

    @Transactional
    public PedidoDTO salvarPedido(PedidoInsertDTO pedidoInsertDTO) {
        PedidoEntity pedidoEntity = mapper.map(pedidoInsertDTO, PedidoEntity.class);
        pedidoEntity.setClienteEntity(new ClienteEntity());
        pedidoEntity.getClienteEntity().setId(pedidoInsertDTO.getClienteId());
        pedidoEntity.getItens().stream().forEach(item -> item.setProduto(new ProdutoEntity()));

        pedidoEntity.getItens().stream().forEach(item -> {
            pedidoInsertDTO.getItens().stream()
                    .filter(produtoDTO -> produtoDTO.getProdutoId() != null)
                    .forEach(produtoDTO -> item.getProduto().setId(produtoDTO.getProdutoId()));
        });
//        pedidoEntity.getItens().get(0).getProduto().setId(pedidoInsertDTO.getItens().get(0).getProdutoId());

        // Executa o caso de uso para salvar o pedido
        Pedido pedidoSalvo = this.criarPedidoUseCase.execute(pedidoEntity);

        // Mapeia o Pedido de volta para PedidoDTO para retornar na resposta
        return mapper.map(pedidoSalvo, PedidoDTO.class);
    }
}

