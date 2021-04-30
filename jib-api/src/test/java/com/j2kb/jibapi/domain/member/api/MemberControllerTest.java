package com.j2kb.jibapi.domain.member.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@AutoConfigureMockMvc
@SpringBootTest
class MemberControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveMember_test() throws Exception {
        MemberJoinDto.BasicJoinReq req = MemberJoinDto.BasicJoinReq.builder()
                .memberId("orange2652@gmail.com")
                .memberName("황명권")
                .password("12345")
                .build();

        String json = objectMapper.writeValueAsString(req);

        mockMvc.perform(post("/api/v1/member")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}