package com.imShare.service;

import com.imShare.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
    ResponseEntity<?> findAll();





}