package com.imShare.repository;

import com.imShare.model.Save;
import com.imShare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRepository extends JpaRepository<Save, Integer> {
    Save findSaveByUser(User user);
}
