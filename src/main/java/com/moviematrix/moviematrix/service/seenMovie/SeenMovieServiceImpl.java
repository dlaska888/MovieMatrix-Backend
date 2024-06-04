package com.moviematrix.moviematrix.service.seenMovie;

import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.SeenMovieRepository;
import com.moviematrix.moviematrix.repository.UserRepository;
import com.moviematrix.moviematrix.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SeenMovieServiceImpl implements SeenMovieService{

    private final SeenMovieRepository repository;
    private final UserRepository userRepository;
    @Override
    public List<SeenMovie> findAll() {
        return repository.findAll();
    }

    @Override
    public SeenMovie findById(Long id) {
        SeenMovie seenMovie = null;
        Optional<SeenMovie> result = repository.findById(id.intValue());

        if(result.isPresent()){
            seenMovie=result.get();
        }
        else{
            throw new RuntimeException("Did not find seenMovie with this id: "+id);
        }
        return seenMovie;
    }

    @Override
    public SeenMovie save(SeenMovie user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<SeenMovie> addSeenMovies(List<Long> movieIds, User user) {
        List<SeenMovie> seenMovies = movieIds.stream()
                .map(movieId -> new SeenMovie(null, user, movieId))
                .collect(Collectors.toList());
        return repository.saveAll(seenMovies);
    }
}
