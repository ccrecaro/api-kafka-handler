package com.project.apikafkahandler.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddResponse {
    private Response response;
}
