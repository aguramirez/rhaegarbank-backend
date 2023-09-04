package com.rhaegarbank.backend.rhaegarbank.repositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    
    @Query("SELECT i FROM Expense i WHERE DATE(i.expenseDateTime) = ?1")
    List<Expense> findByExpenseDateTime(LocalDateTime expenseDateTime);

    @Query("SELECT i FROM Expense i WHERE i.expenseDescription = ?1")
    List<Expense> findByDescripcion(String expenseDescription);

    @Query("SELECT i FROM Expense i WHERE i.expenseAmount >= ?1 AND i.expenseAmount <= ?2")
    List<Expense> findByExpenseAmountBetween(BigDecimal min, BigDecimal max);
}
