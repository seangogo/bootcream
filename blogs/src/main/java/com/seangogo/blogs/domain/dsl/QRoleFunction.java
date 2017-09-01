package com.seangogo.blogs.domain.dsl;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.seangogo.blogs.domain.RoleFunction;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRoleFunction is a Querydsl query type for RoleFunction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleFunction extends EntityPathBase<RoleFunction> {

    private static final long serialVersionUID = -1520193591L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoleFunction roleFunction = new QRoleFunction("roleFunction");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath functionId = createString("functionId");

    //inherited
    public final StringPath id = _super.id;

    public final QUser lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath remark = createString("remark");

    public final StringPath roleId = createString("roleId");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRoleFunction(String variable) {
        this(RoleFunction.class, forVariable(variable), INITS);
    }

    public QRoleFunction(Path<? extends RoleFunction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoleFunction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoleFunction(PathMetadata metadata, PathInits inits) {
        this(RoleFunction.class, metadata, inits);
    }

    public QRoleFunction(Class<? extends RoleFunction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QUser(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

