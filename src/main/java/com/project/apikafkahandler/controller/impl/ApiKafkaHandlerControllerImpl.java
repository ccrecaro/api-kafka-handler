package com.project.apikafkahandler.controller.impl;

import com.project.apikafkahandler.controller.ApiKafkaHandlerController;
import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.GetResponse;
import com.project.apikafkahandler.dto.QueueElement;
import com.project.apikafkahandler.service.AddService;
import com.project.apikafkahandler.service.CallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiKafkaHandlerControllerImpl implements ApiKafkaHandlerController {
    private AddService addService;
    private CallService callService;

    @Autowired
    public ApiKafkaHandlerControllerImpl(AddService addService, CallService callService) {
        this.addService = addService;
        this.callService = callService;
    }

    @Override
    public ResponseEntity<GetResponse> getQueue() {
        log.info("getQueue started");
        GetResponse getResponse = callService.getQueue();
        log.info("getQueue executed");
        return ResponseEntity.ok(getResponse);
    }

    @Override
    public ResponseEntity<AddResponse> addElementQueue(QueueElement element) {
        log.info("addQueue started");
        AddResponse response = addService.addElement(element);
        log.info("addQueue executed");
        return ResponseEntity.ok(response);
    }
}
