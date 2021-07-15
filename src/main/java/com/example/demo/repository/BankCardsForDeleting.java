package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Value;

public interface BankCardsForDeleting {
    Long getId();
    @Value("#{target.card_number}")
    Integer getCardNumber();
    String getFio();
    String getEmail();
}
