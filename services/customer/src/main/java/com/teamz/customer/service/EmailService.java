package com.teamz.customer.service;



import com.teamz.customer.entity.EmailAdmin;
import com.teamz.customer.utils.MailBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    @Autowired
    private EmailAdminRepository emailAdminRepository;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendSimpleMessage(MailBody mailBody){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailBody.to());
        message.setFrom("kirushan06@gmail.com");
        message.setSubject(mailBody.subject());
        message.setText(mailBody.text());

        javaMailSender.send(message);

    }

    public void sendAnniversaryEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        EmailAdmin emailAdmin=new EmailAdmin();
        emailAdmin.setRecipientEmail(toEmail);
        emailAdmin.setSubject(subject);
        emailAdmin.setBody(body);
        emailAdmin.setSentDate(LocalDate.now());
        emailAdminRepository.save(emailAdmin);

    }
}

