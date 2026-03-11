package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {


        @Query("select cat from CategoryEntity cat where cat.name like %:name%")
        Page<CategoryEntity> categoryList(@Param("name") String name, Pageable pageable);
}
