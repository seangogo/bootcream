package com.seangogo.blogs.config;

import com.seangogo.blogs.pojo.Base.BaseEntity;
import com.seangogo.blogs.repository.support.BaseRepository;
import com.seangogo.blogs.repository.support.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;
public class BaseRepositoryFactoryBean<R extends JpaRepository<T, Serializable>, T> extends JpaRepositoryFactoryBean<R, T, Serializable> {

    public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
        return new JpaRepositoryFactory(entityManager) {

            protected SimpleJpaRepository<T, Serializable> getTargetRepository(
                    RepositoryInformation information, EntityManager entityManager) {
                Class<T> domainClass = (Class<T>) information.getDomainType();
                if(BaseEntity.class.isAssignableFrom(domainClass)) {
                    return new BaseRepositoryImpl(domainClass, entityManager);
                } else {
                    return new SimpleJpaRepository(domainClass, entityManager);
                }
            }

            @Override
            protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
                return metadata.getDomainType().isAssignableFrom(BaseRepository.class) ? BaseRepository.class : SimpleJpaRepository.class;
            }
        };
    }
}
