package com.j2kb.jibapi.domain.member.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinReq {

    @NotNull
    @Email
    @ApiModelProperty("member Id")
    private String memberId;

    @NotNull
    @ApiModelProperty("member Name")
    private String memberName;

    @NotNull
    @ApiModelProperty("password")
    private String password;

    @ApiModelProperty("phone Number")
    private String phoneNumber;

}
