package br.dev.empgenent.msrecebimentopedidos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public PedidoDTO receberPedido(@RequestBody PedidoRequest pedidoRequest) throws JsonProcessingException {
        String primeiraMensagem = "Pedido recebido com sucesso!";
        ObjectMapper objectMapper = new ObjectMapper();

        PedidoDTO pedidoDTO = new PedidoDTO(
                "pedido123",
                pedidoRequest.clienteId(),
                pedidoRequest.itens()
        );

        String pedidoRequestJson = objectMapper.writeValueAsString(pedidoDTO);
        rabbitTemplate.convertAndSend("pedidos", pedidoRequestJson);
        return pedidoDTO;
    }
}
