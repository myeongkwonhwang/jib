package com.j2kb.jibapi.domain.destination.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("목적지 고유번호")
    @Column(name = "dst_no")
    private Long dstno;

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

    @Column(name = "created_at")
    @ApiModelProperty("작성일")
    private Date createdAt;

    @Column(name = "updated_at")
    @ApiModelProperty("수정일")
    private Date updatedAt;

}
