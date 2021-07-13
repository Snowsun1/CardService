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
    public void sendMessage(User user, Integer cardNumber) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setFrom("levseredinskiy5@gmail.com");
        msg.setSubject("Оповещение от банка");
        msg.setText("Здравствуйте " + user.getFio() +  "! " +
                "\n Срок действия вашей карты " +  cardNumber + " истёк");

        javaMailSender.send(msg);
    }
}
