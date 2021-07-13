package com.example.demo.service;

import com.example.demo.model.User;

public interface MessageSender {
    void sendMessage(User user, Integer cardNumber);
}
