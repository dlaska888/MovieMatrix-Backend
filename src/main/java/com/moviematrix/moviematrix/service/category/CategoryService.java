package com.moviematrix.moviematrix.service.category;

import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.entity.User;


import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    List<Category> findAllByUser(User user);
    Category findById(Long id);

    Category save(Category user);
    void deleteById(Long id);

    List<Category> addOrUpdateCategories(List<Long> categoryIds, User user);
}
