package com.project.apikafkahandler.service.impl;

import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.QueueElement;
import com.project.apikafkahandler.dto.Response;
import com.project.apikafkahandler.service.AddService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.project.apikafkahandler.constants.Constants.TOPIC;

@Slf4j
@Service
public class AddServiceImpl implements AddService {

    private final KafkaTemplate<String, QueueElement> kafkaTemplate;

    @Autowired
    public AddServiceImpl(KafkaTemplate<String, QueueElement> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public AddResponse addElement(QueueElement element) {
        try {
            kafkaTemplate.send(TOPIC, element);
            Response responseOK = Response.builder()
                    .status("00")
                    .message("OK")
                    .build();
            return AddResponse.builder()
                    .response(responseOK)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Response responseNOK = Response.builder()
                    .status("-1")
                    .message("NOK")
                    .build();
            return AddResponse.builder()
                    .response(responseNOK)
                    .build();
        }
    }
}
