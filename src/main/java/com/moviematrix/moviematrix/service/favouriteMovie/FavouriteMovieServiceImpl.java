package com.moviematrix.moviematrix.service.favouriteMovie;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.moviematrix.moviematrix.entity.FavouriteMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.FavouriteMovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavouriteMovieServiceImpl implements FavouriteMovieService {
    private final FavouriteMovieRepository repository;

    @Override
    public List<FavouriteMovie> findAll() {
        return repository.findAll();
    }

    @Override
    public List<FavouriteMovie> findAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public FavouriteMovie findById(Long id) {
        FavouriteMovie seenMovie = null;
        Optional<FavouriteMovie> result = repository.findById(id.intValue());

        if (result.isPresent()) {
            seenMovie = result.get();
        } else {
            throw new RuntimeException("Did not find seenMovie with this id: " + id);
        }
        return seenMovie;
    }

    @Override
    public FavouriteMovie save(Long movieId, User user) {
        FavouriteMovie movie = new FavouriteMovie(null, user, movieId);
        return repository.save(movie);
    }

    @Override
    public void deleteById(Long id, User user) {
        repository.findAllByUser(user).stream()
                .filter(favouriteMovie -> favouriteMovie.getMovieId().equals(id))
                .findFirst()
                .ifPresentOrElse(repository::delete, () -> {
                    throw new RuntimeException("Did not find seenMovie with this id: " + id);
                });
    }

    @Override
    public List<FavouriteMovie> addFavouriteMovies(List<Long> movieIds, User user) {
        List<FavouriteMovie> seenMovies = movieIds.stream()
                .map(movieId -> new FavouriteMovie(null, user, movieId))
                .collect(Collectors.toList());
        return repository.saveAll(seenMovies);
    }
}
