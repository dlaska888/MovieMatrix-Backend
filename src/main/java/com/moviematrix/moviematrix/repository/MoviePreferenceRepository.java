package com.moviematrix.moviematrix.repository;


import com.moviematrix.moviematrix.entity.MoviePreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePreferenceRepository extends JpaRepository<MoviePreference,Integer> {
}
