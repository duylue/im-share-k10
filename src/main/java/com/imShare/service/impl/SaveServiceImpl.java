package com.imShare.service.impl;

import com.imShare.model.Save;
import com.imShare.model.User;
import com.imShare.repository.SaveRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveServiceImpl extends BaseResponse implements SaveService {
    @Autowired
    SaveRepository saveRepository;
    @Override
    public ResponseEntity<?> findSave(int saveId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return getResponseEntity(saveRepository.findSave(saveId,pageable));
    }

    @Override
    public ResponseEntity<?> saveSave(Save save) {
        return getResponseEntity(saveRepository.save(save));
    }

    @Override
    public ResponseEntity<?> deleteSave(int postId) {
        saveRepository.deleteSave(postId);
        return getResponseEntity("xoa thanh cong");
    }
}
