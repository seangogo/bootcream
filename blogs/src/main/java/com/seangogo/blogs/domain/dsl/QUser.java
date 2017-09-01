package com.seangogo.blogs.domain.dsl;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.seangogo.blogs.domain.User;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 236233766L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.util.Date> birthday = createDateTime("birthday", java.util.Date.class);

    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath deptId = createString("deptId");

    public final StringPath email = createString("email");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath isSuperAdmin = createString("isSuperAdmin");

    public final QUser lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath loginName = createString("loginName");

    public final StringPath mobile = createString("mobile");

    public final StringPath name = createString("name");

    public final StringPath openAccount = createString("openAccount");

    public final StringPath password = createString("password");

    public final StringPath qq = createString("qq");

    public final StringPath sex = createString("sex");

    public final StringPath telphone = createString("telphone");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public final StringPath wechat = createString("wechat");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QUser(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

