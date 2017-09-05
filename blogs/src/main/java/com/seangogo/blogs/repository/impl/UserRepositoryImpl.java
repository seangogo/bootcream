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
        //对于HQL模块，HibernateQuery是Query的主要实现。它被实例化为这样：HQLQuery query = new HibernateQuery (session);
        //要使用JPA API而不是Hibernate API，您可以像这样实例化JPAQuery：HQLQuery query = new JPAQuery (entityManager);
        JPAQuery<User> query = new JPAQuery(this.em);
        QUser qUser = QUser.user;
        User user=new User();
        user.name("ssss");
        System.out.println(user);
        query.from(qUser).where(qUser.name.eq("sean")).fetch();
        BooleanBuilder exp = new BooleanBuilder();
        /*if (StringUtils.isEmpty(id)) {
            exp = exp.and(scategory.site.id.in(siteId));
        }*/
        query.where(exp);
        return query.fetch();

    }

}
