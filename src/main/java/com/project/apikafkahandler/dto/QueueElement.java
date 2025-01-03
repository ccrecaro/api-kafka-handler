package com.project.apikafkahandler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueElement {
    //TODO: Add validations
    @JsonProperty("id")
    private String id;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("message")
    private String message;

    @JsonProperty("metadata")
    private Metadata metadata;
}
