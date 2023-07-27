package com.imShare.service.impl;

import com.imShare.model.User;
import com.imShare.repository.UserRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUserName(username);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }



    @Override
    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return getResponseEntity(users);
    }




}
