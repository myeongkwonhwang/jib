package com.j2kb.jibapi.global.config.security;

import com.j2kb.jibapi.domain.user.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by mkhwang on 2021/06/02
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Data
public class UserPrincipal implements UserDetails, Serializable {

    private static final long serialVersionUID = -8257169965859984373L;

    private String email;
    private String password;
    private String fistName;
    private String lastName;
    private String userType;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String email, String password, String fistName, String lastName, String userType, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.fistName = fistName;
        this.lastName = lastName;
        this.userType = userType;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        return new UserPrincipal(
                user.getEmail()
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
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
