package com.project.apikafkahandler.service;

import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.QueueElement;

public interface AddService {
    AddResponse addElement(QueueElement element);
}
