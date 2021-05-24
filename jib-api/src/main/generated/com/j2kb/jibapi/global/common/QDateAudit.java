package com.j2kb.jibapi.global.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateAudit is a Querydsl query type for DateAudit
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QDateAudit extends EntityPathBase<DateAudit> {

    private static final long serialVersionUID = 1092159520L;

    public static final QDateAudit dateAudit = new QDateAudit("dateAudit");

    public final DateTimePath<java.time.Instant> modDt = createDateTime("modDt", java.time.Instant.class);

    public final DateTimePath<java.util.Date> regDt = createDateTime("regDt", java.util.Date.class);

    public QDateAudit(String variable) {
        super(DateAudit.class, forVariable(variable));
    }

    public QDateAudit(Path<? extends DateAudit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateAudit(PathMetadata metadata) {
        super(DateAudit.class, metadata);
    }

}

