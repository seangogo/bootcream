package com.seangogo.blog.repository;

import com.seangogo.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sean on 2017/8/24.
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
