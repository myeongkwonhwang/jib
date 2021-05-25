package com.j2kb.jibapi.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -668686808L;

    public static final QUser user = new QUser("user");

    public final StringPath authority = createString("authority");

    public final StringPath birthYear = createString("birthYear");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> dstNo = createNumber("dstNo", Long.class);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final BooleanPath isAccepted = createBoolean("isAccepted");

    public final StringPath languageCode = createString("languageCode");

    public final StringPath lastName = createString("lastName");

    public final StringPath loginType = createString("loginType");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final BooleanPath photoProvided = createBoolean("photoProvided");

    public final StringPath profileImg = createString("profileImg");

    public final StringPath snsToken = createString("snsToken");

    public final StringPath state = createString("state");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public final StringPath userType = createString("userType");

    public final ArrayPath<byte[], Byte> validationImg = createArray("validationImg", byte[].class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

