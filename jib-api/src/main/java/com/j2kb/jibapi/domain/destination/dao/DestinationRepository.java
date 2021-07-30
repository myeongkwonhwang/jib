package com.j2kb.jibapi.domain.destination.dao;

import com.j2kb.jibapi.domain.destination.entity.Destination;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>, CustomDestinationRepository {
    List<Destination> findByCountryAndDstNoIsGreaterThanOrderByDstNoAsc(@Param("county") String country, @Param("id") Long lastId, Pageable pageRequest);
}
