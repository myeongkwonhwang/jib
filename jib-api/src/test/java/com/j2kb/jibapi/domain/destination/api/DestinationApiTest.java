package com.j2kb.jibapi.domain.destination.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.service.DestinationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class DestinationApiTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Mock
    private DestinationService destinationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    public void createDestination_test() throws Exception {
        DestinationDto.SaveReq saveReq = DestinationDto.SaveReq.builder()
                .city("city")
                .country("country")
                .latitude(0.0)
                .longitude(0.0)
                .name("황명권")
                .province("province")
                .zipCode("zipCode")
                .build();

        DestinationDto.SaveRes res = DestinationDto.SaveRes.builder()
                .city("city")
                .country("country")
                .latitude(0.0)
                .longitude(0.0)
                .name("황명권")
                .province("province")
                .zipCode("zipCode")
                .build();

        given(destinationService.create(saveReq)).willReturn(res);

        String json = objectMapper.writeValueAsString(saveReq);

        // when
        final ResultActions actions = mockMvc.perform(post("/api/v1/destination")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"));

        actions.andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void searchCountries_test() throws Exception {
        DestinationDto.CountryRes res = DestinationDto.CountryRes.builder()
                .countries(
                        Arrays.asList(
                                "seoul"
                                , "daejeon"
                        )
                )
                .build();

        given(destinationService.searchCountries()).willReturn(res);

        final ResultActions actions = mockMvc.perform(get("/api/v1/destination/country"));

        actions.andExpect(status().isOk()).andReturn();
    }

}