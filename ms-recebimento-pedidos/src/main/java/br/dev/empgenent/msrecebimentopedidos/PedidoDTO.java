package br.dev.empgenent.msrecebimentopedidos;

public record PedidoDTO(
        String id,
        String clienteId,
        ItemPedidoDTO[] itensPedido
) {
}
