package com.imShare.controller;

import com.imShare.model.User;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user-api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get-all-user")
    public ResponseEntity<?> getUsers(){
        return userService.findAll();
    }

}

