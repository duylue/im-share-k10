package com.imShare.service.impl;

import com.imShare.exception.BusinessException;
import com.imShare.model.Comment;
import com.imShare.model.Post;
import com.imShare.model.PostLike;
import com.imShare.model.User;
import com.imShare.repository.PostPagingRepository;
import com.imShare.repository.PostRepository;
import com.imShare.repository.UserRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl extends BaseResponse implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseEntity<?> createPost(String username, Post post) {
        User user = userRepository.findByUserName(username);
        List<Comment> comments = new ArrayList<>();
        post.setComments(comments);
        PostLike postLike = new PostLike();
        post.setPostLike(postLike);
        List<Post> posts = user.getPosts();
        posts.add(post);
        user.setPosts(posts);
        post.setUser(user);
        postRepository.save(post);
        userRepository.save(user);
        return getResponseEntity("Tạo thành công");
    }
}
