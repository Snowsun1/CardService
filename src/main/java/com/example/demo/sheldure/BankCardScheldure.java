package com.example.demo.sheldure;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.BankCardService;
import com.example.demo.service.MessageSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Component
@EnableScheduling
@AllArgsConstructor
public class BankCardScheldure {
    private final BankCardService bankCardService;
    private final UserRepository userRepository;
    private final MessageSender messageSender;

    @Scheduled(fixedRate = 10_000)
    public void scheduleFixedRateTask() {
        log.info("Checking bank cards");
        var bankCards = bankCardService.findEntriesAfterDate(LocalDateTime.now());
        for (var bankCard : bankCards) {
            messageSender.sendMessage(userRepository.findUserByFio(bankCard.getFio()),
                    bankCardService.findCardNumberByCardId(bankCard.getId()));
        }
        var ids = bankCards.stream().map(entity -> entity.getId()).collect(Collectors.toList());
        bankCardService.deleteBankCards(ids);
    }
}
