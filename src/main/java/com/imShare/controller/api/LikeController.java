package com.imShare.controller;

import com.imShare.model.UserLike;
import com.imShare.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @PostMapping("/create-like")
    public ResponseEntity createLike(@RequestBody UserLike userLike){
        return likeService.createLike(userLike);
    }
    @GetMapping("/delete-like")
    public ResponseEntity deleteLike(@RequestParam("likeId") int likeId){
        return likeService.deleteLike(likeId);
    }
    @GetMapping("/count-like")
    public ResponseEntity countLike(){
        return likeService.countLikes();
    }


}
