package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final ListarPedidoUseCase listarPedidoUseCase;

    private final ModelMapper mapper;

    public List<PedidoDTO> listarTodos(){
        return this.listarPedidoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido,PedidoDTO.class)).toList();
    }
}
