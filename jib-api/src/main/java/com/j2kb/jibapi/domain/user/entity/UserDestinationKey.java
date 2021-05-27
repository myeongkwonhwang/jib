package com.j2kb.jibapi.domain.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by mkhwang on 2021/05/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDestinationKey implements Serializable {

    private static final long serialVersionUID = -2668764038037290392L;

    @NotBlank
    @ApiModelProperty(value = "사용자 고유번호")
    private Long userNo;

    @NotBlank
    @ApiModelProperty(value = "목적지 고유번호")
    private Long dstNo;
}
