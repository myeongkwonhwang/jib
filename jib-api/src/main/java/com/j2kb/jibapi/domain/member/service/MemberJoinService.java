package com.j2kb.jibapi.domain.member.service;

import com.j2kb.jibapi.domain.member.dto.request.MemberJoinReq;
import com.j2kb.jibapi.domain.member.dto.response.MemberJoinRes;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public interface MemberJoinService {

    MemberJoinRes saveMember(MemberJoinReq memberJoinReq);

}
