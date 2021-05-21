package com.j2kb.jibapi.domain.destination.service;

import com.j2kb.jibapi.domain.destination.dao.DestinationRepository;
import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.entity.Destination;
import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationService extends BasicServiceSupport {

    private final DestinationRepository destinationRepository;

    public DestinationDto.SaveRes create(DestinationDto.SaveReq saveReq) {
        Destination destination = destinationRepository.save(modelMapper.map(saveReq, Destination.class));
        return modelMapper.map(destination, DestinationDto.SaveRes.class);
    }

    public DestinationDto.SaveRes search(Long dstNo) {
        Destination destination = getDestinationByDstNo(dstNo);
        return modelMapper.map(destination, DestinationDto.SaveRes.class);
    }

    private Destination getDestinationByDstNo(Long dstNo) {
        Destination destination = destinationRepository.findById(dstNo).orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));
        return destination;
    }

    public DestinationDto.CountryRes searchCountries() {
        List<String> destinationList = destinationRepository.findByDistinctCountry();
        DestinationDto.CountryRes res = new DestinationDto.CountryRes(destinationList);
        return res;
    }
}
