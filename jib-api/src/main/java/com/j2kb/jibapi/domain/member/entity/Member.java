package com.j2kb.jibapi.domain.member.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Entity
@Table(name = "member")
@ApiModel(value = "member", description = "사용자")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("멤버 idx")
    private Integer memberNo;

    @ApiModelProperty("member Id")
    private String memberId;

    @ApiModelProperty("password")
    private String password;

    @ApiModelProperty("member Name")
    private String memberName;

    @ApiModelProperty("phone Number")
    private String phoneNumber;
}
