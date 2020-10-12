package com.example.integrationtemplate.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "environment")
@Getter
@AllArgsConstructor
public class EnvironmentProperties {

    private final String stack;
    private final String region;
    private final String node;

}