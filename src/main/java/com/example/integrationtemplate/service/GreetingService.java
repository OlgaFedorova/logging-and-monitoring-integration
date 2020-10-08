package com.example.integrationtemplate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    public String getHello(){
        logger.info("First-service: hello");
        String result = "Hello from First-service!";
        return result;

    }
}
