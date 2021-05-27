package com.j2kb.jibapi.domain.jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javassist.Loader.Simple;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class JwtUser extends User {

    private static final long serialVersionUID = 1L;

    private com.j2kb.jibapi.domain.user.entity.User user;

    public JwtUser(String username, String password,
        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public JwtUser(String username, String password, boolean enabled, boolean accountNonExpired,
        boolean credentialsNonExpired, boolean accountNonLocked,
        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
            accountNonLocked,
            authorities);
    }

    public JwtUser(com.j2kb.jibapi.domain.user.entity.User user) {
        super(user.getEmail(), user.getPassword(), getAuthorities(user));

        this.user = user;
    }

    public static List<? extends GrantedAuthority> getAuthorities(com.j2kb.jibapi.domain.user.entity.User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
        return authorities;
    }

    public JwtUser(com.j2kb.jibapi.domain.user.entity.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }
}
