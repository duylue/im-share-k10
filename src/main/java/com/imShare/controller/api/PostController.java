package com.imShare.controller;

import com.imShare.model.Post;
import com.imShare.service.PostService;
import com.imShare.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return postService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("/delete")
    public ResponseEntity deletePost(@RequestParam("postId") int postId) {
        return postService.deletePost(postId);
    }

    @GetMapping("/list-post-userName")
    public ResponseEntity listPostUserName(@RequestParam("userName") String userName,
                                           @RequestParam("page") int page,
                                           @RequestParam("size") int size) {
        return postService.listPostUserName(userName, page, size);
    }

    @GetMapping("/list-post-save")
    public ResponseEntity listPostSave(@RequestParam("saveId") int saveId,
                                       @RequestParam("page") int page,
                                       @RequestParam("size") int size) {
        return postService.listPostSave(saveId, page, size);
    }

    @GetMapping("/list-post-follower")
    public ResponseEntity listPostFollower(@RequestParam("fid") int fid,
                                           @RequestParam("page") int page,
                                           @RequestParam("size") int size) {
        return postService.listPostSave(fid, page, size);
    }
}
