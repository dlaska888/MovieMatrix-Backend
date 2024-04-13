package com.moviematrix.moviematrix.service.user;

import com.moviematrix.moviematrix.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    public void changePassword(ChangePasswordRequest request, Principal connectedUser);
    List<User> findAll();
    User findById(Long id);

    User save(User user);
    void deleteById(Long id);
}
