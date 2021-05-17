package com.j2kb.jibapi.domain.user.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

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
    @Column(name = "user_no")
    private Integer userNo;

    @ApiModelProperty("이메일")
    @Column(name = "email")
    private String email;

    @ApiModelProperty("password")
    @Column(name = "password")
    private String password;

    @ApiModelProperty("member first name")
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty("member last name")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "lang_Cd")
    private String languageCode;

    @Column(name = "phone_num")
    private String phoneNumber;

    @ApiModelProperty("member profile image name")
    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "login_type")
    private String loginType;

    @Column(name = "sns_token")
    private String snsToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "validation_img")
    private String validationImg;

    @Column(name = "is_accepted")
    private Boolean isAccepted;

    @Column(name = "photo_provided")
    private Boolean photoProvided;

    @Column(name = "state")
    private Integer state;

    // 권한: 유저-학생, ROLE_STUDENT
    // 유저-호스트,  ROLE_HOST
    // 관리자 ROLE_ADMIN

    @ManyToMany
    @JoinTable(
            name = "user_auth"
    )
    private Set<Authority> authorities;
}
/*
 validateID: {

         isPhotoIDProvided: `Boolean, optional default = false`,
        isAccepted: `Boolean, default = false`,
        }
  */