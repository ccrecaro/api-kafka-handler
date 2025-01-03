package com.project.apikafkahandler.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.project.apikafkahandler.constants.Constants.TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC)
                .build();
    }
}
