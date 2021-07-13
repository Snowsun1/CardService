package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.BankCardService;

@RestController
@AllArgsConstructor
public class BankCardController {
    private final BankCardService bankCardService;

    @PostMapping("/bank-card/{id}")
    public Long createBankCard(@PathVariable Long id) throws Exception {
        return bankCardService.addBankCard(id).getId();
    }

}
