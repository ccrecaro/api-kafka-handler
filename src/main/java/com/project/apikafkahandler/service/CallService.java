package com.project.apikafkahandler.service;

import com.project.apikafkahandler.dto.GetResponse;
import org.springframework.stereotype.Service;

public interface CallService {
    public GetResponse getQueue();
}
