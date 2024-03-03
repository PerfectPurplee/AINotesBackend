package com.ainotes.backendainotes.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthenticationToken implements Authentication {

    private final String JwtToken;
    private final Object principal;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean authenticated;

    //    Before authentication
    private JwtAuthenticationToken(String JwtToken, Object principal, Collection<? extends GrantedAuthority> authorities) {
        this.JwtToken = JwtToken;
        this.principal = principal;
        this.authorities = authorities;
        this.authenticated = !CollectionUtils.isEmpty(authorities);
    }

    public static JwtAuthenticationToken authenticatedToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        return new JwtAuthenticationToken(null, principal, authorities);
    }

    public static JwtAuthenticationToken beforeAuthentication(String JwtToken) {
        return new JwtAuthenticationToken(JwtToken, null, Collections.emptyList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return JwtToken;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
