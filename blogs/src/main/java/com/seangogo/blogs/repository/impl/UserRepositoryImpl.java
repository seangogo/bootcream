package com.seangogo.blogs.repository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.domain.dsl.QUser;
import com.seangogo.blogs.repository.UserRepositoryPlus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sean on 2017/9/1.
 */
public class UserRepositoryImpl implements UserRepositoryPlus {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<User> getList(String id) {
        JPAQuery<User> query = new JPAQuery<User>(this.em);
        QUser qUser = QUser.user;
        query.from(qUser);
        BooleanBuilder exp = new BooleanBuilder();
        /*if (StringUtils.isEmpty(id)) {
            exp = exp.and(scategory.site.id.in(siteId));
        }*/
        query.where(exp);
        return query.fetch();

    }

}
