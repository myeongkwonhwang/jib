package com.j2kb.jibapi.domain.user.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.user.dto.UserDto;
import com.j2kb.jibapi.domain.user.dto.UserJoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
class UserApiTest {

    @Autowired
    private MockMvc mvc;

    //@MockBean
    private UserJoinService userJoinService;

    @Autowired
    private ObjectMapper objectMapper;

    List<UserJoinDto.BasicRes> mockUsers = new ArrayList<>();

    UserJoinDto.BasicReq mockUser = UserJoinDto.BasicReq.builder()
            .email("hayeon@gmail.com")
            .password("1111")
            .firstName("hayeon")
            .lastName("kim")
            .loginType(UserJoinDto.LoginType.BASIC)
            .userType(UserDto.UserType.STUDENT)
            .build();

    UserJoinDto.BasicRes mockUserRes = UserJoinDto.BasicRes.builder()
            .email("hayeon@gmail.com")
            .firstName("hayeon")
            .lastName("kim")
            .loginType(UserJoinDto.LoginType.BASIC)
            .userType(UserDto.UserType.STUDENT)
            .build();


    @BeforeEach
    public void setup(@Autowired UserApi userApi){
        mvc = MockMvcBuilders.standaloneSetup(userApi).build();

        mockUsers.add(mockUserRes);
    }


    @Test
    @DisplayName("기본 회원 가입")
    public void saveUser_test() throws Exception {
        // given
        UserJoinDto.BasicReq req = UserJoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .password("1111")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(UserJoinDto.LoginType.BASIC)
                .userType(UserDto.UserType.STUDENT)
                .build();

        UserJoinDto.BasicRes res = UserJoinDto.BasicRes.builder()
                .email("hayeon@gmail.com")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(UserJoinDto.LoginType.BASIC)
                .userType(UserDto.UserType.STUDENT)
                .build();

        String json = objectMapper.writeValueAsString(req);
        String resJson = objectMapper.writeValueAsString(res);

        //given(userJoinService.create(any())).willReturn(mockUserRes);

        // when
        final ResultActions actions = mvc.perform(post("/api/v1/user")
                .content(objectMapper.writeValueAsString(mockUser))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"));

        // then
        actions
                .andDo(print())  // 요청 & 응답 내용 출력
                .andExpect(status().isOk());
                //.andExpect(content().string(containsString("")));
    }

}