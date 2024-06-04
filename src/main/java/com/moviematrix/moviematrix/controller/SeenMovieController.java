package com.moviematrix.moviematrix.controller;

import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.service.seenMovie.SeenMovieServiceImpl;
import com.moviematrix.moviematrix.service.user.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movieSeen")
@RequiredArgsConstructor
public class SeenMovieController {
    private final SeenMovieServiceImpl movieService;
    private final UserServiceImpl userService;

    @GetMapping
    public List<SeenMovie> getAllSeenMovies(Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return movieService.findAllByUser(user);
    }

    @GetMapping("/{seenMovieId}")
    public SeenMovie getSeenMovieById(@PathVariable Long seenMovieId) {
        return movieService.findById(seenMovieId);
    }

    @PostMapping
    public ResponseEntity<SeenMovie> addFavouriteMovies(@RequestBody Long movieId,
            Principal connectedUser) {
        String username = connectedUser.getName();
        User user = userService.findByEmail(username);
        SeenMovie seenMovie = movieService.save(movieId, user);
        return ResponseEntity.ok(seenMovie);
    }

    @DeleteMapping("/{seenMovieId}")
    public void deleteSeenMovie(@PathVariable Long seenMovieId, Principal connectedUser) {
        String username = connectedUser.getName();
        User user = userService.findByEmail(username);
        movieService.deleteById(seenMovieId, user);
    }
}
