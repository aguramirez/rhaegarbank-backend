package com.rhaegarbank.backend.rhaegarbank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public interface IncomeRepository extends CrudRepository<Income, Long> {
    
    @Query("SELECT i FROM Income i WHERE DATE(i.incomeDateTime) = ?1")
    List<Income> findByIncomeDateTime(LocalDateTime incomeDateTime);

    @Query("SELECT i FROM Income i WHERE i.incomeDescription = ?1")
    List<Income> findByDescripcion(String incomeDescription);

    @Query("SELECT i FROM Ingreso i WHERE i.incomeAmount >= ?1 AND i.incomeAmount <= ?2")
    List<Income> findByIncomeAmountBetween(BigDecimal min, BigDecimal max);
}
