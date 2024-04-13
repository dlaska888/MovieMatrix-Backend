package com.moviematrix.moviematrix.repository;

import com.moviematrix.moviematrix.entity.SeenMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeenMovieRepository extends JpaRepository<SeenMovie,Integer> {
}
