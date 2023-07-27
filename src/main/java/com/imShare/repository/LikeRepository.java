package com.imShare.repository;

import com.imShare.model.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<UserLike,Integer> {
}
