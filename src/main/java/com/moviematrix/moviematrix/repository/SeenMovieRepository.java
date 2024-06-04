package com.moviematrix.moviematrix.repository;

import com.moviematrix.moviematrix.entity.SeenMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.moviematrix.moviematrix.entity.User;
import java.util.List;


public interface SeenMovieRepository extends JpaRepository<SeenMovie,Integer> {
    List<SeenMovie> findAllByUser(User user);
    void deleteByIdAndUser(int id, User user);
    void deleteAllByUser(User user);
}
