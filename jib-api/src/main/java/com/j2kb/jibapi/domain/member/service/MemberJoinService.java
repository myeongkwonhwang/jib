package com.j2kb.jibapi.domain.member.service;

import com.j2kb.jibapi.domain.member.dao.MemberRepository;
import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.entity.Member;
import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberJoinService extends BasicServiceSupport {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberJoinDto.BasicRes save(@RequestBody @Valid MemberJoinDto.BasicReq memberReq) {
        basicReqControlParams(memberReq);
        Member member = basicJoinReqToMember(memberReq);
        saveMember(member);
        return memberToBasicRes(member);
    }

    private void basicReqControlParams(MemberJoinDto.BasicReq memberReq) {
        memberReq.setPassword(bCryptPasswordEncoder.encode(memberReq.getPassword()));
    }

    private Member basicJoinReqToMember(MemberJoinDto.BasicReq memberReq) {
        Member member = modelMapper.map(memberReq, Member.class);
        return member;
    }

    private void saveMember(Member member) {
        memberRepository.save(member);
    }

    private MemberJoinDto.BasicRes memberToBasicRes(Member member) {
        return modelMapper.map(member, MemberJoinDto.BasicRes.class);
    }
}
