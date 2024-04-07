package com.moviematrix.moviematrix.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @Column(name = "category_id")
    private Long categoryId;

}
