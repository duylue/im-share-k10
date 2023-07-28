package com.imShare.service;

import com.imShare.model.Follower;
import org.springframework.http.ResponseEntity;

public interface FollowerService {
    ResponseEntity createFollower(Follower follower);
    ResponseEntity deleteFollower(int fid);
}
