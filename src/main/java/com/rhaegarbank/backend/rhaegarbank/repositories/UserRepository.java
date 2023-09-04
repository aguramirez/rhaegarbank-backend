package com.rhaegarbank.backend.rhaegarbank.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rhaegarbank.backend.rhaegarbank.models.entities.Expense;
import com.rhaegarbank.backend.rhaegarbank.models.entities.Income;
import com.rhaegarbank.backend.rhaegarbank.models.entities.User;

public interface UserRepository extends CrudRepository <User, Long>{
    
    @Query("SELECT i FROM Income i WHERE i.usuario.id = ?1")
    List<Income> findByUserIncomesId(Long id);
    
    @Query("SELECT i FROM Expense i WHERE i.usuario.id = ?1")
    List<Expense> findByUserExpensesId(Long id);
}
