package com.seangogo.blogs.domain.dsl;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.seangogo.blogs.domain.FunctionFilter;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFunctionFilter is a Querydsl query type for FunctionFilter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFunctionFilter extends EntityPathBase<FunctionFilter> {

    private static final long serialVersionUID = 314584075L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFunctionFilter functionFilter = new QFunctionFilter("functionFilter");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath classType = createString("classType");

    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath functionId = createString("functionId");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath key = createString("key");

    public final QUser lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath operator = createString("operator");

    public final StringPath roleId = createString("roleId");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final StringPath value = createString("value");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QFunctionFilter(String variable) {
        this(FunctionFilter.class, forVariable(variable), INITS);
    }

    public QFunctionFilter(Path<? extends FunctionFilter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFunctionFilter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFunctionFilter(PathMetadata metadata, PathInits inits) {
        this(FunctionFilter.class, metadata, inits);
    }

    public QFunctionFilter(Class<? extends FunctionFilter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QUser(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

