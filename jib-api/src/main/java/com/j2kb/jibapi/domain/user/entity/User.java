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
    private Integer userno;

    @ApiModelProperty("이메일")
    private String email;

    @ApiModelProperty("password")
    private String password;

    @ApiModelProperty("member first name")
    private String firstname;

    @ApiModelProperty("member last name")
    private String lastname;

    private String birthyear;

    private String langcd;

    @ApiModelProperty("phone Num")
    private String phonenum;

    @ApiModelProperty("member profile image name")
    private String profileimg;

    private String usertype;

    private String logintype;

    private String snstoken;

    private Date createdat;

    private Date updatedat;

    private String validationImg;

    private Boolean isaccepted;

    private Boolean photoprovided;
}
/*
 validateID: {

         isPhotoIDProvided: `Boolean, optional default = false`,
        isAccepted: `Boolean, default = false`,
        }
  */