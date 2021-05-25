package com.j2kb.jibapi.domain.destination.entity;

import com.j2kb.jibapi.global.common.DateAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Entity
@Table(name = "destination")
@DynamicInsert
@DynamicUpdate
@ApiModel(value = "destination", description = "목적지") //swagger
@Data
public class Destination extends DateAudit implements Serializable {

    private static final long serialVersionUID = 730783540012762025L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("목적지 고유번호")
    @Column(name = "dst_no")
    private Long dstNo;

    @Column(name = "name")
    @ApiModelProperty("목적지 이름")
    private String name;

    @Column(name = "country")
    @ApiModelProperty("나라")
    private String country;

    @Column(name = "province")
    @ApiModelProperty("도/시/군")
    private String province;

    @Column(name = "city")
    @ApiModelProperty("시")
    private String city;

    @Column(name = "zip_code")
    @ApiModelProperty("우편번호")
    private String zipCode;

    @Column(name = "latitude")
    @ApiModelProperty("경도")
    private Double latitude;

    @Column(name = "longitude")
    @ApiModelProperty("위도")
    private Double longitude;

}
