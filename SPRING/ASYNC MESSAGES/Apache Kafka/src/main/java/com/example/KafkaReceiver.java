package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class KafkaReceiver {

    private KitchenUI ui;

    public KafkaReceiver(KitchenUI ui) {
        this.ui = ui;
    }
    
    // You can delete id = "cloud_id" from annotation @KafkaListener
    // and it'll continue to work
    @KafkaListener(topics = "cloud.topic", id = "cloud_id")
    public void handle(String message) {
        ui.recieve(message);
    }

}
