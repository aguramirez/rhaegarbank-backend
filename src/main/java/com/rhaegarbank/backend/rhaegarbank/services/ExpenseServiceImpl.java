package com.rhaegarbank.backend.rhaegarbank.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;
import com.rhaegarbank.backend.rhaegarbank.repositories.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    
    @Autowired
    private ExpenseRepository repo;

    @Override
    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> findByAmountBetween(BigDecimal min, BigDecimal max) {
        return repo.findByExpenseAmountBetween(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Expense> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> findByexpenseDate(String expenseDateTime) {
        return repo.findByExpenseDateTime(expenseDateTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> findByexpenseDescription(String expenseDescription) {
        return repo.findByDescripcion(expenseDescription);
    }

    @Override
    @Transactional
    public Expense save(Expense expense) {
        return repo.save(expense);
    }

    @Override
    @Transactional
    public Optional<Expense> update(Expense expense, Long id) {
        Optional<Expense> oE = this.findById(id);
        Expense expenseOptional = null;
        if(oE.isPresent()){
            Expense expenseDB = oE.orElseThrow();
            expenseDB.setExpenseDescription(expense.getExpenseDescription());
            expenseDB.setExpenseAmount(expense.getExpenseAmount());
            expenseDB.setExpenseDateTime(expense.getExpenseDateTime());
            expenseOptional = this.save(expenseDB);
        }
        return Optional.ofNullable(expenseOptional);
    }
}
