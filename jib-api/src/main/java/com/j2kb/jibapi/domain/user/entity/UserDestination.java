package com.j2kb.jibapi.domain.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by mkhwang on 2021/05/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Entity
@Table(name = "user_dst")
@ApiModel(value = "user_dst", description = "사용자_목적지 매핑테이블")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(UserDestinationKey.class)
public class UserDestination {

    @Id
    @ApiModelProperty(value = "사용자 고유번호")
    @Column(name = "user_no")
    private Long userNo;

    @Id
    @ApiModelProperty(value = "목적지 고유번호")
    @Column(name = "dst_no")
    private Long dstNo;

}
