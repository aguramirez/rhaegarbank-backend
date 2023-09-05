package com.rhaegarbank.backend.rhaegarbank.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.repositories.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository repo;

    @Override
    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> findByAmountBetween(BigDecimal min, BigDecimal max) {
        return repo.findByIncomeAmountBetween(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Income> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> findByIncomeDate(String incomeDateTime) {
        return repo.findByIncomeDateTime(incomeDateTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> findByIncomeDescription(String incomeDescription) {
        return repo.findByDescripcion(incomeDescription);
    }

    @Override
    @Transactional
    public Income save(Income income) {
        return repo.save(income);
    }

    @Override
    @Transactional
    public Optional<Income> update(Income income, Long id) {
        Optional<Income> oI = this.findById(id);
        Income incomeOptional = null;
        if(oI.isPresent()){
            Income incomeDB = oI.orElseThrow();
            incomeDB.setIncomeDescription(income.getIncomeDescription());
            incomeDB.setIncomeAmount(income.getIncomeAmount());
            incomeDB.setIncomeDateTime(income.getIncomeDateTime());
            incomeOptional = this.save(incomeDB);
        }
        return Optional.ofNullable(incomeOptional);
    }
}
