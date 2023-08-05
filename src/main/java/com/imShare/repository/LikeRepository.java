package com.imShare.repository;

import com.imShare.model.Post;
import com.imShare.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<PostLike,Integer> {
    PostLike findByPost (Post post);
}
