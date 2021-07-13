package com.example.demo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Integer getCardNumber() {
        return cardNumber;
    }

    @Column(unique = true)
    private Integer cardNumber;
    private LocalDateTime validEndDate;

    public BankCard(Integer cardNumber) {
        this.cardNumber = cardNumber;
        this.validEndDate = LocalDateTime.now().plusMinutes(1);
    }
}

