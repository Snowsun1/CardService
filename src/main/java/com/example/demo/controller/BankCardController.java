package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.BankCardService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class BankCardController {
    private final BankCardService bankCardService;

    @PostMapping("/bank-card/{id}")
    public Long createBankCard(@PathVariable Long id) throws Exception {
        try {
            return bankCardService.addBankCard(id).getId();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with this id!", e);
        }
    }

}
