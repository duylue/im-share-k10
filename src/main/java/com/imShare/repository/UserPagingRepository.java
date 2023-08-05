package com.imShare.repository;

import com.imShare.model.Follower;
import com.imShare.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserPagingRepository extends PagingAndSortingRepository<User, Integer> {
    @Query(value = "select ufl.user_name, p.* from user u, user_followings ufw, user ufl, profile p where u.user_name = :uname \n" +
            "                                                                 and u.user_id= ufw.user_id\n" +
            "                                                                 and  ufw.fid = ufl.fid\n" +
            "                                                                 and ufl.pid = p.pid", nativeQuery = true)
    Page<Map<String, Object>> getFollowingByUsername(@Param("uname") String uname ,Pageable pageable);
}
