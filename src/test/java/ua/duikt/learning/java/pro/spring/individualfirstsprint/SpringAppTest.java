package ua.duikt.learning.java.pro.spring.individualfirstsprint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.duikt.learning.java.pro.spring.individualfirstsprint.configs.AppConfig;
import ua.duikt.learning.java.pro.spring.individualfirstsprint.model.Client;
import ua.duikt.learning.java.pro.spring.individualfirstsprint.services.MessageService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class SpringAppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Check 1: Spring Context should start successfully")
    void contextLoads() {
        assertNotNull(
                context,
                "Spring ApplicationContext was not initialized. Check AppConfig."
        );
    }

    @Test
    @DisplayName("Check 2: At least one MessageService implementation should be found")
    void messageServiceBeanShouldExist() {
        Map<String, MessageService> beans = context.getBeansOfType(MessageService.class);

        assertFalse(
                beans.isEmpty(),
                "No bean implementing MessageService was found. Create EmailService or SmsService and annotate it with @Component."
        );
    }

    @Test
    @DisplayName("Check 3: Client bean should exist in the context")
    void clientBeanShouldExist() {
        assertDoesNotThrow(
                () -> context.getBean(Client.class),
                "Client bean was not found. Check whether the class is annotated with @Component."
        );
    }

    @Test
    @DisplayName("Check 4: Dependency Injection should work")
    void clientShouldHaveServiceInjected() {
        Client client = context.getBean(Client.class);

        assertDoesNotThrow(
                () -> client.processMessage("Test Message"),
                "Calling processMessage failed. It looks like MessageService was not injected (dependency injection failed). Check the constructor."
        );
    }
}
