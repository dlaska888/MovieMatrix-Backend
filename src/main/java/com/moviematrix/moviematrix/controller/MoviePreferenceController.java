package com.moviematrix.moviematrix.controller;

import com.moviematrix.moviematrix.entity.MoviePreference;
import com.moviematrix.moviematrix.service.moviePreference.MoviePreferenceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/moviePreference")
@RequiredArgsConstructor
public class MoviePreferenceController {

    private final MoviePreferenceServiceImpl service;

    @GetMapping
    public List<MoviePreference> getAllMoviePreferences(){
        return service.findAll();
    }

    @GetMapping("/{moviePreferenceId}")
    public MoviePreference getMoviePreferenceById(@PathVariable Long moviePreferenceId){
        return service.findById(moviePreferenceId);
    }
}
