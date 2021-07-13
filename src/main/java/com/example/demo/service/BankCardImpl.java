package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.model.BankCard;
import com.example.demo.repository.BankCardRepository;
import com.example.demo.util.BankCardUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class BankCardImpl implements BankCardService {
    private final UserService userService;
    private final MessageSender messageSender;
    private final BankCardRepository bankCardRepository;
    @Override
    public BankCard addBankCard(Long id) throws Exception {
        var foundUser = userService.getUser(id);
        if(foundUser==null){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Пользователь не найден");
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
//        messageSender.sendMessage();
    }

    @Override
    public List<BankCard> findBankCardByValidEndDateLessThan(LocalDateTime endDate) {
        return bankCardRepository.findBankCardByValidEndDateLessThan(endDate);
    }

    @Override
    public void deleteBankCards(List<BankCard> bankCardList) {
        bankCardRepository.deleteAll(bankCardList);
    }
}
