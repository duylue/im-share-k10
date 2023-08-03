package com.imShare.service.impl;

import com.imShare.model.PostLike;
import com.imShare.repository.LikeRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl extends BaseResponse implements LikeService {
@Autowired
private LikeRepository likeRepository;

    @Override
    public ResponseEntity createLike(PostLike postLike) {
        return getResponseEntity(likeRepository.save(postLike));
    }

    @Override
    public ResponseEntity deleteLike(int likeId) {
        likeRepository.deleteById(likeId);
        return getResponseEntity("xoa thanh cong");
    }

    @Override
    public ResponseEntity countLikes() {
        return getResponseEntity(likeRepository.count());
    }
}
