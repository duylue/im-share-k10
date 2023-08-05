package com.imShare.controller.api;

import com.imShare.model.Profile;
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
    @PostMapping("/edit-profile")
    ResponseEntity<?> editProfile(@RequestParam String uname, @RequestBody Profile profile){
        return userService.editProfile(uname, profile);
    }
    @PostMapping("/change-password")
    ResponseEntity<?> changePassword(@RequestParam String uname,
                                     @RequestParam String opass,
                                     @RequestParam String npass){
        return userService.changePass(uname,opass,npass);
    }
    @GetMapping("get-following-by-uname")
    ResponseEntity<?> getFollowingByUsername(@RequestParam String uname,@RequestParam int page, @RequestParam int size){
        return userService.getFollowingByUsername(uname,page,size);
    }
    @GetMapping("/following")
    ResponseEntity<?> following (@RequestParam String u, @RequestParam String uf){
        return userService.following(u, uf);
    }
    @GetMapping("/unfollow")
    ResponseEntity<?> unfollow (@RequestParam String u, @RequestParam String uf){
        return userService.unfollow(u, uf);
    }
    @GetMapping("/get-user-not-follow")
    ResponseEntity<?> getUserNotFollow (@RequestParam String uname){
        return userService.getUserNotFollow(uname);
    }

}
