package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BankCard;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long> {
    BankCard findBankCardById(Long cardId);

    @Query(value = "select bank_card.id, bank_card.card_number, users.fio, users.email " +
            "from bank_card inner join users on users.id=user_id where bank_card.valid_end_date <= ?1", nativeQuery = true)
    Collection<BankCardsForDeleting> findEntriesAfterDate(LocalDateTime localDateTime);
}
