package com.project.apikafkahandler.service.impl;

import com.project.apikafkahandler.dto.AddResponse;
import com.project.apikafkahandler.dto.QueueElement;
import com.project.apikafkahandler.dto.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static com.project.apikafkahandler.constants.Constants.TOPIC;
import static com.project.apikafkahandler.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddServiceImplTest {

    @Mock
    private KafkaTemplate<String, QueueElement> kafkaTemplate;

    @InjectMocks
    private AddServiceImpl addService;

    @Test
    void testAddElement_Success() {
        // Arrange
        QueueElement element = createGenericQueueElement();
        Response expectedResponse = Response.builder()
                .status("00")
                .message("OK")
                .build();

        // Act
        AddResponse response = addService.addElement(element);

        // Assert
        assertNotNull(response);
        assertEquals(expectedResponse.getStatus(), response.getResponse().getStatus());
        assertEquals(expectedResponse.getMessage(), response.getResponse().getMessage());
        verify(kafkaTemplate, times(1)).send(TOPIC, element);
    }

    @Test
    void testAddElement_Exception() {
        QueueElement element = createGenericQueueElement();
        doThrow(new RuntimeException("Kafka error")).when(kafkaTemplate).send(TOPIC, element);

        AddResponse response = addService.addElement(element);

        assertEquals(addResponseNOK(), response);
        verify(kafkaTemplate, times(1)).send(TOPIC, element);
    }
}
