package com.moviematrix.moviematrix.service.moviePreference;

import com.moviematrix.moviematrix.entity.MoviePreference;

import java.util.List;

public interface MoviePreferenceService {

    List<MoviePreference> findAll();
    MoviePreference findById(Long id);

    MoviePreference save(MoviePreference user);
    void deleteById(Long id);
}
