package com.moviematrix.moviematrix.repository;

import com.moviematrix.moviematrix.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
