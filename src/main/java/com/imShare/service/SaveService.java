package com.imShare.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface SaveService {
    ResponseEntity<?> deleteSave(int saveId);
}
