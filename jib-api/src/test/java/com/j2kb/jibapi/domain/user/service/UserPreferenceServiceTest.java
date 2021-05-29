package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.dao.UserPreferenceRepository;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.PreferenceDto;
import com.j2kb.jibapi.domain.user.entity.UserPreference;
import com.j2kb.jibapi.domain.user.enums.DistancePreference;
import com.j2kb.jibapi.domain.user.enums.HouseType;
import com.j2kb.jibapi.domain.user.enums.Preferences;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/05/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@SpringBootTest
@Transactional
class UserPreferenceServiceTest {

    @Autowired
    UserPreferenceService userPreferenceService;

    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;


    @BeforeEach
    public void beforeEach() {
        this.entityManager.createNativeQuery("ALTER TABLE user_preference ALTER COLUMN `prf_no` RESTART WITH 1")
                .executeUpdate();
    }

    @Test
    void UserPreferenceCreateTest(){

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

        //when
        userPreferenceService.create(userNo, req);

        Optional<UserPreference> userPreference = userPreferenceRepository.findById(1L);

        assertAll(
                () -> assertEquals(1L, userPreference.get().getPrfNo()),
                () -> assertEquals(userNo, userPreference.get().getUserNo())
        );
    }

}