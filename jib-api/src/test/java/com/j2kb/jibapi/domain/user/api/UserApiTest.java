package com.j2kb.jibapi.domain.user.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.dto.PreferenceDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.*;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import com.j2kb.jibapi.domain.user.service.UserPreferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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

    @Mock
    private UserPreferenceService userPreferenceService;

    @Autowired
    private ObjectMapper objectMapper;

    List<User> mockUsers = new ArrayList<>();

    User mockUser = User.builder()
        .email("hayeon@gmail.com")
        .password("1111")
        .firstName("hayeon")
        .lastName("kim")
        .loginType(LoginType.BASIC.getName())
        .userType(UserType.STUDENT.getName())
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
            .firstName("hayeon")
            .lastName("kim")
            .loginType(LoginType.BASIC)
            .userType(UserType.STUDENT).build();

        JoinDto.BasicRes res = JoinDto.BasicRes.builder()
                .email("hayeon@gmail.com")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT)
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
        user.setUserNo(1111L);
        user.setState(StateType.ACTIVE.getName());
        user.setEmail("dahoon@gmail.com");

       final ResultActions resultActions =  mvc.perform(MockMvcRequestBuilders
               .delete("/api/v1/user/{id}", 1111)
               .contentType(MediaType.APPLICATION_JSON)
               .characterEncoding("utf-8"));

       resultActions.andDo(print())
               .andExpect(status().isOk());

    }

    @Test
    @DisplayName("사용자 선호사항 입력")
    public void userPreferenceCreateTest() throws Exception {
        //given
        PreferenceDto.saveReq req =
                PreferenceDto.saveReq.builder()
                        .distancePreference(DistancePreference.TEN)
                        .houseType(HouseType.ENTIRE)
                        .preferences(Arrays.asList(
                                Preferences.CLEAN,
                                Preferences.FOOD,
                                Preferences.PETS
                        ))
                        .build();
        Long userNo = 1L;

        String saveReq = objectMapper.writeValueAsString(req);

        // when
        final ResultActions actions = mvc.perform(post("/api/v1/user/{userNo}/preference", userNo)
                .content(saveReq)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"));

        // then
        actions
                .andDo(print())  // 요청 & 응답 내용 출력
                .andExpect(status().isOk());

    }



}