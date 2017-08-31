package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import com.seangogo.blogs.repository.BaseRepository;
import com.seangogo.blogs.repository.UserRepository;
import com.seangogo.blogs.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sean on 2017/8/31.
 */
@Service
public abstract class BaseServiceImpl<Entity extends BaseEntity> implements BaseService<Entity>  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BaseRepository<User,String> baseRepository;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public <T> Serializable save(T obj) {
        return (Serializable) baseRepository.save(obj);
    }

    @Override
    public <T> void delete(T obj) {
        baseRepository.delete(obj);
    }

    @Override
    public <T> void update(T obj) {
        baseRepository.save(obj);
    }

    @Override
    public Object saveOrUpdate(Object obj) {
        return baseRepository.save(obj);
    }

    @Override
    public <T> void batchSave(List<T> entityList) {
        for(int i = 0; i < entityList.size(); i++) {
            em.persist(entityList.get(i));
            if(i % 30== 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Override
    public <T> void batchUpdate(List<T> entityList) {
        for(int i = 0; i < entityList.size(); i++) {
            em.merge(entityList.get(i));
            if(i % 30== 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Override
    public <T> void batchDelete(List<T> entityList) {
        for(int i = 0; i < entityList.size(); i++) {
            em.detach(entityList.get(i));
            if(i % 30== 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
