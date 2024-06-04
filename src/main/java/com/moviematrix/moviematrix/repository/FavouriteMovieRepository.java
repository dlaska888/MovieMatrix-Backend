package com.moviematrix.moviematrix.repository;

import com.moviematrix.moviematrix.entity.FavouriteMovie;
import com.moviematrix.moviematrix.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteMovieRepository extends JpaRepository<FavouriteMovie,Integer> {
    List<FavouriteMovie> findAllByUser(User user);
    void deleteByIdAndUser(int id, User user);
    void deleteAllByUser(User user);
}
