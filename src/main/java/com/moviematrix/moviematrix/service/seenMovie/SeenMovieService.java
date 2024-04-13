package com.moviematrix.moviematrix.service.seenMovie;


import com.moviematrix.moviematrix.entity.SeenMovie;

import java.util.List;

public interface SeenMovieService {

    List<SeenMovie> findAll();
    SeenMovie findById(Long id);

    SeenMovie save(SeenMovie user);
    void deleteById(Long id);
}
