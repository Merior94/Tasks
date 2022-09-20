package com.crud.tasks.trello.config;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void testConfigUserAvailable(){
        assertFalse(trelloConfig.getTrelloUser().isEmpty());
    }

    @Test
    void testConfigTokenAvailable(){
        assertFalse(trelloConfig.getTrelloToken().isEmpty());
    }

    @Test
    void testConfigAppKeyAvailable(){
        assertFalse(trelloConfig.getTrelloAppKey().isEmpty());
    }

    @Test
    void testConfigApiEndpointAvailable(){
        assertFalse(trelloConfig.getTrelloApiEndpoint().isEmpty());
    }
}
