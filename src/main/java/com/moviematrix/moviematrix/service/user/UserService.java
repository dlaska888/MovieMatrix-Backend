package com.moviematrix.moviematrix.service.user;

import com.moviematrix.moviematrix.dto.ChangePasswordRequest;
import com.moviematrix.moviematrix.dto.RegisterRequest;
import com.moviematrix.moviematrix.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    public void changePassword(ChangePasswordRequest request, Principal connectedUser);
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);

    User save(User user);
    void deleteById(Long id);

    User updateUser (RegisterRequest userDto);
}
