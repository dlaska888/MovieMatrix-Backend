package com.moviematrix.moviematrix.service.category;

import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.entity.User;


import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);

    Category save(Category user);
    void deleteById(Long id);

    List<Category> addCategories(List<Long> categoryIds, User user);
}
