package br.dev.empgenent.entradapedidos.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {


    @RabbitListener(queues = "${broker.queue.pedidos.nome}")
    public void receiveMessage(Message message) {
        String body = new String(message.getBody());
        System.out.println("Received message: " + body);
    }

}
