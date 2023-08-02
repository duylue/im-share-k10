package com.imShare.service;

import com.imShare.model.Save;
import com.imShare.model.User;
import org.springframework.http.ResponseEntity;

public interface SaveService {
    ResponseEntity<?> findSave(int saveId,int page, int size);

    ResponseEntity<?> saveSave(Save save);

    ResponseEntity<?> deleteSave(int postId);
}
