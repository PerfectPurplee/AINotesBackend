package com.ainotes.backendainotes.service;

import com.ainotes.backendainotes.dto.RegisterRequest;
import com.ainotes.backendainotes.model.Role;
import com.ainotes.backendainotes.model.User;
import com.ainotes.backendainotes.repository.RoleRepository;
import com.ainotes.backendainotes.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserReqistratiotionAuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;

    @Autowired
    public UserReqistratiotionAuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public void registerUser(RegisterRequest registerRequest) {

        String encodedPassword = encoder.encode(registerRequest.getPassword());
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userRole);

        userRepository.save(new User(registerRequest.getUsername(),
                registerRequest.getLogin(), encodedPassword, roleSet));

    }


}
