package com.imShare.service;

import com.imShare.model.Post;
import com.imShare.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> findAll();

    ResponseEntity<?> saveUser(User user);

    ResponseEntity<?> deleteUser(int userId);
}
