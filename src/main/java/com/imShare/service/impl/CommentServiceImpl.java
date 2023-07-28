package com.imShare.service.impl;

import com.imShare.model.Comment;
import com.imShare.repository.CommentRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends BaseResponse implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ResponseEntity saveComment(Comment comment) {
        return getResponseEntity(commentRepository.save(comment));
    }

    @Override
    public ResponseEntity findComment(int postId) {
        return getResponseEntity(commentRepository.findComment(postId));
    }

    @Override
    public ResponseEntity deleteComment(int cid) {
        commentRepository.deleteById(cid);
        return getResponseEntity("xoa thanh cong");
    }
}
