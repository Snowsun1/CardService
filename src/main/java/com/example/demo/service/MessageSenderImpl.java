package com.example.demo.service;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageSenderImpl implements MessageSender {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMessage(User user, Integer cardNumber) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setFrom("levseredinskiy5@gmail.com");
        msg.setSubject("Оповещение от банка");
        msg.setText("Здравствуйте " + user.getFio() + "! " +
                "\n Срок действия вашей карты " + cardNumber + " истёк");

        javaMailSender.send(msg);
    }
}
