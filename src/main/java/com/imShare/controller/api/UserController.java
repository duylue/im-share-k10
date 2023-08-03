package com.imShare.controller.api;

import com.imShare.model.User;
import com.imShare.service.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/u")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/find-by-username")
    ResponseEntity<?> findByUsername(@RequestParam String uname){
        return userService.findByUsername(uname);
    }

}
