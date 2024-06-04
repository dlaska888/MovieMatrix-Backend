package com.moviematrix.moviematrix.service.favouriteMovie;

import java.util.List;

import com.moviematrix.moviematrix.entity.FavouriteMovie;
import com.moviematrix.moviematrix.entity.User;

public interface FavouriteMovieService {
    List<FavouriteMovie> findAll();
    List<FavouriteMovie> findAllByUser(User user);
    FavouriteMovie findById(Long id);
    FavouriteMovie save(Long movieId, User user);
    void deleteById(Long movieId, User user);

    List<FavouriteMovie> addFavouriteMovies(List<Long> movieIds, User user);
}
