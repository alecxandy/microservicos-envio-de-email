package com.alexandregsouza.api.email.services;

import com.alexandregsouza.api.email.enuns.StatusEmail;
import com.alexandregsouza.api.email.models.EmailModel;
import com.alexandregsouza.api.email.repositors.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendingnEmail(EmailModel emailModel) {
        emailModel.setLocalDateTime(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return emailRepository.save(emailModel);
    }

    public List<EmailModel> findAll() {
        return emailRepository.findAll();
    }

    public Optional<EmailModel> findById(Long emailId) {
        return emailRepository.findById(emailId);
    }
}
