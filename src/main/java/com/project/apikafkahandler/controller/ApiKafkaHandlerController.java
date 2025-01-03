package com.project.apikafkahandler.controller;

import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.GetResponse;
import com.project.apikafkahandler.dto.QueueElement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/kafka")
public interface ApiKafkaHandlerController {

    @GetMapping(value = "/queue", produces = "application/json")
    ResponseEntity<GetResponse> getQueue();

    @PostMapping(value= "/add", consumes = "application/json", produces = "application/json")
    ResponseEntity<AddResponse> addElementQueue(
            @Validated @RequestBody QueueElement element
    );

}
