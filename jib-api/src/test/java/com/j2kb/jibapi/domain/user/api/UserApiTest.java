package com.j2kb.jibapi.domain.user.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@AutoConfigureMockMvc
@SpringBootTest
class UserApiTest {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserJoinService userJoinService;

    @Autowired
    private ObjectMapper objectMapper;

    List<User> mockUsers = new ArrayList<>();

    User mockUser = User.builder()
        .email("hayeon@gmail.com")
        .password("1111")
        .firstname("hayeon")
        .lastname("kim")
        .logintype(LoginType.BASIC.getCode())
        .usertype(UserType.STUDENT.getCode())
        .validationImg("img")
        .build();

    @BeforeEach
    public void setup(@Autowired UserApi userApi){
        mvc = MockMvcBuilders.standaloneSetup(userApi).build();
        mockUsers.add(mockUser);
    }

    @Test
    @DisplayName("기본 회원 가입")
    public void saveUser_test() throws Exception {
        // given
        JoinDto.BasicReq req = JoinDto.BasicReq.builder()
            .email("hayeon@gmail.com")
            .password("1111")
            .firstname("hayeon")
            .lastname("kim")
            .logintype(LoginType.BASIC)
            .usertype(UserType.STUDENT)
            .validationImg("img").build();

        String json = objectMapper.writeValueAsString(req);

        JoinDto.BasicRes res = JoinDto.BasicRes.of(mockUser);

        given(userJoinService.create(any(JoinDto.BasicReq.class))).willReturn(res);

        // when
        final ResultActions actions = mvc.perform(post("/api/v1/user")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"));

        // then
        actions
                .andDo(print())  // 요청 & 응답 내용 출력
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hayeon")));
    }

}