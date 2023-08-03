package com.imShare.service;

import com.imShare.model.Post;
import com.imShare.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    ResponseEntity<?> createPost(String username, Post post);
}
