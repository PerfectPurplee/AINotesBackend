package com.ainotes.backendainotes.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String username;
    private String login;
    private String password;
    private String mail;

    public User(String username, String login, String password, String mail) {
        this.username = username;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }


    public User() {

    }
}
