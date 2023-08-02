package com.imShare.controller.api;

import com.imShare.model.Post;
import com.imShare.model.User;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/find-all")
    public ResponseEntity<?> findAll() {
        return userService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> deletePost(@RequestParam("userId") int userId) {
        return userService.deleteUser(userId);
    }
}
