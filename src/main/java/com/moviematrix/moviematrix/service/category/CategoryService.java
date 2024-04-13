package com.moviematrix.moviematrix.service.category;

import com.moviematrix.moviematrix.entity.Category;


import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);

    Category save(Category user);
    void deleteById(Long id);
}
