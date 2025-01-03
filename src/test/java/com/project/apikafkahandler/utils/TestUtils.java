package com.project.apikafkahandler.utils;

import com.project.apikafkahandler.dto.*;

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

    public static AddResponse addResponseNOK() {
        return AddResponse.builder()
                .response(responeNOK())
                .build();
    }

    public static Response responeNOK() {
        return Response.builder()
                .status("-1")
                .message("NOK")
                .build();
    }
}
