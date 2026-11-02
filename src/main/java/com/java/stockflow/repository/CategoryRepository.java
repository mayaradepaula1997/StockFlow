package com.java.stockflow.repository;

import com.java.stockflow.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// O Jpa disponibiliza operações prontas de persistencia
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
