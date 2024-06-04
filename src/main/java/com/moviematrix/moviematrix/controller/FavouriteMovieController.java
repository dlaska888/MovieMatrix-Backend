package com.moviematrix.moviematrix.controller;

import com.moviematrix.moviematrix.entity.FavouriteMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.service.favouriteMovie.FavouriteMovieServiceImpl;
import com.moviematrix.moviematrix.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/favouriteMovie")
@RequiredArgsConstructor
public class FavouriteMovieController {
    private final UserServiceImpl userService;
    private final FavouriteMovieServiceImpl movieService;

    @GetMapping
    public List<FavouriteMovie> getAllFavouriteMovies(Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return movieService.findAllByUser(user);
    }

    @GetMapping("/{favouriteMovieId}")
    public FavouriteMovie getSeenMovieById(@PathVariable Long favouriteMovieId) {
        return movieService.findById(favouriteMovieId);
    }

    @PostMapping
    public ResponseEntity<FavouriteMovie> addSeenMovie(@RequestBody Long movieId, Principal connectedUser) {
        String username = connectedUser.getName();
        User user = userService.findByEmail(username);
        FavouriteMovie seenMovie = movieService.save(movieId, user);
        return ResponseEntity.ok(seenMovie);
    }

    @DeleteMapping("/{favouriteMovieId}")
    public void deleteSeenMovie(@PathVariable Long favouriteMovieId, Principal connectedUser) {
        String username = connectedUser.getName();
        User user = userService.findByEmail(username);
        movieService.deleteById(favouriteMovieId, user);
    }
}
