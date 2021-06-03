package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.util.MailUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    private String getAuthCode(int size) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        int num;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }

    /**
     * 인증 메일 보내기
     */
    public String sendAuthMail(String email) {
        //6자리 난수 인증번호 생성
        String authKey = getAuthCode(6);

        //인증메일 보내기
        try {
            MailUtils sendMail = new MailUtils(mailSender);
            sendMail.setSubject("Password Reset");
            sendMail.setText(new StringBuilder().append("<h1>[Email Authentication]</h1>").append("<p>Click link below to authenticate your email.</p>")
                .append("<a href='http://localhost:8080/auth/mailConfirm?email=").append(email).append("&authKey=").append(authKey)
                .append("' target='_blenk'>Reset Password</a>").toString());
            sendMail.setFrom("jibj2kb@gmail.com", "JIB");
            sendMail.setTo(email);
            sendMail.send();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return authKey;
    }
}
