package com.imShare.controller.api;

import com.imShare.model.Follower;
import com.imShare.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follower")
public class FollowerController {
    @Autowired
    private FollowerService followerService;
    @PostMapping("/create")
    public ResponseEntity<?> createFollower(@RequestBody Follower follower){
        return followerService.createFollower(follower);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> deletefollower(@RequestParam("fid") int fid){
        return followerService.deleteFollower(fid);
    }
}
