package com.j2kb.jibapi.domain.member.service.impl;

import com.j2kb.jibapi.domain.member.dao.MemberRepository;
import com.j2kb.jibapi.domain.member.dto.request.MemberJoinReq;
import com.j2kb.jibapi.domain.member.dto.response.MemberJoinRes;
import com.j2kb.jibapi.domain.member.entity.Member;
import com.j2kb.jibapi.domain.member.service.MemberJoinService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@AllArgsConstructor
public class MemberJoinServiceImpl implements MemberJoinService {

    private MemberRepository memberRepository;

    private ModelMapper modelMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public MemberJoinRes saveMember(MemberJoinReq memberJoinReq) {
        memberJoinReq.setPassword(bCryptPasswordEncoder.encode(memberJoinReq.getPassword()));
        Member member = modelMapper.map(memberJoinReq, Member.class);
        memberRepository.save(member);
        MemberJoinRes memberJoinRes = modelMapper.map(member, MemberJoinRes.class);
        return memberJoinRes;
    }
}
