package ua.duikt.learning.java.pro.spring.individualfirstsprint.model;

import org.springframework.stereotype.Component;
import ua.duikt.learning.java.pro.spring.individualfirstsprint.services.MessageService;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@Component
public class Client {
    private MessageService messageService;

    // TODO: Add a constructor for Dependency Injection here

    public void processMessage(String message) {
        if (messageService == null) {
            throw new RuntimeException("Service not injected!");
        }
        messageService.sendMessage(message);
    }
}
