package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.example.demo.repository.BankCardsForDeleting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.model.BankCard;
import com.example.demo.repository.BankCardRepository;
import com.example.demo.util.BankCardUtils;

@Service
@AllArgsConstructor
public class BankCardImpl implements BankCardService {
    private final UserService userService;
    private final BankCardRepository bankCardRepository;

    @Override
    public BankCard addBankCard(Long id) throws Exception {
        var foundUser = userService.getUser(id);
        if (foundUser == null) {
            throw new Exception("Пользователь не найден");
        }
        List<BankCard> userBankCards = foundUser.getBankCards();
        var newBankCard = new BankCard(BankCardUtils.generateRandomBankCardNumber());
        userBankCards.add(newBankCard);
        userService.saveUser(foundUser);
        return newBankCard;
    }

    @Override
    public void deleteBankCard(Long cardNumber) {
        bankCardRepository.deleteById(cardNumber);
    }

    @Override
    public Integer findCardNumberByCardId(Long cardId) {
        return bankCardRepository.findBankCardById(cardId).getCardNumber();
    }

    @Override
    public void deleteBankCards(List<Long> ids) {
        bankCardRepository.deleteAllById(ids);
    }

    @Override
    public Collection<BankCardsForDeleting> findEntriesAfterDate(LocalDateTime localDate) {
        return bankCardRepository.findEntriesAfterDate(localDate);
    }
}
