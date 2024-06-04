package com.moviematrix.moviematrix.service.seenMovie;

import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.SeenMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeenMovieServiceImpl implements SeenMovieService {
    private final SeenMovieRepository repository;

    @Override
    public List<SeenMovie> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SeenMovie> findAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public SeenMovie findById(Long id) {
        SeenMovie seenMovie = null;
        Optional<SeenMovie> result = repository.findById(id.intValue());

        if (result.isPresent()) {
            seenMovie = result.get();
        } else {
            throw new RuntimeException("Did not find seenMovie with this id: " + id);
        }
        return seenMovie;
    }

    @Override
    public SeenMovie save(Long movieId, User user) {
        SeenMovie seenMovie = new SeenMovie(null, user, movieId);
        return repository.save(seenMovie);
    }

    @Override
    public void deleteById(Long movieId, User user) {
        repository.findAllByUser(user).stream()
                .filter(favouriteMovie -> favouriteMovie.getMovieId().equals(movieId))
                .findFirst()
                .ifPresentOrElse(repository::delete, () -> {
                    throw new RuntimeException("Did not find seenMovie with this id: " + movieId);
                });
    }

    @Override
    public List<SeenMovie> addSeenMovies(List<Long> movieIds, User user) {
        List<SeenMovie> seenMovies = movieIds.stream()
                .map(movieId -> new SeenMovie(null, user, movieId))
                .collect(Collectors.toList());
        return repository.saveAll(seenMovies);
    }
}
