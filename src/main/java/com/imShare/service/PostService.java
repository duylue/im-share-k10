package com.imShare.service;

import com.imShare.model.Post;
import com.imShare.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    ResponseEntity<?> createPost(String username, Post post);
    ResponseEntity<?> getAllPostFromUserFollowing(String username);
    ResponseEntity<?> checkLike(String username, int postId);
    ResponseEntity<?> createLike(String username, int postId);
    ResponseEntity<?> deleteLike(String username, int postId);
    ResponseEntity<?> checkSave  (String username, int postId);
    ResponseEntity<?> createSave  (String username, int postId);
    ResponseEntity<?> deleteSave  (String username, int postId);

}
