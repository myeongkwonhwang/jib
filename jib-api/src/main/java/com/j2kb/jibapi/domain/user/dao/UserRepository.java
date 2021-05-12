package com.j2kb.jibapi.domain.user.dao;

import com.j2kb.jibapi.domain.member.entity.Member;
import com.j2kb.jibapi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
