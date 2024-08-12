package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Long id;
    private Integer numero;
    private LocalDateTime dataPedido;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido() {
    }

    public Pedido(Long id, Integer numero, LocalDateTime dataPedido, Double valorTotal, StatusPedido statusPedido, Cliente cliente,
                  List<ItemPedido> itens) {
        this.id = id;
        this.numero = numero;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Pedido(PedidoDTO pedidoDTO) {
        if (pedidoDTO != null) {
            this.id = pedidoDTO.getId() != null ? pedidoDTO.getId() : null;
            this.numero = pedidoDTO.getNumero();
            this.dataPedido = pedidoDTO.getDataPedido();
            this.valorTotal = pedidoDTO.getValorTotal();
            this.statusPedido = pedidoDTO.getStatusPedido();
            this.cliente = new Cliente(pedidoDTO.getCliente());
            this.itens = convertToItemPedidoList(pedidoDTO.getItens());
        }
    }

    public PedidoDTO toPedidoDTO() {
        return new PedidoDTO(
                this.id,
                this.numero,
                this.dataPedido,
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

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}