package com.seangogo.blogs.repository.support;

import com.seangogo.blogs.pojo.Base.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by sean on 2017/8/31.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Transactional
public class BaseRepositoryImpl<T extends BaseEntity,ID extends Serializable> extends SimpleJpaRepository<T, ID> {

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
