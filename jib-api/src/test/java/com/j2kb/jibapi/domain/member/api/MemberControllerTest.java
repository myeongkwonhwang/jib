package com.j2kb.jibapi.domain.member.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.member.dto.request.MemberJoinReq;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@NoArgsConstructor
@SpringBootTest
class MemberControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveMember_test() throws Exception {
        MemberJoinReq memberJoinReq = MemberJoinReq.builder()
                .memberId("orange2652@gmail.com")
                .memberName("황명권")
                .password("12345")
                .build();

        String json = objectMapper.writeValueAsString(memberJoinReq);

        mockMvc.perform(post("/v1/member")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}