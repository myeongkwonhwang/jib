package com.j2kb.jibapi.domain.user.dao;

import com.j2kb.jibapi.domain.user.entity.PasswordResetToken;
import com.j2kb.jibapi.domain.user.entity.RefreshToken;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, Long> {
    Optional<PasswordResetToken> findByEmail(String email);
}
