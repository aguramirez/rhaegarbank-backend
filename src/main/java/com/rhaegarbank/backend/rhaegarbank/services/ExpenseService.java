package com.rhaegarbank.backend.rhaegarbank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;

public interface ExpenseService {
    
    Expense save(Expense expense);

    Optional<Expense> findById(Long id);

    List<Expense> findByexpenseDate(LocalDateTime expenseDateTime);

    List<Expense> findByexpenseDescription(String expenseDescription);

    List<Expense> findByAmountBetween(BigDecimal min, BigDecimal max);

    Optional<Expense> update (Expense expense, Long id);

    void deleteById (Long id);
}
