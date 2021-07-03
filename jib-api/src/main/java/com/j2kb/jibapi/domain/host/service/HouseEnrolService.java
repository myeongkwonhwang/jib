package com.j2kb.jibapi.domain.host.service;

import com.j2kb.jibapi.domain.host.dao.HostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseEnrolService {

    public final HostRepository hostRepository;


}
