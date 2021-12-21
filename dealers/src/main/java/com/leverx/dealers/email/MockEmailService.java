package com.leverx.dealers.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockEmailService implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(String emailAddress, String link) {
        log.info("emailAddress={}, link={}", emailAddress, link);
    }
}
