package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BankCard;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long> {
    BankCard findBankCardByCardNumber(Integer cardNumber);
    List<BankCard> findBankCardByValidEndDateLessThan(LocalDateTime endDate);
}
