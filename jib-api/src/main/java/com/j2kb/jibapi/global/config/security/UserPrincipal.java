package com.j2kb.jibapi.global.config.security;

import com.google.common.collect.ImmutableMap;
import com.j2kb.jibapi.domain.user.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
 * Created by mkhwang on 2021/06/02
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Data
public class UserPrincipal implements UserDetails, Serializable {

    private static final long serialVersionUID = -8257169965859984373L;

    private Long userNo;
    private String email;
    private String password;
    private String fistName;
    private String lastName;
    private String userType;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long userNo, String email, String password, String fistName, String lastName, String userType, Collection<? extends GrantedAuthority> authorities) {
        this.userNo = userNo;
        this.email = email;
        this.password = password;
        this.fistName = fistName;
        this.lastName = lastName;
        this.userType = userType;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        return new UserPrincipal(
                user.getUserNo()
                , user.getEmail()
                , user.getPassword()
                , user.getFirstName()
                , user.getLastName()
                , user.getUserType()
                , Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("ROLE_" + user.getUserType()))
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public Map<String,Object> toClaims(){
        return ImmutableMap.<String,Object>builder()
                .put("no", this.userNo)
                .put("email", this.email)
                .put("type", this.userType)
                .put("firstName", this.fistName)
                .put("lastName", this.lastName)
                .put("userType", this.userType)
                .put("authorities", this.authorities)
                .build();
    }
}
