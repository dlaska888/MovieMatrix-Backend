package com.moviematrix.moviematrix.controller;


import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.service.seenMovie.SeenMovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movieSeen")
@RequiredArgsConstructor
public class SeenMovieController {
    private final SeenMovieServiceImpl service;

    @GetMapping
    public List<SeenMovie> getAllSeenMovies(){
        return service.findAll();
    }

    @GetMapping("/{seenMovieId}")
    public SeenMovie getSeenMovieById(@PathVariable Long seenMovieId){
        return service.findById(seenMovieId);
    }
}
