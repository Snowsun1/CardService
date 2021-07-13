package com.example.demo.sheldure;

import com.example.demo.service.BankCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;

@Slf4j
@Component
@EnableScheduling
@AllArgsConstructor
public class BankCardScheldure {
    private final BankCardService bankCardService;

    @Scheduled(fixedRate = 10_000)
    public void scheduleFixedRateTask() {
        log.info("Checking bank cards");
        var bankCardForDeleting =bankCardService.findBankCardByValidEndDateLessThan(LocalDateTime.now());
        if(!CollectionUtils.isEmpty(bankCardForDeleting)) {
            log.info("Deleting cards:" + bankCardForDeleting);
            bankCardService.deleteBankCards(bankCardForDeleting);
        }
    }
}
