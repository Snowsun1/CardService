package com.example.demo.service;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
@Service
@AllArgsConstructor
public class MessageSenderImpl implements MessageSender{

    private final JavaMailSender javaMailSender;
    @Override
    public void sendMessage() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("levseredinskiy1@gmail.com");
        msg.setFrom("levseredinskiy5@gmail.com");
        msg.setSubject("Оповещение от банка");
        msg.setText("Здравствуйте Иван Иванов! \n Срок действия вашей карты истёк");

        javaMailSender.send(msg);
    }
}
