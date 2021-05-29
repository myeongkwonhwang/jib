package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.enums.DistancePreference;
import com.j2kb.jibapi.domain.user.enums.HouseType;
import com.j2kb.jibapi.domain.user.enums.Preferences;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by mkhwang on 2021/05/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class PreferenceDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class saveReq {

        private DistancePreference distancePreference;

        private HouseType houseType;

        private List<Preferences> preferences;

    }
}
