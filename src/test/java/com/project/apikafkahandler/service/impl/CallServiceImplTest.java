package com.project.apikafkahandler.service.impl;

import com.project.apikafkahandler.dto.GetResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CallServiceImplTest {

    private Queue<String> messageQueue;
    private CallServiceImpl callService;

    @BeforeEach
    void setUp() {
        messageQueue = new ConcurrentLinkedQueue<>();
        callService = new CallServiceImpl(messageQueue);
    }

    @Test
    void testGetQueue_WithMessages() {
        messageQueue.add("Message 1");
        messageQueue.add("Message 2");

        GetResponse response = callService.getQueue();

        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertEquals("00", response.getResponse().getStatus());
        assertEquals("OK", response.getResponse().getMessage());
        assertEquals(2, response.getQueue().size());
        assertTrue(response.getQueue().contains("Message 1"));
        assertTrue(response.getQueue().contains("Message 2"));
    }

    @Test
    void testGetQueue_EmptyQueue() {
        GetResponse response = callService.getQueue();

        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertEquals("00", response.getResponse().getStatus());
        assertEquals("OK", response.getResponse().getMessage());
        assertTrue(response.getQueue().isEmpty());
    }

    @Test
    void testGetQueue_DoesNotModifyQueue() {
        messageQueue.add("Message 1");
        messageQueue.add("Message 2");

        GetResponse response = callService.getQueue();

        assertNotNull(response);
        assertEquals(2, response.getQueue().size());
        assertEquals(2, messageQueue.size());
    }


}
