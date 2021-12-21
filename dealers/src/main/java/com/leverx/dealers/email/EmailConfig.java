package com.leverx.dealers.email;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
@EnableConfigurationProperties(EmailProperty.class)
public class EmailConfig {

    @Bean
    EmailService emailService(EmailProperty property) {
        return property.getReal() ? new RealEmailService() : new MockEmailService();
    }

}
