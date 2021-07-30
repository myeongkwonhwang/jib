package com.j2kb.jibapi.domain.destination.service;

import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/06/01
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@SpringBootTest
@Slf4j
@Transactional
class DestinationServiceTest {

    @Autowired
    DestinationService destinationService;

    @Test
    void searchDestinationByCountryTest() {
        String country = "대한민국";
        List<DestinationDto.DestinationRes> destinationResList = destinationService.findDestinationByCountryOrderByNameAsc(country, 1L, 20);

        for (DestinationDto.DestinationRes res : destinationResList) {
            assertEquals(res.getCountry(), country);
        }
    }

    @Test
    void searchDestinationByCountryPagingTest() {
        String country = "Republic of Korea";
        List<DestinationDto.DestinationRes> destinationResList = destinationService.findDestinationByCountryOrderByNameAsc(country, 1L, 3);
        Assertions.assertThat(destinationResList.size()).isEqualTo(3);
    }

}