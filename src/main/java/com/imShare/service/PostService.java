package com.imShare.service;

import com.imShare.model.Post;
import com.imShare.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    ResponseEntity<?> findAll();

    ResponseEntity<?> savePost(Post post);

    ResponseEntity<?> deletePost(int postId);

    ResponseEntity<?> listPostUserName(String userName, int page, int size);

    ResponseEntity<?> listPostSave(int saveId, int page, int size);

    ResponseEntity listPostFollower(int fid, int page, int size);
}
