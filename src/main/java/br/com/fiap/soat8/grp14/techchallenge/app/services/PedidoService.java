package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.CriarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import jakarta.validation.Valid;
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

    private final ModelMapper mapper;

    public List<PedidoDTO> listarTodos() {
        return this.listarPedidoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }

    @Transactional
    public PedidoDTO salvarPedido(@Valid PedidoInsertDTO pedidoInsertDTO) {
        return mapper.map(this.criarPedidoUseCase.execute(mapper.map(pedidoInsertDTO, PedidoEntity.class)), PedidoDTO.class);
    }
}
