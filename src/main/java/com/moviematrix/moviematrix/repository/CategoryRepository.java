package com.moviematrix.moviematrix.repository;

import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByUser(User user);
    void deleteAllByUser(User user);
}
