package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.BankCard;
import com.example.demo.repository.BankCardsForDeleting;

public interface BankCardService {
    BankCard addBankCard(Long id) throws Exception;

    void deleteBankCard(Long cardNumber);

    Collection<BankCardsForDeleting> findEntriesAfterDate(LocalDateTime localDate);

    void deleteBankCards(List<Long> ids);
}
