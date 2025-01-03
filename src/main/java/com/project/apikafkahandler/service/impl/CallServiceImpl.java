package com.project.apikafkahandler.service.impl;

import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.GetResponse;
import com.project.apikafkahandler.dto.Response;
import com.project.apikafkahandler.service.CallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
@Slf4j
public class CallServiceImpl implements CallService {
    private final Queue<String> messageQueue;

    public CallServiceImpl(Queue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public GetResponse getQueue() {
        try{
            List<String> messages = new ArrayList<>(messageQueue);

            Response responseOK = Response.builder()
                    .status("00")
                    .message("OK")
                    .build();
            return GetResponse.builder()
                    .response(responseOK)
                    .queue(messages)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Response responseNOK = Response.builder()
                    .status("-1")
                    .message("NOK")
                    .build();
            return GetResponse.builder()
                    .response(responseNOK)
                    .build();
        }

    }


}
