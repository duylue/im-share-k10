package com.imShare.service;


import com.imShare.model.User;
import org.springframework.http.ResponseEntity;


public interface UserService {
    void addUser(User user);
    ResponseEntity<?> findByUsername(String username);
}
