package com.imShare.service.impl;

import com.imShare.exception.BusinessException;
import com.imShare.model.Post;
import com.imShare.repository.PostPagingRepository;
import com.imShare.repository.PostRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl extends BaseResponse implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public ResponseEntity findAll() {
        return getResponseEntity(postRepository.findAll());
    }

    @Override
    public ResponseEntity savePost(Post post) {
        return getResponseEntity(postRepository.save(post));
    }


    @Override
    public ResponseEntity deletePost(int postId) {
        postRepository.deleteById(postId);
        return getResponseEntity("Xoa Thanh Cong");
    }

    @Autowired
    PostPagingRepository postPagingRepository;

    @Override
    public ResponseEntity listPostUserName(String userName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return getResponseEntity(postPagingRepository.findByUserName(userName, pageable));
    }

    @Override
    public ResponseEntity listPostSave(int saveId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return getResponseEntity(postPagingRepository.findBySave(saveId, pageable));
    }


    @Override
    public ResponseEntity listPostFollower(int fid, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return getResponseEntity(postPagingRepository.findByFollower(fid, pageable));
    }
}
