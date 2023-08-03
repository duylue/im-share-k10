package com.imShare.controller.api;

import com.imShare.model.Post;
import com.imShare.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    ResponseEntity<?> createPost(@RequestParam String uname, @RequestBody Post post){
        return postService.createPost(uname,post);
    }

}
