package com.moviematrix.moviematrix.controller;

import com.moviematrix.moviematrix.entity.MoviePreference;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.UserRepository;
import com.moviematrix.moviematrix.security.service.JwtService;
import com.moviematrix.moviematrix.service.moviePreference.MoviePreferenceServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/moviePreference")
@RequiredArgsConstructor
public class MoviePreferenceController {

    private final MoviePreferenceServiceImpl service;
    private final JwtService jwtService;
    private final UserRepository userRepository;


    @GetMapping
    public List<MoviePreference> getAllMoviePreferences(){
        return service.findAll();
    }

    @GetMapping("/{moviePreferenceId}")
    public MoviePreference getMoviePreferenceById(@PathVariable Long moviePreferenceId){
        return service.findById(moviePreferenceId);
    }

    @PostMapping
    public ResponseEntity<List<MoviePreference>> addMoviePreferences(@RequestBody List<Long> movieIds, HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<MoviePreference> moviePreferences = service.addMoviePreferences(movieIds, user);
        return ResponseEntity.ok(moviePreferences);
    }
}
