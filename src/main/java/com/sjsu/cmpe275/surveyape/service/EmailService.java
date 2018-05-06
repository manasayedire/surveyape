package com.sjsu.cmpe275.surveyape.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendInvitationForUser(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    public void sendUniqueInvitationForGeneralSurveyUsers(List<String> emails, String text,String surveyId) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Invitation to the survey");
            for (String email : emails) {
                message.setText("127.0.0.1:8080/"+surveyId);
                message.setTo(email);
                emailSender.send(message);
            }
        } catch (MailException exception) {
            logger.debug("Unable to send uniqueMessage for users");
            exception.printStackTrace();
        }
    }


    public void sendUniqueInvitationForClosedSurveyUsers(List<String> emails, String text,String surveyId) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Invitation to the closed survey");
            for (String email : emails) {
                message.setText("127.0.0.1:8080/"+surveyId+"/"+ Base64.getEncoder().encodeToString(email.getBytes()));
                message.setTo(email);
                emailSender.send(message);
            }
        } catch (MailException exception) {
            logger.debug("Unable to send uniqueMessage for users");
            exception.printStackTrace();
        }
    }

}