package com.moviematrix.moviematrix.service.moviePreference;

import com.moviematrix.moviematrix.entity.MoviePreference;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.MoviePreferenceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoviePreferenceServiceImpl implements MoviePreferenceService{

    private final MoviePreferenceRepository repository;
    @Override
    public List<MoviePreference> findAll() {
        return repository.findAll();
    }

    @Override
    public List<MoviePreference> findAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public MoviePreference findById(Long id) {
        MoviePreference moviePreference = null;
        Optional<MoviePreference> result = repository.findById(id.intValue());

        if(result.isPresent()){
            moviePreference=result.get();
        }
        else{
            throw new RuntimeException("Did not find moviePreference with this id: "+id);
        }
        return moviePreference;
    }

    @Override
    public MoviePreference save(MoviePreference user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public List<MoviePreference> addOrUpdateMoviePreferences(List<Long> movieIds, User user) {
        repository.deleteAllByUser(user);

        List<MoviePreference> moviePreferences = movieIds.stream()
                .map(movieId -> new MoviePreference(null, user, movieId))
                .collect(Collectors.toList());
        return repository.saveAll(moviePreferences);
    }

}
