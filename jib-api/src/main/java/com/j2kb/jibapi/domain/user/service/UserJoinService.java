package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinDto.BasicRes create(@RequestBody @Valid JoinDto.BasicReq userReq) {
        controlParams(userReq);
        User user = modelMapper.map(userReq, User.class);
        user.setValidationImg(userReq.getValidationImg().getBytes(StandardCharsets.UTF_8));
        return modelMapper.map(userRepository.save(user), JoinDto.BasicRes.class);
    }

    private void controlParams(JoinDto.BasicReq userReq) {
        userReq.setPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));
    }

    public User getUserByUserno(Integer userno) {
        Optional<User> user = userRepository.findById(userno);
        if(user.isEmpty()) throw new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND);
        return user.get();
    }

    public SuccessResponse delete(Integer userNo){
        User user = getUserByUserno(userNo);
        user.setState(0);
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public JoinDto.BasicRes addAdditionalInfo(JoinDto.StudentReq studentReq) {
        User user = userRepository.findById(studentReq.getUserNo())
                .orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));
        user.setValidationImg(studentReq.getValidationImg());
        user.setDstNo(studentReq.getDstNo());
        user.setPhotoProvided(true);
        return JoinDto.BasicRes.of(userRepository.save(user));
    }
}// no
// can you hear me?? omg
//wait
// i hear you
// 슈우우욱(올라가는소리) 하다가 다시 슈우욱(내려가는소리) 해요
// no
// i think we have to stop ㅋㅋㅋㅋㅋ
// 지금 해야 할 것..
// - 회원 수정    update
// - 회원 조회    search -> what? 내정보보기 같은 느낌? response로 모든 정보를 주나요?
// 전부다는 아니고 필요한 정보만 주면 될 것 같아요 (근데 마이페이지가 피그마에 아직 안나와서..)
// (하지만 나가야할 정보는 언제든지 변경할 수 있기 때문에 로직은 만들어두어도 괜찬흥ㄹ 것 같습니다)
// 일단 유저 CRUD를 완성하자는 의미에서 
// user info 는 추후에 redis등이나 그냥 Header에 저장해두고 쓰는 식으로 가도 될 것 같습니다. 넹!
// - 비밀번호 찾기  방법이 있는 것 같아요 라이브러리르 써야 할 듯
// 는이// - 로그인 + 소셜로그인 (두개는 거의 비슷) -> jwt toㅇ이ㅇㅇ 토큰 생성 토큰 valida다ㄷ깢ㄲㅉㅇ토크
// 로그인은 할일이 ㅁ낳다.


// 골라보세요..
// 저는 로그인이나 비밀번호 찾기 중 하나 하겠습니다
// good good
// coding test?? algorithms ??
// oh i agree
// then let's make the function and later let's write test codes together
//then i will choose user update and search
//
// yeah let's ask myung
// ok i'm gonna commit now