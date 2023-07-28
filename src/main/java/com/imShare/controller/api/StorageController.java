package com.imShare.controller.api;
import com.imShare.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/storages")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/attachments")
    public ResponseEntity<?> createAttachments(@RequestParam("attachments") List<MultipartFile> files) {
        return service.createAttachment(files);
    }
}
