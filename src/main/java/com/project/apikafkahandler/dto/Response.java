package com.project.apikafkahandler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;
}
