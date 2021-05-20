package com.j2kb.jibapi.domain.destination.dao;

import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.entity.Destination;

import java.util.List;

/**
 * Created by mkhwang on 2021/05/21
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public interface CustomDestinationRepository {

    List<String> findByDistinctCountry();
}
