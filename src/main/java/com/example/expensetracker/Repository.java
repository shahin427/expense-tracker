package com.example.expensetracker;

import com.example.expensetracker.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Expense, Long> {
}
