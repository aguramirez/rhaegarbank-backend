package com.rhaegarbank.backend.rhaegarbank.services;

import java.util.List;
import java.util.Optional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;
import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.models.entities.User;

public interface UserService {

    List<User> findAll(); 

    User save (User user);

    Optional<User> findById (Long id);

    Optional<User> update (User user, Long id);

    void deleteById (Long id);

    List<Income> findAllIncomes (Long id);

    List<Expense> findAllExpenses(Long id);
}
