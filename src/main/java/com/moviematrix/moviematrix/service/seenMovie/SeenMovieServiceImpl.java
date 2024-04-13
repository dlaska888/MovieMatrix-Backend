package com.moviematrix.moviematrix.service.seenMovie;

import com.moviematrix.moviematrix.entity.SeenMovie;
import com.moviematrix.moviematrix.repository.SeenMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SeenMovieServiceImpl implements SeenMovieService{

    private final SeenMovieRepository repository;
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
}
