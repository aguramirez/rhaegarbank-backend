package com.rhaegarbank.backend.rhaegarbank.models.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incomes")
public class Income {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String incomeDescription;

    private BigDecimal incomeAmount;

    private String incomeDateTime;

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
    public String getIncomeDescription() {
        return incomeDescription;
    }
    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }
    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }
    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
    public String getIncomeDateTime() {
        return incomeDateTime;
    }
    public void setIncomeDateTime(String dateTime) {
        this.incomeDateTime = dateTime;
    }

    
}
