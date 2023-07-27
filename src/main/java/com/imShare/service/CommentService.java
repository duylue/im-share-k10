package com.imShare.service;

import com.imShare.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity saveComment(Comment comment);

    ResponseEntity findComment(int PostId);

    ResponseEntity deleteComment(int cid);
}
