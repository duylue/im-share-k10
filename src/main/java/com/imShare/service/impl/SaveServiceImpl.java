package com.imShare.service.impl;

import com.imShare.exception.BusinessException;
import com.imShare.repository.SaveRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.SaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveServiceImpl extends BaseResponse implements SaveService {
    private SaveRepository saveRepository;
    @Override
    public ResponseEntity<?> deleteSave(int saveId) {
        try {
            saveRepository.deleteById(saveId);
            return getResponseEntity("Xoa Thanh Cong");
        } catch (Exception e) {
            throw new BusinessException(500, e.getMessage());
        }
    }

}
