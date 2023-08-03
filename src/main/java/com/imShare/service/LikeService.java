package com.imShare.service;

import com.imShare.model.PostLike;
import org.springframework.http.ResponseEntity;

public interface LikeService {
    ResponseEntity createLike(PostLike postLike);
    ResponseEntity deleteLike(int likeId);

    ResponseEntity countLikes();
}
