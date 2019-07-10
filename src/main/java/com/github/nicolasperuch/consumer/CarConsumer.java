package com.github.nicolasperuch.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CarConsumer {

    @KafkaListener(topics = "order-car")
    public void receive(ConsumerRecord<?, String> consumerRecord){
        System.out.println("CONSUMING FROM ORDER-CAR");
        String body = consumerRecord.value();
        System.out.println("body: " + body);
    }
}
