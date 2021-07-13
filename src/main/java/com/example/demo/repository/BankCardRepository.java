package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BankCard;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long> {
    BankCard findBankCardById(Long cardId);
    List<BankCard> findBankCardByValidEndDateLessThan(LocalDateTime endDate);
    @Query(value = "select bank_card.id, users.fio from bank_card left join users on users.id=user_id where bank_card.valid_end_date <= ?1", nativeQuery = true)
    public Collection<BankCardsForDeleting> findEntriesAfterDate(LocalDateTime localDateTime);
}
