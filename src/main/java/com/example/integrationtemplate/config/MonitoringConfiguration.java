package com.example.integrationtemplate.config;

import io.micrometer.core.instrument.Tag;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableConfigurationProperties({EnvironmentProperties.class})
public class MonitoringConfiguration {

    @Bean
    public MeterRegistryCustomizer meterRegistryCustomizer(EnvironmentProperties environmentProperties) {
        return registry -> registry.config().commonTags(Arrays.asList(
                Tag.of("stack", environmentProperties.getStack()),
                Tag.of("region", environmentProperties.getRegion()),
                Tag.of("instance", environmentProperties.getInstance()),
                Tag.of("application", environmentProperties.getApplication())
        ));
    }
}
