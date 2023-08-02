package com.imShare.service.impl;

import com.imShare.model.User;
import com.imShare.repository.UserRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> findAll() {
        return getResponseEntity(userRepository.findAll());
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {
        return getResponseEntity(userRepository.save(user));
    }

    @Override
    public ResponseEntity<?> deleteUser(int userId) {
        userRepository.deleteById(userId);
        return getResponseEntity("xoa thanh cong");
    }
}
