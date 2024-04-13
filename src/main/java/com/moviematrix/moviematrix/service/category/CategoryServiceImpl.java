package com.moviematrix.moviematrix.service.category;

import com.moviematrix.moviematrix.entity.Category;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Category category = null;
        Optional<Category> result = repository.findById(id.intValue());

        if(result.isPresent()){
            category=result.get();
        }
        else{
            throw new RuntimeException("Did not find category with this id: "+id);
        }
        return category;
    }

    @Override
    public Category save(Category user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
