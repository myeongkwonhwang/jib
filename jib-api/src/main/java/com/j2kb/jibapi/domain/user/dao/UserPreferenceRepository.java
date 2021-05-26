package com.j2kb.jibapi.domain.user.dao;

import com.j2kb.jibapi.domain.user.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mkhwang on 2021/05/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
}
