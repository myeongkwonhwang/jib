package com.j2kb.jibapi.domain.user.dao;

import com.j2kb.jibapi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserNo(Long userNo);
}
