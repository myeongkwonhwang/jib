package com.j2kb.jibapi.domain.user.dao;

import com.j2kb.jibapi.domain.user.entity.PasswordResetToken;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PasswordResetTokenRedisRepository extends CrudRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByEmail(String email);
}
