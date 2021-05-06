package com.j2kb.jibapi.domain.member.service;

import com.j2kb.jibapi.domain.member.dao.MemberRepository;
import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.entity.Member;
import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Slf4j
public class MemberJoinService extends BasicServiceSupport {

    private final MemberRepository memberRepository;

    public MemberJoinDto.BasicJoinRes save(@RequestBody @Valid MemberJoinDto.BasicJoinReq memberJoinReq) {
        BasicJoinReqControlParams(memberJoinReq);
        Member member = BasicJoinReqToMember(memberJoinReq);
        saveMember(member);
        return memberToBasicJoinRes(member);
    }

    private void BasicJoinReqControlParams(MemberJoinDto.BasicJoinReq memberJoinReq) {
        memberJoinReq.setPassword(bcryptEnc(memberJoinReq.getPassword()));
    }

    private Member BasicJoinReqToMember(MemberJoinDto.BasicJoinReq memberJoinReq) {
        Member member = modelMapper.map(memberJoinReq, Member.class);
        return member;
    }

    private void saveMember(Member member) {
        memberRepository.save(member);
    }

    private MemberJoinDto.BasicJoinRes memberToBasicJoinRes(Member member) {
        log.debug(member.getMemberName());
        return modelMapper.map(member, MemberJoinDto.BasicJoinRes.class);
    }
}
