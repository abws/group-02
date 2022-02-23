package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailHandler {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine engine;

    /**
     * This is used to send HTML messages using the thymeleaf template resolver.
     * @param recipient - Email target
     * @param subject - Subject of the email
     * @param template - The template file (THYMELEAF)
     * @param context - Context variable for attribute replacers.
     */
    public void dispatchEmail(String recipient, String subject, String template, Context context) throws MessagingException {
        MimeMessage mm = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm);
        helper.setFrom("no-reply@spicesrus.com");
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(engine.process(template,context), true);
        mailSender.send(mm);
    }

    /**
     * This is used to send plain text emails without any HTML format.
     * @param recipient - Email Target
     * @param subject - Subject of the Email
     * @param body - Body content of the email (NO HTML)
     */
    public void dispatchEmail(String recipient, String subject, String body) throws MessagingException {
        MimeMessage mm = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm);
        helper.setFrom("no-reply@spicesrus.com");
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(body);
        mailSender.send(mm);
    }


}
