package com.rhaegarbank.backend.rhaegarbank.models.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private BigDecimal expenseAmount;
    private LocalDateTime expenseDateTime;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }
    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
    public LocalDateTime getExpenseDateTime() {
        return expenseDateTime;
    }
    public void setExpenseDateTime(LocalDateTime expenseDateTime) {
        this.expenseDateTime = expenseDateTime;
    }

    
}
