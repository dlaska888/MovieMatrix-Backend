package com.moviematrix.moviematrix.service.moviePreference;

import com.moviematrix.moviematrix.entity.MoviePreference;
import com.moviematrix.moviematrix.entity.User;

import java.util.List;

public interface MoviePreferenceService {

    List<MoviePreference> findAll();
    MoviePreference findById(Long id);

    MoviePreference save(MoviePreference user);
    void deleteById(Long id);

    List<MoviePreference> addMoviePreferences(List<Long> movieIds, User user);
}
