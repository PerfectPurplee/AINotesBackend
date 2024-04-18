package com.ainotes.backendainotes.service;

import com.ainotes.backendainotes.dto.authentication.LoginRequest;
import com.ainotes.backendainotes.dto.authentication.RegisterRequest;
import com.ainotes.backendainotes.model.Role;
import com.ainotes.backendainotes.model.User;
import com.ainotes.backendainotes.repository.RoleRepository;
import com.ainotes.backendainotes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;


    public UserDetails authenticate(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return (UserDetails) authentication.getPrincipal();

    }


    public void registerUser(RegisterRequest registerRequest) {

        String encodedPassword = encoder.encode(registerRequest.getPassword());
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userRole);

        userRepository.save(new User(registerRequest.getUsername(),
                encodedPassword, roleSet));

    }


}
