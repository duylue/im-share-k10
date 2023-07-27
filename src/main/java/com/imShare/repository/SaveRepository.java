package com.imShare.repository;

import com.imShare.model.Save;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRepository extends JpaRepository<Save, Integer> {
}
