package br.dev.empgenent.entradapedidos.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {

    @Value("${kafka.topic.pedidos.nome}")
    String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RabbitListener(queues = "${broker.queue.pedidos.nome}")
    public void receiveMessage(Message message) {
        String body = new String(message.getBody());
        System.out.println("Received message: " + body);

        // kafkaTemplate.send("entrada-pedidos", body);
        kafkaTemplate.send("entrada-pedidos", "my-key", body);
    }

}
