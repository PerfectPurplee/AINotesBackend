package com.ainotes.backendainotes.repository;

import com.ainotes.backendainotes.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsernameAndLogin(String username, String login);
}
