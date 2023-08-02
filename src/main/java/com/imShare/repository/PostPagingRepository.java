package com.imShare.repository;

import com.imShare.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface PostPagingRepository extends PagingAndSortingRepository<Post, Integer> {
    @Query(value = "SELECT p.* FROM" +
            " post p LEFT JOIN post_save s " +
            "ON p.post_id = s.post_id where" +
            " p.save_id= :saveId", nativeQuery = true)
    Page<Map<String, Post>> findBySave(@Param("saveId") int saveId, Pageable pageable);

    @Query(value = "SELECT p.* " +
            "FROM post p " +
            "where p.user_id= :userId", nativeQuery = true)
    Page<Map<String, Post>> findByUserId(@Param("userId") int userId, Pageable pageable);

    @Query(value = "SELECT p.* " +
            "FROM post p left join" +
            " follower f ON " +
            "p.user_id = f.user_id " +
            "where fid = :fid", nativeQuery = true)
    Page<Map<String, Post>> findByFollower(@Param("fid") int fid, Pageable pageable);

}
