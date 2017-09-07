package com.seangogo.blogs.repository;

import com.seangogo.blogs.domain.Resource;
import com.seangogo.blogs.repository.support.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by sean on 2017/9/7.
 */
public interface ResourceRepository extends BaseRepository<Resource,String> {
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM tb_role_resource WHERE resource_id = :id")
    void deleteGrant(@Param("id") String id);
}
