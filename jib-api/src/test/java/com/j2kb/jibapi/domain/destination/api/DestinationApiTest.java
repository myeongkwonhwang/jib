package com.j2kb.jibapi.domain.destination.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.service.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

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
class DestinationApiTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
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
    public void saveDestination_test() throws Exception {
        DestinationDto.SaveReq saveReq = DestinationDto.SaveReq.builder()
                .city("city")
                .country("country")
                .latitude(0.0)
                .longitude(0.0)
                .name("황명권")
                .province("province")
                .zipCode("zipCode")
                .build();

        String json = objectMapper.writeValueAsString(saveReq);

        mockMvc.perform(post("/api/v1/destination")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void search_destinationt_test() throws JsonProcessingException {
        DestinationDto.SaveReq saveReq = DestinationDto.SaveReq.builder()
                .city("city")
                .country("country")
                .latitude(0.0)
                .longitude(0.0)
                .name("황명권")
                .province("province")
                .zipCode("zipCode")
                .build();

        DestinationDto.SaveRes save = destinationService.create(saveReq);

        DestinationDto.SaveRes search = destinationService.search(save.getDstNo());

        System.out.println(search.toString());
    }

}