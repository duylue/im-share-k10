package com.imShare.repository;

import com.imShare.model.Comment;
import com.imShare.model.Post;
import com.imShare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentByUser(User user);
    List<Comment> findAllByPost(Post post);
}
