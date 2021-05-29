package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserPreferenceRepository;
import com.j2kb.jibapi.domain.user.dto.PreferenceDto;
import com.j2kb.jibapi.domain.user.entity.UserPreference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mkhwang on 2021/05/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserPreferenceService extends BasicServiceSupport {

    private final UserPreferenceRepository userPreferenceRepository;

    public void create(Long userNo, PreferenceDto.saveReq saveReq) {
        UserPreference userPreference = modelMapper.map(saveReq, UserPreference.class);
        userPreference.setUserNo(userNo);

        convertPreFerencesArrayToString(saveReq, userPreference);
        userPreferenceRepository.save(userPreference);
    }

    private void convertPreFerencesArrayToString(PreferenceDto.saveReq saveReq, UserPreference userPreference) {
        if(saveReq.getPreferences() != null){
            String preferences = saveReq.getPreferences().stream()
                    .map(e -> e.getName())
                    .collect(Collectors.joining(", "));
            userPreference.setPreference(preferences);
        }
    }
}
