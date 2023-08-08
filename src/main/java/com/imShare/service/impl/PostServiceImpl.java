package com.imShare.service.impl;

import com.imShare.exception.BusinessException;
import com.imShare.model.*;
import com.imShare.repository.*;
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
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private SaveRepository saveRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public ResponseEntity<?> createPost(String username, Post post) {
        User user = userRepository.findByUserName(username);
        List<Comment> comments = new ArrayList<>();
        post.setComments(comments);
        PostLike postLike = new PostLike();
        List<User> users = new ArrayList<>();
        postLike.setUsers(users);
        post.setPostLike(postLike);
        postLike.setPost(post);
        List<Post> posts = user.getPosts();
        posts.add(post);
        user.setPosts(posts);
        post.setUser(user);
        postRepository.save(post);
        userRepository.save(user);
        return getResponseEntity("Tạo thành công");
    }

    @Override
    public ResponseEntity<?> getAllPostFromUserFollowing(String username) {
        User user = userRepository.findByUserName(username);
        List<Follower> followings = user.getFollowings();
        List<Post> postList = new ArrayList<>();
        for (Follower f:followings) {
            List<Post> posts = postRepository.findByUser(f.getUser());
            postList.addAll(posts);
        }
        return getResponseEntity(postList);
    }

    @Override
    public ResponseEntity<?> checkLike(String username, int postId) {
        Post post = postRepository.findByPostId(postId);
        PostLike postLike = likeRepository.findByPost(post);
        List<User> users = postLike.getUsers();
        boolean check = false;
        for (User u:users
             ) {if(u.getUserName().equals(username)){
                 check = true;
        }

        }
        return getResponseEntity(check);
    }

    @Override
    public ResponseEntity<?> createLike(String username, int postId) {
        Post post = postRepository.findByPostId(postId);
        PostLike postLike = likeRepository.findByPost(post);
        User user = userRepository.findByUserName(username);
        user.getPostLikes().add(postLike);
        postLike.getUsers().add(user);
        likeRepository.save(postLike);
        return getResponseEntity("Like thành công");

    }
    @Override
    public ResponseEntity<?> deleteLike(String username, int postId) {
        Post post = postRepository.findByPostId(postId);
        PostLike postLike = likeRepository.findByPost(post);
        User user = userRepository.findByUserName(username);
        user.getPostLikes().remove(postLike);
        postLike.getUsers().remove(user);
        likeRepository.save(postLike);
        return getResponseEntity("Xoá thành công");

    }

    @Override
    public ResponseEntity<?> checkSave(String username, int postId) {
        User user = userRepository.findByUserName(username);
        Save save = saveRepository.findSaveByUser(user);
        Post post = postRepository.findByPostId(postId);
        List<Save> saves = post.getSaves();
        Boolean check = false;
        for (Save s:saves
             ) { if(s.getSaveId()== save.getSaveId()){
                 check = true;
        }
        }
        return getResponseEntity(check);
    }

    @Override
    public ResponseEntity<?> createSave(String username, int postId) {
        User user = userRepository.findByUserName(username);
        Save save = saveRepository.findSaveByUser(user);
        Post post = postRepository.findByPostId(postId);
        save.getPosts().add(post);
        post.getSaves().add(save);
        saveRepository.save(save);
        return getResponseEntity("Save thành công");
    }

    @Override
    public ResponseEntity<?> deleteSave(String username, int postId) {
        User user = userRepository.findByUserName(username);
        Save save = saveRepository.findSaveByUser(user);
        Post post = postRepository.findByPostId(postId);
        save.getPosts().remove(post);
        post.getSaves().remove(save);
        saveRepository.save(save);
        return getResponseEntity("Delete thành công");
    }

    @Override
    public ResponseEntity<?> createComment(String username, int postId, Comment comment) {
        User user = userRepository.findByUserName(username);
        Post post = postRepository.findByPostId(postId);
        comment.setUser(user);
        comment.setPost(post);
        user.getComments().add(comment);
        post.getComments().add(comment);
        commentRepository.save(comment);
        return getResponseEntity("Comment Thành Công");
    }

    @Override
    public ResponseEntity<?> getPostByPostId(int postId) {
        return getResponseEntity(postRepository.findByPostId(postId));
    }

}
