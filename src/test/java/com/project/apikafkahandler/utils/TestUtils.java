package com.project.apikafkahandler.utils;

import com.project.apikafkahandler.dto.Metadata;
import com.project.apikafkahandler.dto.QueueElement;

import java.util.Date;

public class TestUtils {

    private static Metadata createGenericMetadata() {
        return Metadata.builder()
                .source("source")
                .type("type")
                .build();
    }

    public static QueueElement createGenericQueueElement() {
        return QueueElement.builder()
                .id("1")
                .timestamp(new Date())
                .message("test")
                .metadata(createGenericMetadata())
                .build();
    }
}
