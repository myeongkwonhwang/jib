package com.j2kb.jibapi.domain.user.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Entity
@Table(name = "user")
@ApiModel(value = "user", description = "사용자")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("멤버 idx")
    private Integer no;

    @ApiModelProperty("이메일")
    private String email;

    @ApiModelProperty("password")
    private String password;

    @ApiModelProperty("member first name")
    private String firstName;

    @ApiModelProperty("member last name")
    private String lastName;

    private String birthYear;

    private String langCd;

    @ApiModelProperty("phone Num")
    private String phoneNum;

    @ApiModelProperty("member profile image name")
    private String profileImg;

    private String loginType;

    private String snsToken;

    private Date createdAt;

    private Date updatedAt;
}