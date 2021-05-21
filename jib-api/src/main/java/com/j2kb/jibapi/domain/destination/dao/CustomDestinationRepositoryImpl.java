package com.j2kb.jibapi.domain.destination.dao;

import com.j2kb.jibapi.domain.destination.dto.DestinationDto;
import com.j2kb.jibapi.domain.destination.entity.Destination;
import com.j2kb.jibapi.domain.destination.entity.QDestination;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

/**
 * Created by mkhwang on 2021/05/21
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RequiredArgsConstructor
public class CustomDestinationRepositoryImpl implements CustomDestinationRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> findByDistinctCountry() {
        QDestination destination = QDestination.destination;
        return queryFactory.select(
                    Projections.constructor(String.class
                                    , destination.country.as("country")
                            )
                    )
                    .from(destination)
                    .groupBy(destination.country)
                    .fetch();
        }
}
