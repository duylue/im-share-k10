package com.imShare.service;


import com.imShare.model.Profile;
import com.imShare.model.User;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;


public interface UserService {
    void addUser(User user);
    ResponseEntity<?> findByUsername(String username);
    ResponseEntity<?> editProfile(String username ,Profile profile);
    ResponseEntity<?> changePass(String username,String oldpassword, String password);
    ResponseEntity<?> getFollowingByUsername(String uname, int page, int size);
    ResponseEntity<?> following(String usename, String usernameFollower);
    ResponseEntity<?> unfollow(String username, String usernameFollower);
    ResponseEntity<?> getUserNotFollow(String username);
}
