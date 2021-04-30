package com.j2kb.jibapi.domain.member.service;

import com.j2kb.jibapi.domain.member.dao.MemberRepository;
import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@AllArgsConstructor
public class MemberJoinService {

    private MemberRepository memberRepository;

    private ModelMapper modelMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberJoinDto.BasicJoinRes save(MemberJoinDto.@Valid BasicJoinReq memberJoinReq) {
        memberJoinReq.setPassword(bCryptPasswordEncoder.encode(memberJoinReq.getPassword()));
        Member member = modelMapper.map(memberJoinReq, Member.class);
        memberRepository.save(member);
        MemberJoinDto.BasicJoinRes res = modelMapper.map(member, MemberJoinDto.BasicJoinRes.class);
        return res;
    }
}
