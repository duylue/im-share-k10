package com.imShare.controller.api;

import com.imShare.model.Post;
import com.imShare.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    ResponseEntity<?> createPost(@RequestParam String uname, @RequestBody Post post){
        return postService.createPost(uname,post);
    }
    @GetMapping("/get-all-post-from-following")
    ResponseEntity<?> getAllPostFromFollowing(@RequestParam String uname){
        return postService.getAllPostFromUserFollowing(uname);
    }
    @GetMapping("/check-like")
    ResponseEntity<?> checkLike(@RequestParam String uname, int pid){
        return  postService.checkLike(uname, pid);
    }
    @GetMapping("/create-like")
    ResponseEntity<?> createLike(@RequestParam String uname, int pid){
        return postService.createLike(uname, pid);
    }
    @GetMapping("/delete-like")
    ResponseEntity<?> deleteLike(@RequestParam String uname, int pid){
        return postService.deleteLike(uname, pid);
    }
    @GetMapping("/check-save")
    ResponseEntity<?> checkSave(@RequestParam String uname, int sid){
        return postService.checkSave(uname,sid);
    }
    @GetMapping("/create-save")
    ResponseEntity<?> createSave(@RequestParam String uname, int sid){
        return postService.createSave(uname,sid);
    }
    @GetMapping("/delete-save")
    ResponseEntity<?> deleteSave(@RequestParam String uname, int sid){
        return postService.checkSave(uname,sid);
    }
}
