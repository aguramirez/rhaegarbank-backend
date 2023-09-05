package com.rhaegarbank.backend.rhaegarbank.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;

public interface IncomeService {

    Income save(Income income);

    Optional<Income> findById(Long id);

    List<Income> findByIncomeDate(String incomeDateTime);

    List<Income> findByIncomeDescription(String incomeDescription);

    List<Income> findByAmountBetween(BigDecimal min, BigDecimal max);

    Optional<Income> update (Income income, Long id);

    void deleteById (Long id);
}
