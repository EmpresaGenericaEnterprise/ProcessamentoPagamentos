package br.dev.empgenent.msrecebimentopedidos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("broker.queue.pedidos")
@Component
@Getter
@Setter
public class PedidosQueueProperties {
    private String nome;
}
