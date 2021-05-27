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
@Table(name = "user_preference")
@ApiModel(value = "user_preference", description = "사용자 선호정보")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreference {

    @Id
    @ApiModelProperty(value = "사용자 추가정보 고유번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prf_no")
    private Long prfNo;

    @ApiModelProperty(value = "사용자 고유번호")
    @Column(name = "user_no")
    private Long userNo;

    @ApiModelProperty(value = "거리")
    @Column(name = "dstnt_prf")
    private String distancePreference;

    @ApiModelProperty(value = "집 유형")
    @Column(name = "house_type")
    private String houseType;

    @ApiModelProperty(value = "선호")
    @Column(name = "preference")
    private String preference;

}
