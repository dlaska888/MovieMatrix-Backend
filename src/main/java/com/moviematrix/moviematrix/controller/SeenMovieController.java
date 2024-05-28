package com.moviematrix.moviematrix.controller;


import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.UserRepository;
import com.moviematrix.moviematrix.security.service.JwtService;
import com.moviematrix.moviematrix.service.seenMovie.SeenMovieServiceImpl;
import com.moviematrix.moviematrix.service.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movieSeen")
@RequiredArgsConstructor
public class SeenMovieController {
    private final SeenMovieServiceImpl service;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @GetMapping
    public List<SeenMovie> getAllSeenMovies(){
        return service.findAll();
    }

    @GetMapping("/{seenMovieId}")
    public SeenMovie getSeenMovieById(@PathVariable Long seenMovieId){
        return service.findById(seenMovieId);
    }

    @PostMapping
    public ResponseEntity<List<SeenMovie>> addSeenMovies(@RequestBody List<Long> movieIds, HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<SeenMovie> seenMovies = service.addSeenMovies(movieIds, user);
        return ResponseEntity.ok(seenMovies);
    }
}
