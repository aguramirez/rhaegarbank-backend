package com.rhaegarbank.backend.rhaegarbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;
import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.models.entities.User;
import com.rhaegarbank.backend.rhaegarbank.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository repo;

    @Override
    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(User user, Long id) {
        Optional<User> o = this.findById(id);
        User userOptional = null;
        if(o.isPresent()){
            User userDb = o.orElseThrow();
            userDb.setName(user.getName());
            userDb.setLastname(user.getLastname());
            userDb.setEmail(user.getEmail());
            userDb.setUsername(user.getUsername());
            userOptional = this.save(userDb);
        }
        return Optional.ofNullable(userOptional);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> findAllExpenses(Long userId) {
        return repo.findByUserExpensesId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> findAllIncomes(Long userId) {
        return repo.findByUserIncomesId(userId);
    }

    
}
