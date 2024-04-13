package com.moviematrix.moviematrix.controller;


import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.service.category.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl service;
    @GetMapping
    public List<Category> getAllCategories(){
        return service.findAll();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){
        return service.findById(categoryId);
    }
}
