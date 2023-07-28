package com.imShare.controller;

import com.imShare.model.Comment;
import com.imShare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/find-comment")
    public ResponseEntity findComment(@RequestParam("postId") int postId) {
        return commentService.findComment(postId);
    }

    @PostMapping("/save")
    public ResponseEntity saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteComment(int cid) {
        return commentService.deleteComment(cid);
    }
}
