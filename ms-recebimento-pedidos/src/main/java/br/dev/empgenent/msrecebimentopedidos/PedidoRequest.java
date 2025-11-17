package br.dev.empgenent.msrecebimentopedidos;

public record PedidoRequest(
        String clienteId,
        ItemPedidoDTO[] itens
) {
}
