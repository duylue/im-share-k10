package com.imShare.service.impl;

import com.imShare.model.Follower;
import com.imShare.model.UserLike;
import com.imShare.repository.FollowerRepository;
import com.imShare.repository.LikeRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowerServiceImpl extends BaseResponse implements FollowerService {
    @Autowired
    private FollowerRepository followerRepository;
    @Override
    public ResponseEntity createFollower(Follower follower) {
        return getResponseEntity(followerRepository.save(follower));
    }

    @Override
    public ResponseEntity deleteFollower(int fid) {
        followerRepository.deleteById(fid);
        return getResponseEntity("xoa thanh cong");
    }
}
