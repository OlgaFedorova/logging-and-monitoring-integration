package com.example.integrationtemplate.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TrickyRandomMonitoringService {

    private final Counter trickyCounter;
    private final Random rand = new Random();

    public TrickyRandomMonitoringService(MeterRegistry meterRegistry) {
        this.trickyCounter = Counter
                .builder("tricky.counter.requests")
                .register(meterRegistry);
    }

    public void count(){
        if (rand.nextInt() % 2 == 0) {
            trickyCounter.increment();
        }
    }
}
