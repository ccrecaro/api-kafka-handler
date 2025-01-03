package com.project.apikafkahandler.dto;

import lombok.Data;

@Data
public class KafkaQueue {
    private QueueElement[] elements;
}
