package com.seangogo.blogs.repository;

import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.repository.support.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sean on 2017/8/31.
 */
@Repository
public interface RoleRepository extends BaseRepository<Role,String> {
}
