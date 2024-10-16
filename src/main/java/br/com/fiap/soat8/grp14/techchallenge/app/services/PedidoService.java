package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoAtualizarStatusDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoStatusPagamentoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPagamento;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.*;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.infra.config.MercadoPagoConfig;
import lombok.AllArgsConstructor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
	
    private final ListarPedidoUseCase listarPedidoUseCase;
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final AtualizarStatusPedidoUseCase atualizarStatusPedidoUseCase;
    private final ListarPedidoOrdenadoUseCase listarPedidoOrdenadoUseCase;
    private final AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase;

    private final ModelMapper mapper;
    
    @Autowired
    private MercadoPagoConfig mercadoPagoConfig;

    public List<PedidoDTO> listarTodos() {
        return this.listarPedidoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }

    @Transactional
    public PedidoDTO buscarPedido(Long idPedido) {
        return mapper.map(buscarPedidoUseCase.execute(idPedido), PedidoDTO.class);
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
    public PedidoDTO atualizarStatus(PedidoAtualizarStatusDTO pedidoAtualizarStatusDTO) {
        Pedido pedidoAtualizado = atualizarStatusPedidoUseCase.execute(pedidoAtualizarStatusDTO);
        return mapper.map(pedidoAtualizado, PedidoDTO.class);
    }

    public List<PedidoDTO> listarPedidosOrdenado() {
        return this.listarPedidoOrdenadoUseCase.execute(true).stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }

    public PedidoDTO atualizarStatusPagamento(PedidoStatusPagamentoDTO pedidoStatusPagamentoDTO) {
        return mapper.map(this.atualizarStatusPagamentoUseCase.execute(pedidoStatusPagamentoDTO), PedidoDTO.class);
    }
    
    public PedidoStatusPagamentoDTO consultarStatusPagamento(Long id) {
    	PedidoStatusPagamentoDTO statusPagamento = new PedidoStatusPagamentoDTO();
    	String accessToken = mercadoPagoConfig.getAccessToken();
    	
        String url = mercadoPagoConfig.getApiUrlStatus() + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String jsonResponse = responseEntity.getBody();
            
            JSONObject responseObject = new JSONObject(jsonResponse);

            JSONArray results = responseObject.getJSONArray("results");

            if (results.length() > 0) {
                JSONObject payment = results.getJSONObject(0);
                if(!payment.getString("status").isEmpty()) {
                	statusPagamento.setPedidoId(id);
                	statusPagamento.setStatusPagamento(StatusPagamento.APROVADO);
                } 
            } else {
            	statusPagamento.setPedidoId(id);
            	statusPagamento.setStatusPagamento(StatusPagamento.NAO_APROVADO);
            }
        }
        return statusPagamento;
    }
    
}
