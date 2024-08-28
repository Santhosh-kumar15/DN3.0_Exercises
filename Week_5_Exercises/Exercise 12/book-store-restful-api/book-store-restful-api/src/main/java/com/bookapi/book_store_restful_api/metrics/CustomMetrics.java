package com.bookapi.book_store_restful_api.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        meterRegistry.gauge("custom.metric", 100); // Custom metric example
    }
}
