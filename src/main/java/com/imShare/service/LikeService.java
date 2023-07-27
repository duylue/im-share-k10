package com.imShare.service;

import com.imShare.model.UserLike;
import org.springframework.http.ResponseEntity;

public interface LikeService {
    ResponseEntity createLike(UserLike userLike);
    ResponseEntity deleteLike(int likeId);

    ResponseEntity countLikes();
}
