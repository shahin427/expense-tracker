package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.AlertEntity;
import com.example.expensetracker.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {


    Optional<AlertEntity> findByCategoryAndEnabledTrue(CategoryEntity category);
}
