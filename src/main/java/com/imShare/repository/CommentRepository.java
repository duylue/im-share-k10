package com.imShare.repository;

import com.imShare.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT c.* FROM" +
            " comment c left join " +
            "post p ON " +
            "p.post_id = c.post_id" +
            " where c.post_id = :postId", nativeQuery = true)
    List<Map<String, Comment>> findComment(@Param("postId") int postId);
}
