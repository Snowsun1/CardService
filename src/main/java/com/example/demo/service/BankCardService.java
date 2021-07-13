package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.model.BankCard;

public interface BankCardService {
    BankCard addBankCard(Long id) throws Exception;
    void deleteBankCard(Long cardNumber);
    List<BankCard> findBankCardByValidEndDateLessThan(LocalDateTime endDate);
    void deleteBankCards(List<BankCard> bankCardList);
}
