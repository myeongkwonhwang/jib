package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.dao.PasswordResetTokenRedisRepository;
import com.j2kb.jibapi.domain.user.entity.PasswordResetToken;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PasswordResetService {
    private final PasswordResetTokenRedisRepository passwordResetTokenRedisRepository;


    public PasswordResetToken read(String email) {
        return passwordResetTokenRedisRepository.findByEmail(email)
            .orElseThrow(() -> new EntityNotFoundException("password link is not valid or already used"));
    }

    public void remove(PasswordResetToken token) {
        passwordResetTokenRedisRepository.delete(token);
    }
}
