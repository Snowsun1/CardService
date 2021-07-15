package com.example.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageSenderImpl implements MessageSender {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMessage(String fio, String email, Integer cardNumber) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom("levseredinskiy5@gmail.com");
        msg.setSubject("Оповещение от банка");
        msg.setText("Здравствуйте " + fio + "! " +
                "\n Срок действия вашей карты " + cardNumber + " истёк");

        javaMailSender.send(msg);
    }
}
