package com.moviematrix.moviematrix.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preference_movies")
public class MoviePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @Column(name = "movie_id")
    private Long movieId;

}
