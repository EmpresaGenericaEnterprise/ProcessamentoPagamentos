package br.dev.empgenent.msrecebimentopedidos;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoAPI {
    private final RabbitTemplate rabbitTemplate;

    public PedidoAPI(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String receberPedido() {
        String primeiraMensagem = "Pedido recebido com sucesso!";

        rabbitTemplate.convertAndSend("pedidos", primeiraMensagem);
        return "ok";
    }
}
