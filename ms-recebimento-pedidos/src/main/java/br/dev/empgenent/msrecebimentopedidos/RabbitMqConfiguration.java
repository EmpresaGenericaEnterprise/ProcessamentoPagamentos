package br.dev.empgenent.msrecebimentopedidos;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfiguration {

    private final PedidosQueueProperties pedidosQueueProperties;

    @Bean
    public Queue queue() {
        return new Queue(pedidosQueueProperties.getNome(), true);
    }

}
