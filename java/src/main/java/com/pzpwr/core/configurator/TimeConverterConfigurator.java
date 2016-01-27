package com.pzpwr.core.configurator;

import com.pzpwr.core.converter.TimeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("application.properties")
public class TimeConverterConfigurator {

    @Value("${date_format}")
    private String dateFormat;

    @PostConstruct
    public void initialize() {
        TimeConverter.initialize(dateFormat);
    }
}
