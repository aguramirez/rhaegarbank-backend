package com.rhaegarbank.backend.rhaegarbank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.models.entities.User;
import com.rhaegarbank.backend.rhaegarbank.services.IncomeService;
import com.rhaegarbank.backend.rhaegarbank.services.UserService;

@RestController
@RequestMapping("/incomes")
@CrossOrigin(origins = "*")
public class IncomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> showIncomes(){
        return incomeService.findAll();
    }    

    @GetMapping("/{userId}/{incomeDateTime}")
    public List<Income> showUserIncomes(Long userId, String incomeDateTime){
        Optional<User> oU = userService.findById(userId);
        return userService.findAllIncomes(oU.get().getId());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Income income){
        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.save(income));
    }
}
