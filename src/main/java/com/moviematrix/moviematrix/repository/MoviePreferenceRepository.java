package com.moviematrix.moviematrix.repository;


import com.moviematrix.moviematrix.entity.MoviePreference;
import com.moviematrix.moviematrix.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePreferenceRepository extends JpaRepository<MoviePreference,Integer> {
    List<MoviePreference> findAllByUser(User user);
    void deleteAllByUser(User user);
}
