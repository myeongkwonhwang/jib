package com.j2kb.jibapi.domain.destination.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDestination is a Querydsl query type for Destination
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDestination extends EntityPathBase<Destination> {

    private static final long serialVersionUID = -948166600L;

    public static final QDestination destination = new QDestination("destination");

    public final com.j2kb.jibapi.global.common.QDateAudit _super = new com.j2kb.jibapi.global.common.QDateAudit(this);

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final NumberPath<Long> dstNo = createNumber("dstNo", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    //inherited
    public final DateTimePath<java.time.Instant> modDt = _super.modDt;

    public final StringPath name = createString("name");

    public final StringPath province = createString("province");

    //inherited
    public final DateTimePath<java.util.Date> regDt = _super.regDt;

    public final StringPath zipCode = createString("zipCode");

    public QDestination(String variable) {
        super(Destination.class, forVariable(variable));
    }

    public QDestination(Path<? extends Destination> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDestination(PathMetadata metadata) {
        super(Destination.class, metadata);
    }

}

