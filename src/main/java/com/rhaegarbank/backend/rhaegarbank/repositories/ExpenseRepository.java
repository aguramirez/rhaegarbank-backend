package com.rhaegarbank.backend.rhaegarbank.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    
    @Query("select e from Expense e where e.expenseDateTime = %?1%")
    List<Expense> findByExpenseDateTime(String expenseDateTime);

    @Query("select e from Expense e where e.expenseDescription = ?1")
    List<Expense> findByDescripcion(String expenseDescription);

    @Query("select e from Expense e where e.expenseAmount >= ?1 AND e.expenseAmount <= ?2")
    List<Expense> findByExpenseAmountBetween(BigDecimal min, BigDecimal max);
}
