package com.moviematrix.moviematrix.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Category> categories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SeenMovie> seenMovies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MoviePreference> moviePreferences;

}
