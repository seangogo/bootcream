package com.seangogo.blogs.repository;

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
public class BaseRepositoryImpl<T extends BaseEntity>
        extends SimpleJpaRepository<T, Serializable> implements BaseRepository<T> {
    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, Serializable> jpaEntityInformation,
                            EntityManager entityManager) {
        super(jpaEntityInformation, entityManager);
        this.entityManager = entityManager;
    }
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
    /**
     * 只做逻辑删除
     */
    @Override
    public void delete(T entity) {
        entity.deleted(true);
        save(entity);
    }
    @Override
    public void delete(Serializable id) {
        T entity = findOne(id);
        entity.deleted(true);
        this.save(entity);
    }
}
