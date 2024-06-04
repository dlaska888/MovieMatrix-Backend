package com.moviematrix.moviematrix.controller;


import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.UserRepository;
import com.moviematrix.moviematrix.security.service.JwtService;
import com.moviematrix.moviematrix.service.category.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl service;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @GetMapping
    public List<Category> getAllCategories(){
        return service.findAll();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){
        return service.findById(categoryId);
    }

    @PostMapping
    public ResponseEntity<List<Category>> addCategories(@RequestBody List<Long> categoryIds, HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Category> categories = service.addCategories(categoryIds, user);
        return ResponseEntity.ok(categories);
    }
}
