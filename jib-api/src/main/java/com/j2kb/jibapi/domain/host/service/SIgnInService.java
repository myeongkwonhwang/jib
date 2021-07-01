package com.j2kb.jibapi.domain.host.service;

import com.j2kb.jibapi.domain.host.dao.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SIgnInService {
    private final HostRepository hostRepository;


}
