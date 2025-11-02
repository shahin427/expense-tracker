package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
