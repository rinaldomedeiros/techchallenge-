//package br.com.fiap.soat8.grp14.techchallenge.core.usecases;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
//import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
//import br.com.fiap.soat8.grp14.techchallenge.presentation.service.PedidoRepositoryPort;
//import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
//import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EmptyItensException;
//import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
//import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
//
//public class PedidoServiceImpl {
//
//    private final PedidoRepositoryPort pedidoRepositoryPort;
//
//    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepositoryPort) {
//        this.pedidoRepositoryPort = pedidoRepositoryPort;
//    }
//
//    public void processarPedido(Long pedidoId) {
//        //    pedidoServicePort.iniciarCheckout(pedidoId);
//    }
//
//    public List<PedidoDTO> buscarPedidos() {
//        List<Pedido> pedidos = this.pedidoRepositoryPort.buscarTodos();
//        return pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
//    }
//
//    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO) throws EmptyItensException {
//        if (pedidoDTO.getItens() == null || pedidoDTO.getItens().isEmpty())
//            throw new EmptyItensException("Erro ao salvar o pedido: deve ser selecionado pelo menos um produto para realizar o pedido.");
//
//        pedidoDTO.setValorTotal(this.calcularTotalPedido(pedidoDTO.getItens()));
//
//        int numeroPedido = gerarNumeroPedido();
//        pedidoDTO.setNumero(numeroPedido);
//
//
//        //TODO: validar se o item de pedido está preenchido corretamente: se o produto foi informado e se a quantidade é válida.
//        Pedido pedido = new Pedido(pedidoDTO);
//        if(pedidoDTO.getClienteId() != null && pedidoDTO.getClienteId() != 0) {
//        	Cliente cliente = new Cliente();
//        	cliente.setId(pedidoDTO.getClienteId());
//        	pedido.setCliente(cliente);
//        } else {
//        	pedido.setCliente(null);
//        }
//        pedido.setStatusPedido(StatusPedido.RECEBIDO);
//        Pedido pedidoSalvo = pedidoRepositoryPort.salvarPedido(pedido);
//        return pedidoSalvo.toPedidoDTO();
//    }
//
//    private Double calcularTotalPedido(List<ItemPedidoDTO> itens) {
//    	for (ItemPedidoDTO item : itens) {
//			item.setValorItem(item.getProduto().getValor());
//		}
//
//        return itens.stream()
//                .mapToDouble(item -> item.getQuantidade() * item.getValorItem())
//                .sum();
//    }
//
//    private int gerarNumeroPedido() {
//        Optional<Integer> ultimoNumero = pedidoRepositoryPort.obterUltimoNumeroPedido();
//
//        // Se existe um número anterior, incrementa, senão começa com 1
//        int novoNumero = ultimoNumero.orElse(0) + 1;
//
//        if (novoNumero > 1000) {
//            novoNumero = 1;
//        }
//        return novoNumero;
//    }
//
//
//}
