package com.leverx.dealers.email;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;


public class RealEmailService implements EmailService{

    public void sendEmail(String emailAddress, String link) {
        Email email = EmailBuilder.startingBlank()
                .to(emailAddress, emailAddress)
                .withSubject("Verification")
                .withHTMLText("<a href=\"" + link + "\">")
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.host.com", 587, "user@host.com", "password")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withProxy("socksproxy.host.com", 1080, "proxy user", "proxy password")
                .withSessionTimeout(10 * 1000)
                .clearEmailAddressCriteria()
                .withProperty("mail.smtp.sendpartial", true)
                .withDebugLogging(true)
                .async()
                .buildMailer();

        mailer.sendMail(email);
    }
}
