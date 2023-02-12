package com.nogran.email.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.email-sender.properties")
@Data
public class EmailSenderProperties {
    private String to;
    private String subject;
}
