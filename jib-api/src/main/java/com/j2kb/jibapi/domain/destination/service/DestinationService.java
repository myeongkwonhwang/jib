package com.j2kb.jibapi.domain.destination.service;

import com.j2kb.jibapi.domain.destination.dao.DestinationRepository;
import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.entity.Destination;
import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
public class DestinationService extends BasicServiceSupport {

    private final DestinationRepository destinationRepository;

    public DestinationDto.SaveRes create(DestinationDto.SaveReq saveReq) {
        Destination destination = saveReqToDestination(saveReq);
        saveDestination(destination);
        return destinationToSaveRes(destination);
    }

    private DestinationDto.SaveRes destinationToSaveRes(Destination destination) {
        return modelMapper.map(destination, DestinationDto.SaveRes.class);
    }

    private void saveDestination(Destination destination) {
        destinationRepository.save(destination);
    }

    private Destination saveReqToDestination(DestinationDto.SaveReq saveReq) {
        Destination destination = modelMapper.map(saveReq, Destination.class);
        return destination;
    }

    public DestinationDto.SaveRes search(Long dstNo) {
        return destinationToSaveRes(getDestinationByDstNo(dstNo));
    }

    private Destination getDestinationByDstNo(Long dstNo) {
        Optional<Destination> destinationOp = destinationRepository.findById(dstNo);
        if(destinationOp.isEmpty()) throw new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND);

        return destinationOp.get();
    }
}
