package com.imShare.repository;

import com.imShare.model.Post;
import com.imShare.model.Save;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SaveRepository extends JpaRepository<Save, Integer> {
    @Query(value = "select p.* from post p left join post_save ps\n" +
            "    on p.post_id = ps.post_id where ps.save_id= :saveId", nativeQuery = true)
    Page<Map<String, Post>> findSave(@Param("saveId") int saveId, Pageable pageable);
    @Query(value = "DELETE\n" +
            "from post_save\n" +
            "where post_id = :postId",nativeQuery = true)
 void deleteSave(@Param("postId") int postId);
}

