package com.moviematrix.moviematrix.service.seenMovie;


import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.entity.User;

import java.util.List;

public interface SeenMovieService {
    List<SeenMovie> findAll();
    List<SeenMovie> findAllByUser(User user);
    SeenMovie findById(Long id);
    SeenMovie save(Long movieId, User user);
    void deleteById(Long movieId, User user);

    List<SeenMovie> addSeenMovies(List<Long> movieIds, User user);
}
