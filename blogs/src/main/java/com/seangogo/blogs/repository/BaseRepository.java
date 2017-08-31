package com.seangogo.blogs.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * JpaRepository接口提供crud和分页接口
 * JpaSpecificationExecutor提供Specification查询接口
 * @NoRepositoryBean让jpa:repositories扫描时忽略
 * @param <T>
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {}
