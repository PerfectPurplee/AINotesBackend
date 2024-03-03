package com.ainotes.backendainotes.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationFilter extends AuthenticationFilter {

    public JwtAuthenticationFilter(@Lazy AuthenticationManager authenticationManager) {
        super(authenticationManager, JwtAuthenticationFilter::convert);
        super.setFailureHandler(JwtAuthenticationFilter::onFailure);
        super.setSuccessHandler(JwtAuthenticationFilter::onSuccess);
    }


    private static Authentication convert(HttpServletRequest request) {
        String headerValue = request.getHeader("Authorization");
        if (headerValue == null) {
            return null;
        }
        String token = headerValue.substring(7);
        return JwtAuthenticationToken.beforeAuthentication(token);
    }

    private static void onFailure(HttpServletRequest req, HttpServletResponse response, AuthenticationException ex) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    private static void onSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("AUthentication successful");
        response.setStatus(HttpStatus.OK.value());
    }
}
