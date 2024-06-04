package com.moviematrix.moviematrix.controller;

import com.moviematrix.moviematrix.dto.ChangePasswordRequest;
import com.moviematrix.moviematrix.dto.RegisterRequest;
import com.moviematrix.moviematrix.entity.User;
import com.moviematrix.moviematrix.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return service.findById(userId);
    }


    @PutMapping()
    public ResponseEntity<User> updateUser( @RequestBody RegisterRequest userDto) {
        User updatedUser = service.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

}
