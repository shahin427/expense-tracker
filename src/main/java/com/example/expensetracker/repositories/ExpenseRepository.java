package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

@org.springframework.stereotype.Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {


    @Query("select COALESCE(sum(ex.amount),0) from ExpenseEntity ex where ex.category = :category and ex.creationTime>= :from and ex.creationTime<:to ")
    Long totalSpentForCategoryBetween(@Param("category") CategoryEntity category, @Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
