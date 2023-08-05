package com.imShare.repository;

import com.imShare.model.Follower;
import com.imShare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower,Integer> {
    Follower findFollowerByUser(User user);
    List<Follower> findAll();
}
