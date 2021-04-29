package com.j2kb.jibapi.domain.member.dao;

import com.j2kb.jibapi.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
