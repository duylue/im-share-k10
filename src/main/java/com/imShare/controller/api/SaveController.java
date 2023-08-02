package com.imShare.controller.api;

import com.imShare.model.Save;
import com.imShare.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/save")
public class SaveController {
    @Autowired
    SaveService saveService;
    @GetMapping("/find-save")
    public ResponseEntity<?> findSave(@RequestParam("saveId") int saveId,
                                      @RequestParam("page") int page,
                                      @RequestParam("size") int size){
        return saveService.findSave(saveId,page,size);
    }
    @GetMapping("/delete-save")
    public ResponseEntity<?> deleteSave(@RequestParam("postId") int postId){
       return saveService.deleteSave(postId);
    }
    @PostMapping("/save-save")
    public ResponseEntity<?> saveSave(@RequestBody Save save){
        return saveService.saveSave(save);
    }
}
