package com.j2kb.jibapi.domain.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import org.hamcrest.core.Is;
import org.hibernate.mapping.Join;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
@Transactional
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
        .firstName("hayeon")
        .lastName("kim")
        .loginType(LoginType.BASIC.getCode())
        .userType(UserType.STUDENT.getCode())
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
        //given
        JoinDto.BasicReq req = JoinDto.BasicReq.builder()
            .email("hayeon@gmail.com")
            .password("1111")
            .firstname("hayeon")
            .lastname("kim")
            .logintype(LoginType.BASIC)
            .usertype(UserType.STUDENT)
            .validationImg("img").build();


        JoinDto.BasicRes res = JoinDto.BasicRes.builder()
                .email("hayeon@gmail.com")
                .firstname("hayeon")
                .lastname("kim")
                .logintype(LoginType.BASIC)
                .usertype(UserType.STUDENT)
                .build();

        given(userJoinService.create(any())).willReturn(res);

        String json = objectMapper.writeValueAsString(req);
        System.out.println(json);

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

    @Test
    @DisplayName("기본회원삭제")
    public void deleteUser_test() throws Exception{

        User user = new User();
        user.setUserNo(1111);
        user.setState(1);
        user.setEmail("dahoon@gmail.com");

//        JoinDto.BasicReq req = JoinDto.BasicReq.builder()
//                .email("dahoon@gmail.com")
//                .password("12341234")
//                .firstname("dahoon")
//                .lastname("moon")
//                .logintype(LoginType.BASIC)
//                .usertype(UserType.STUDENT)
//                .validationImg("img")
//                .state(1).build();
//
//        JoinDto.BasicRes res = JoinDto.BasicRes.builder()
//                .email("hayeon@gmail.com")
//                .firstname("hayeon")
//                .lastname("kim")
//                .logintype(LoginType.BASIC)
//                .usertype(UserType.STUDENT)
//                .build();
//
//        given(userJoinService.create(any())).willReturn(res);
//        mvc.perform(post("/api/v1/user"))
//        when(userJoinService).thenReturn(userJoinService.delete(user.getUserNo()));
       final ResultActions resultActions =  mvc.perform(MockMvcRequestBuilders
               .delete("/api/v1/user/{id}", 1111)
               .contentType(MediaType.APPLICATION_JSON)
               .characterEncoding("utf-8"));

       resultActions.andDo(print())
               .andExpect(status().isOk());






//        given(userJoinService.delete(any())).willReturn();
//
//        final ResultActions res = mvc.perform(post("/api/v1/user").content());

    }


}