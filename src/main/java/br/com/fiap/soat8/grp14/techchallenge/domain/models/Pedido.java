package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;

public class Pedido {

    private Long id;
    private String numero;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido() {
    }

    public Pedido(Long id, String numero, Double valorTotal, StatusPedido statusPedido, Cliente cliente,
            List<ItemPedido> itens) {
        this.id = id;
        this.numero = numero;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Pedido(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.numero = pedidoDTO.getNumero();
        this.valorTotal = pedidoDTO.getValorTotal();
        this.statusPedido = pedidoDTO.getStatusPedido();
        this.cliente = new Cliente(pedidoDTO.getCliente());
        this.itens = convertToItemPedidoList(pedidoDTO.getItens());
    }

    public PedidoDTO toPedidoDTO() {
        return new PedidoDTO(
                this.id,
                this.numero,
                this.valorTotal,
                this.statusPedido,
                this.cliente != null ? this.cliente.toClienteDTO() : null,
                convertToItemPedidoDTOList(this.itens));
    }

    public static List<ItemPedido> convertToItemPedidoList(List<ItemPedidoDTO> itemPedidoDTOs) {
        List<ItemPedido> itemPedidos = new ArrayList<>();

        for (ItemPedidoDTO dto : itemPedidoDTOs) {
            itemPedidos.add(new ItemPedido(dto));
        }

        return itemPedidos;
    }

    public static List<ItemPedidoDTO> convertToItemPedidoDTOList(List<ItemPedido> itemPedidos) {
        List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<>();

        for (ItemPedido itemPedido : itemPedidos) {
            itemPedidoDTOs.add(itemPedido.toItemPedidoDTO());
        }

        return itemPedidoDTOs;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}