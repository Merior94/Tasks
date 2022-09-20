package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdminConfigTest {

    @Autowired
    AdminConfig adminConfig;

    @Test
    void testConfigAdminMail(){
        assertFalse(adminConfig.getAdminMail().isEmpty());
        assertTrue(Pattern.compile("^(.+)@(\\S+)$")
                .matcher(adminConfig.getAdminMail())
                .matches());
    }
}
