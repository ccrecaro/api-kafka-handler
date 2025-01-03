package com.project.apikafkahandler.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Queue;

import static com.project.apikafkahandler.constants.Constants.TOPIC;

@Slf4j
@Component
public class KafkaConsumerListener {

    private final Queue<String> queue;

    public KafkaConsumerListener(Queue<String> queue) {
        this.queue = queue;
    }

    @KafkaListener(topics = TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        queue.add(message);
        log.info("Consumed message: {}", message);
    }
}
