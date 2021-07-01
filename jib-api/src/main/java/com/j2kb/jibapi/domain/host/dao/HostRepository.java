package com.j2kb.jibapi.domain.host.dao;

import com.j2kb.jibapi.domain.host.entity.Host;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface HostRepository extends CrudRepository<Host, String> {

}
