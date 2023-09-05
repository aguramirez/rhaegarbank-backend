package com.rhaegarbank.backend.rhaegarbank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.models.entities.User;
import com.rhaegarbank.backend.rhaegarbank.services.UserService;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/{incomeDateTime}")
    public List<Income> showUserIncomes(Long userId, String incomeDateTime){
        Optional<User> oU = userService.findById(userId);
        return userService.findAllIncomes(oU.get().getId());
    }
}
