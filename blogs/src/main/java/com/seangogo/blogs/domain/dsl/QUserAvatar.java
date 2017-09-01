package com.seangogo.blogs.domain.dsl;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.seangogo.blogs.domain.UserAvatar;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QUserAvatar is a Querydsl query type for UserAvatar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAvatar extends EntityPathBase<UserAvatar> {

    private static final long serialVersionUID = -53600993L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAvatar userAvatar = new QUserAvatar("userAvatar");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final StringPath id = _super.id;

    public final QUser lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final StringPath src = createString("src");

    public final StringPath userId = createString("userId");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QUserAvatar(String variable) {
        this(UserAvatar.class, forVariable(variable), INITS);
    }

    public QUserAvatar(Path<? extends UserAvatar> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAvatar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAvatar(PathMetadata metadata, PathInits inits) {
        this(UserAvatar.class, metadata, inits);
    }

    public QUserAvatar(Class<? extends UserAvatar> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QUser(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

