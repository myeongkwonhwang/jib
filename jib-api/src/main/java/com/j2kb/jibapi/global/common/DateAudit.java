package com.j2kb.jibapi.global.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class DateAudit implements Serializable {

    private static final long serialVersionUID = 2493226644381092821L;

    @ApiModelProperty("작성일(시스템에서 자동 처리됨)")
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Date regDt;

    @ApiModelProperty(value = "수정일(시스템에서 자동 처리됨)")
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    protected Date modDt;
}
