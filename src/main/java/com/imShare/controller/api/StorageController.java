package com.imShare.controller.api;
import com.imShare.domain.FileMetadata;
import com.imShare.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/storages")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/attachments")
    public ResponseEntity<?> createAttachments(@RequestPart(value = "attachments") List<MultipartFile> files) {
        return service.createAttachment(files);
    }
}
