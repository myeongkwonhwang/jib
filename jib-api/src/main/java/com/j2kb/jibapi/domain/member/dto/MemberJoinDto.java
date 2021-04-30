package com.j2kb.jibapi.domain.member.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by mkhwang on 2021/05/01
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class MemberJoinDto {

    @Getter
    @Setter
    @ToString
    @Builder
    public static class BasicJoinReq {

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

        public BasicJoinReq() {}

        public BasicJoinReq(String memberId, String memberName, String password, String phoneNumber) {
            this.memberId = memberId;
            this.memberName = memberName;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class BasicJoinRes {

        private Integer memberNo;
        private String MemberId;
        private String MemberName;
        private String phoneNumber;
    }
}
